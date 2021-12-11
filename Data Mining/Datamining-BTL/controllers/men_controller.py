def gini(obj_, index_properties, list_data):
    count_n = 0
    count_o = 0
    for i in range(len(list_data)):
        if list_data[i].get_properties(index_properties) == str(obj_):
            if list_data[i].output == 'N':
                count_n += 1
            else:
                count_o += 1
    count_o_and_n = count_o + count_n
    if count_o_and_n == 0:
        return 0
    return [round(1 - pow((count_o / count_o_and_n), 2) - pow((count_o / count_o_and_n), 2), 4), count_o_and_n]


def g_split(obj_, index_, list_data):
    list_g_split = []
    sum_ = 0
    result = 0
    for i in obj_:
        gs = gini(i, index_, list_data)
        sum_ += gs[1]
        list_g_split.append(gs)

    for i in range(len(list_g_split)):
        result += (list_g_split[i][1] / sum_) * list_g_split[i][0]

    return result


def filter_attributes(obj_, index_, list_data):
    list_attributes_new = []

    for i in obj_:
        if gini(i, index_, list_data) != 0:
            list_attributes_new.append(i)
    return list_attributes_new
