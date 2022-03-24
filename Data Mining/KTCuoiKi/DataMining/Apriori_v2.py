from prettytable import PrettyTable
import math
from itertools import combinations

file_name = './Data/inputApriori.txt'
min_sup_0 = 0
min_sup = 0
min_conf = 0
count = 0


class Item:
    def __init__(self, items):
        self.items = sorted(items)

    # số item trong list_item có chứa self.items
    def sup_count(self):
        sup_count_ = 0
        for i in items_bought:
            var_count_ = 0  # số item có trong cả self.items và list_item[i]
            for j in set(i):
                if j in self.items:
                    var_count_ += 1
            if var_count_ == len(self.items):
                sup_count_ += 1
        return sup_count_

    def __copy__(self):
        items_ = list(self.items).copy()
        return Item(items_)


def read_file_input():
    global min_sup, min_conf
    f = open(file_name, 'r')
    min_sup = int(f.readline().split(' ')[2])
    min_conf = int(f.readline().split(' ')[2])
    items_bought_ = list()
    while True:
        item_bought_ = f.readline().rstrip('\n').split(',')
        # Loại bỏ khoảng trắng và dừng đọc file khi găp end
        if '' in item_bought_:
            if len(item_bought_) == 1:
                break
            item_bought_.remove('')
        # add item_bought_ in items_bought_
        items_bought_.append(item_bought_)
    # min_conf = math.ceil(min_conf_ * count / 100)
    f.close()
    return items_bought_


def find_items_alpha_b():
    items_alpha_b_ = set()
    for items in items_bought:
        for item in items:
            items_alpha_b_.add(item)
    return sorted(items_alpha_b_)


def fill_items_c(items_alpha_b_):
    items_c_ = list()
    for item_ in items_alpha_b_:
        items_c_.append(Item(item_))
    return items_c_


def fill_items_l(items_c_):
    count_min_sup = math.ceil(min_sup * len(items_bought) / 100)
    items_l_ = list()
    for item in items_c_:
        if item.sup_count() >= count_min_sup:
            items_l_.append(item.__copy__())
    return items_l_


def create_items_c(items_l_):
    items_c_ = list()
    size = len(items_l_)
    size2 = len(items_l_[0].items) + 1
    for i_ in range(size):
        for j_ in range(i_ + 1, size):
            items_ = set()
            # tạo items_ mới
            for k_ in items_l_[i_].items:
                items_.add(k_)
            for k_ in items_l_[j_].items:
                items_.add(k_)
            # sắp xếp alpha-b và convert set -> list
            items_ = list(sorted(items_))
            # kiểm tra items_ có các tập con đều thuộc L
            if len(items_) == size2:
                var_ = 0
                for k_ in items_:
                    for item in items_l_:
                        items_var_ = items_.copy()
                        items_var_.remove(k_)
                        if items_var_ == item.items:
                            var_ += 1
                if var_ == size2:
                    is_not_in_c = True
                    # kiểm tra items_ đã có trong C chưa
                    for item_ in items_c_:
                        if item_.items == items_:
                            is_not_in_c = False
                            break
                    if is_not_in_c:
                        items_c_.append(Item(items_))
    return items_c_


def show(name_, c_or_l):
    t = PrettyTable(['Item', 'SUP_count'])
    for item in c_or_l:
        item_ = item.items[0]
        for i_ in range(1, len(item.items)):
            item_ += ', ' + item.items[i_]
        t.add_row([item_, item.sup_count()])
    print('------------ {} ------------'.format(name_))
    print(t)


# liệt kê các tập con của list có num_ phần tử
def find_subsets(list_, num_):
    return sorted(set(combinations(list_, num_)))


def find_rules(item_):
    arr_rules_ = list()
    size_item_ = len(item_)
    arr_ = list()
    for i in range(1, size_item_):
        arr_.append(find_subsets(item_, i))
    if size_item_ % 2 == 0:
        for i_ in range(int(size_item_ / 2) - 1):
            for j_ in range(int(size_item_)):
                size_item_a = len(arr_[i_])
                arr_rules_.append([arr_[i_][j_], arr_[size_item_ - i_ - 2][size_item_a - j_ - 1]])
                arr_rules_.append([arr_[size_item_ - i_ - 2][size_item_a - j_ - 1], arr_[i_][j_]])
        size_a = len(arr_[int(size_item_ / 2) - 1])
        for i_ in range(int(size_a / 2)):
            arr_rules_.append([arr_[int(size_item_ / 2) - 1][i_], arr_[int(size_item_ / 2) - 1][size_a - i_ - 1]])
            arr_rules_.append([arr_[int(size_item_ / 2) - 1][size_a - i_ - 1], arr_[int(size_item_ / 2) - 1][i_]])
    else:
        for i_ in range(int((size_item_ - 1) / 2)):
            for j_ in range(int(size_item_)):
                size_item_a = len(arr_[i_])
                arr_rules_.append([arr_[i_][j_], arr_[size_item_ - i_ - 2][size_item_a - j_ - 1]])
                arr_rules_.append([arr_[size_item_ - i_ - 2][size_item_a - j_ - 1], arr_[i_][j_]])
    return arr_rules_


def confidence(rule_):
    size_ = len(rule_[0]) + len(rule_[1])
    val_tu_ = 0
    val_mau_ = 0
    for item_ in list_l[len(rule_[0]) - 1]:
        if item_.items == list(rule_[0]):
            val_mau_ = item_.sup_count()
            break
    rule_2 = list(rule_[0])
    rule_2.extend(list(rule_[1]))
    for item_ in list_l[size_ - 1]:
        if item_.items == sorted(rule_2):
            val_tu_ = item_.sup_count()
            break
    return [val_tu_, val_mau_]


if __name__ == "__main__":
    # đọc file input
    items_bought = read_file_input()
    items_alpha_b = find_items_alpha_b()
    list_c = list()
    list_l = list()
    C = fill_items_c(items_alpha_b)
    count_word = len(C)
    print("Min supCount = min support * sô giao dịch = {} * {} = {}".format(min_sup, items_bought.__len__(), min_sup*items_bought.__len__()/100))
    show('C1', C)
    turn = 0
    while True:
        turn += 1
        L = fill_items_l(C)
        show('L' + str(turn), L)
        list_c.append(C)
        list_l.append(L)
        if len(L) < turn:
            break
        C = create_items_c(L)
        show('C' + str(turn + 1), C)
    # in các tập phổ biến ----------------------------
    list_popular = list()
    print("Các tập phổ biến: ")
    for items_l in list_l:
        for item in items_l:
            print(item.items)
            if len(item.items) > 1:
                list_popular.append(item)
    # tìm luật kết hợp ----------------------------
    arr_rules = list()
    print('\nb)\nConfidence:')
    for item in list_popular:
        arr_rules.append(find_rules(item.items))
    table = PrettyTable(['Rule', 'support(X)', 'support(x)', 'Confidence'])
    table2 = PrettyTable(['Rule', 'Confidence'])

    for i in arr_rules:
        for j in i:
            val_tu, val_mau = confidence(j)
            val_confidence = round(val_tu / val_mau, 4)* 100
            if val_confidence >= min_conf:
                table2.add_row(['{} -> {}'.format(j[0], j[1]), str(val_confidence) +' %'])
            table.add_row(['{} -> {}'.format(j[0], j[1]), val_tu, val_mau, str(val_confidence)+' %'])
    print(table)
    print("Kết luận những luật kết hợp mạnh là:")
    print(table2)
