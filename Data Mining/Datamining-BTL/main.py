from controllers.men_controller import g_split, filter_attributes
from dao.men_dao import read_data
from util.list_data_raw import list_attributes

if __name__ == '__main__':
    list_data = read_data()

    list_attributes_new = list_attributes

    for i in range(len(list_attributes)):
        list_attributes_new[i] = filter_attributes(list_attributes[i], i, list_data)
    list_g_split = []
    for i in range(len(list_attributes_new)):
        list_g_split.append(g_split(list_attributes_new[i], i, list_data))

    print(list_g_split.index(min(list_g_split)))