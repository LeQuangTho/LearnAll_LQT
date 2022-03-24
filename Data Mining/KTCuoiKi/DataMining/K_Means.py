import math
from prettytable import PrettyTable

# TODO Chú ý!!!
manhattan = False


# tìm tọa độ tâm
def find_center():
    for center in centers:
        var = [0, 0, 0]
        for mean in means:
            if mean[3] == center[0]:
                print(mean)
                var[1] += mean[1]
                var[2] += mean[2]
                var[0] += 1
        center[1] = var[1] / var[0]
        center[2] = var[2] / var[0]
        print()


# tính khoảng cách đến tâm
def _distance():
    distances.clear()
    for center in centers:
        d = []
        for mean in means:
            # TODO Tính khoảng cách theo 2 cách
            if manhattan:
                # Tính khoảng cách theo manhattan
                var = abs(mean[1] - center[1]) + abs(mean[2] - center[2])
            else:
                # Tính khoảng cách theo euclidean
                var = math.sqrt(pow(mean[1] - center[1], 2) + pow(mean[2] - center[2], 2))
            d.append(round(var, 2))
        distances.append(d)


# nhóm các đối tượng vào cụm gần nhất
def new_group():
    for i in range(len(means)):
        for j in range(len(centers)):
            min_x = min(distances[0][i], distances[1][i], distances[2][i])
            if min_x == distances[j][i]:
                means[i][3] = centers[j][0]
                break


# in bài làm
def show(number_):
    means_old = [x[:] for x in means]
    find_center()
    _distance()
    new_group()

    # create table
    print('\nTính tâm: tâm = Trung bình cộng tọa độ các phần tử trong cụm')
    title = ['Quan Sát']
    for center in centers:
        title.append(center[0])
        print(center)
    title.append('Cụm')
    t = PrettyTable(title)
    for i in range(len(means)):
        row = [means[i][0]]
        for j in range(len(centers)):
            row.append(distances[j][i])
        row.append(means[i][3])
        t.add_row(row)
    print('\n --- Lần {} --- '.format(number_))
    print(t)
    if means_old == means:
        print("Không có sự thay đổi trong các cụm")
        exit()


if __name__ == "__main__":
    # # ['A', 2, 2, 'C1'] <=> [Quan sát, thuộc tính 1, thuộc tính 2, Cụm hiện tại(nếu chưa có cụm để '')]
    means = [['A', 2, 2, 'C1'],
             ['B', 4, 4, 'C1'],
             ['C', 5, 5, 'C3'],
             ['D', 6, 6, 'C1'],
             ['E', 9, 9, 'C3'],
             ['F', 0, 4, 'C2'],
             ['G', 4, 0, 'C2']]
    # # Khởi tạo tâm
    centers = [['C1', 0.0, 0.0],
               ['C2', 0.0, 0.0],
               ['C3', 0.0, 0.0]]
    # VD input ------------------------------------------------------
    # means = [['A1', 2, 10, 'C1'],
    #          ['A2', 2, 5, 'C2'],
    #          ['A3', 8, 4, 'C3'],
    #          ['B1', 5, 8, ''],
    #          ['B2', 7, 5, ''],
    #          ['B3', 6, 4, ''],
    #          ['C1', 1, 2, ''],
    #          ['C2', 4, 9, '']]
    # centers = [['C1', 0, 0],
    #            ['C2', 0, 0],
    #            ['C3', 0, 0]]

    distances = list()
    turn = 1
    while True:
        show(turn)
        turn += 1
