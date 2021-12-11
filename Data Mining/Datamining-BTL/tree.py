# coding:utf-8

from math import log
import operator
import treePlotter
from collections import Counter


pre_pruning = True
post_pruning = True


def read_dataset(filename):
    """
        Độ tuổi: 0 nghĩa là tuổi trẻ, 1 nghĩa là trung niên, 2 nghĩa là tuổi già;
        Có một công việc: 0 có nghĩa là không, 1 có nghĩa là có;
        Có nhà riêng của bạn: 0 có nghĩa là không, 1 có nghĩa là có;
        Trạng thái tín dụng: 0 có nghĩa là công bằng, 1 có nghĩa là tốt, 2 có nghĩa là rất tốt;
        Loại (có cho vay hay không): 0 nghĩa là không, 1 nghĩa là có
    """
    fr = open(filename, 'r')
    all_lines = fr.readlines()  # list Biểu mẫu, 1 trên mỗi dòng str
    # print all_lines
    labels = ['generation', 'have_a_job', 'Own_house', 'Credit_status']
    # featname=all_lines[0].strip().split(',')  #list mẫu đơn
    # featname=featname[:-1]
    labelCounts = {}
    dataset = []
    for line in all_lines[0:]:
        line = line.strip().split(',')  # Tách danh sách bằng dấu phẩy làm dấu phân cách
        dataset.append(line)
    return dataset, labels


def read_testset(testfile):
    """
        Độ tuổi: 0 nghĩa là tuổi trẻ, 1 nghĩa là trung niên, 2 nghĩa là tuổi già;
        Có một công việc: 0 có nghĩa là không, 1 có nghĩa là có;
        Có nhà riêng của bạn: 0 có nghĩa là không, 1 có nghĩa là có;
        Trạng thái tín dụng: 0 có nghĩa là công bằng, 1 có nghĩa là tốt, 2 có nghĩa là rất tốt;
        Loại (có cho vay hay không): 0 nghĩa là không, 1 nghĩa là có
    """
    fr = open(testfile, 'r')
    all_lines = fr.readlines()
    testset = []
    for line in all_lines[0:]:
        line = line.strip().split(',')  # Split the list with a comma as a separator
        testset.append(line)
    return testset


# Tính toán entropy thông tin
def cal_entropy(dataset):
    numEntries = len(dataset)
    labelCounts = {}
    #Tạo từ điển cho tất cả các danh mục có thể
    for featVec in dataset:
        currentlabel = featVec[-1]
        if currentlabel not in labelCounts.keys():
            labelCounts[currentlabel] = 0
        labelCounts[currentlabel] += 1
    Ent = 0.0
    for key in labelCounts:
        p = float(labelCounts[key]) / numEntries
        Ent = Ent - p * log(p, 2)  # Logarit đến cơ số 2
    return Ent


# Phân chia tập dữ liệu
def splitdataset(dataset, axis, value):
    retdataset = []  # Tạo danh sách các tập dữ liệu trả về
    for featVec in dataset:  # Trích xuất các giá trị đáp ứng các đặc điểm phân vùng
        if featVec[axis] == value:
            reducedfeatVec = featVec[:axis]  # Loại bỏ tính năng axis
            reducedfeatVec.extend(featVec[axis + 1:])  # Thêm các tính năng đủ điều kiện vào danh sách tập dữ liệu trả về
            retdataset.append(reducedfeatVec)
    return retdataset

# CART算法
def CART_chooseBestFeatureToSplit(dataset):
    numFeatures = len(dataset[0]) - 1
    bestGini = 999999.0
    bestFeature = -1
    for i in range(numFeatures):
        featList = [example[i] for example in dataset]
        uniqueVals = set(featList)
        gini = 0.0
        for value in uniqueVals:
            subdataset = splitdataset(dataset, i, value)
            p = len(subdataset) / float(len(dataset))
            subp = len(splitdataset(subdataset, -1, '0')) / float(len(subdataset))
        gini += p * (1.0 - pow(subp, 2) - pow(1 - subp, 2))
        print(u"Giá trị Gini của tính năng %d trong CART：%.3f" % (i, gini))
        if (gini < bestGini):
            bestGini = gini
            bestFeature = i
    return bestFeature


def majorityCnt(classList):
    '''
    Tập dữ liệu đã xử lý tất cả các thuộc tính, nhưng nhãn lớp vẫn không phải là duy nhất,
     Lúc này chúng ta cần quyết định cách xác định nút lá, trong trường hợp này, chúng ta
     thường sử dụng phương pháp biểu quyết đa số để xác định phân loại của nút lá.
    '''
    classCont = {}
    for vote in classList:
        if vote not in classCont.keys():
            classCont[vote] = 0
        classCont[vote] += 1
    sortedClassCont = sorted(classCont.items(), key=operator.itemgetter(1), reverse=True)
    return sortedClassCont[0][0]

