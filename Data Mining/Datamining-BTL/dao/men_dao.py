from model.men import Men

path = 'util/data.txt'


def read_data():
    global path
    list_data = []
    f = open(path, "r")
    list_from_file = f.readlines()
    for i in list_from_file:
        j = i.rstrip('\n').split(',')
        men = Men(j[0], j[1], j[2], j[3], j[4], j[5], j[6], j[7], j[8], j[9])
        list_data.append(men)
    f.close()
    return list_data