def CART_createTree(dataset, labels, test_dataset):
    classList = [example[-1] for example in dataset]
    if classList.count(classList[0]) == len(classList):
        # Các danh mục hoàn toàn giống nhau, ngừng phân chia
        return classList[0]
    if len(dataset[0]) == 1:
        # Sau khi xem qua tất cả các tính năng, hãy trả lại sự xuất hiện thường xuyên nhất
        return majorityCnt(classList)
    bestFeat = CART_chooseBestFeatureToSplit(dataset)
    # print(u"At this time, the optimal index is："+str(bestFeat))
    bestFeatLabel = labels[bestFeat]
    print(u"At this time, the optimal index is：" + (bestFeatLabel))
    CARTTree = {bestFeatLabel: {}}
    del (labels[bestFeat])
    # Get the list including all the attribute values of the node
    featValues = [example[bestFeat] for example in dataset]
    uniqueVals = set(featValues)

    if pre_pruning:
        ans = []
        for index in range(len(test_dataset)):
            ans.append(test_dataset[index][-1])
        result_counter = Counter()
        for vec in dataset:
            result_counter[vec[-1]] += 1
        leaf_output = result_counter.most_common(1)[0][0]
        root_acc = cal_acc(test_output=[leaf_output] * len(test_dataset), label=ans)
        outputs = []
        ans = []
        for value in uniqueVals:
            cut_testset = splitdataset(test_dataset, bestFeat, value)
            cut_dataset = splitdataset(dataset, bestFeat, value)
            for vec in cut_testset:
                ans.append(vec[-1])
            result_counter = Counter()
            for vec in cut_dataset:
                result_counter[vec[-1]] += 1
            leaf_output = result_counter.most_common(1)[0][0]
            outputs += [leaf_output] * len(cut_testset)
        cut_acc = cal_acc(test_output=outputs, label=ans)

        if cut_acc <= root_acc:
            return leaf_output

    for value in uniqueVals:
        subLabels = labels[:]
        CARTTree[bestFeatLabel][value] = CART_createTree(
            splitdataset(dataset, bestFeat, value),
            subLabels,
            splitdataset(test_dataset, bestFeat, value))

        if post_pruning:
            tree_output = classifytest(CARTTree,
                                       featLabels=['generation', 'have_a_job', 'Own_house', 'Credit_status'],
                                       testDataSet=test_dataset)
            ans = []
            for vec in test_dataset:
                ans.append(vec[-1])
            root_acc = cal_acc(tree_output, ans)
            result_counter = Counter()
            for vec in dataset:
                result_counter[vec[-1]] += 1
            leaf_output = result_counter.most_common(1)[0][0]
            cut_acc = cal_acc([leaf_output] * len(test_dataset), ans)

            if cut_acc >= root_acc:
                return leaf_output

    return CARTTree


def classify(inputTree, featLabels, testVec):
    """
    Đầu vào: cây quyết định, nhãn phân loại, dữ liệu thử nghiệm
    Đầu ra: kết quả quyết định
    Mô tả: Chạy cây quyết định
    """
    firstStr = list(inputTree.keys())[0]
    secondDict = inputTree[firstStr]
    featIndex = featLabels.index(firstStr)
    classLabel = '0'
    for key in secondDict.keys():
        if testVec[featIndex] == key:
            if type(secondDict[key]).__name__ == 'dict':
                classLabel = classify(secondDict[key], featLabels, testVec)
            else:
                classLabel = secondDict[key]
    return classLabel


def classifytest(inputTree, featLabels, testDataSet):
    """
        Đầu vào: cây quyết định, nhãn phân loại, tập dữ liệu thử nghiệm
        Đầu ra: kết quả quyết định
        Mô tả: Chạy cây quyết định
    """
    classLabelAll = []
    for testVec in testDataSet:
        classLabelAll.append(classify(inputTree, featLabels, testVec))
    return classLabelAll


def cal_acc(test_output, label):
    """
    :param test_output: the output of testset
    :param label: the answer
    :return: the acc of
    """
    assert len(test_output) == len(label)
    count = 0
    for index in range(len(test_output)):
        if test_output[index] == label[index]:
            count += 1

    return float(count / len(test_output))


if __name__ == '__main__':
    filename = 'dataset.txt'
    testfile = 'testset.txt'
    dataset, labels = read_dataset(filename)
    # dataset,features=createDataSet()
    print('dataset', dataset)
    print("---------------------------------------------")
    print(u"Độ dài tập dữ liệu", len(dataset))
    print("Ent(D):", cal_entropy(dataset))
    print("---------------------------------------------")

    print("--------------------------------------------------")
    print(u"Chỉ số tính năng tối ưu của thuật toán CART là :" + str(CART_chooseBestFeatureToSplit(dataset)))
    print(u"Kết thúc tìm kiếm chỉ mục tốt nhất cho lần đầu tiên!")
    print("---------------------------------------------")

    print(u"Hãy bắt đầu tạo cây quyết định tương ứng -------")

    while True:
        dec_tree = '3'
        # ID3决策树
        # if dec_tree == '1':
        #     labels_tmp = labels[:]  # 拷贝，createTree会改变labels
        #     ID3desicionTree = ID3_createTree(dataset, labels_tmp, test_dataset=read_testset(testfile))
        #     print('ID3desicionTree:\n', ID3desicionTree)
        #     # treePlotter.createPlot(ID3desicionTree)
        #     treePlotter.ID3_Tree(ID3desicionTree)
        #     testSet = read_testset(testfile)
        #     print("下面为测试数据集结果：")
        #     print('ID3_TestSet_classifyResult:\n', classifytest(ID3desicionTree, labels, testSet))
        #     print("---------------------------------------------")

        # CART Decision tree
        if dec_tree == '3':
            labels_tmp = labels[:]  # Copy, createTree sẽ thay đổi nhãn
            CARTdesicionTree = CART_createTree(dataset, labels_tmp, test_dataset=read_testset(testfile))
            print('CART desicion Tree:\n', CARTdesicionTree)
            treePlotter.CART_Tree(CARTdesicionTree)
            testSet = read_testset(testfile)
            print("Sau đây là kết quả của tập dữ liệu thử nghiệm:")
            print('CART_TestSet_classifyResult:\n', classifytest(CARTdesicionTree, labels, testSet))

        break
