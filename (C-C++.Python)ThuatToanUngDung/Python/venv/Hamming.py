# ---------------------------------------------------- Hamming xuoi tìm ma Hamming của ký tư
def custom(vt,arr):
    k = 0
    var = 0
    isDao = True
    for i in range(vt,13):
        if var == 0:        isDao = True
        elif var == vt:     isDao = False
        if isDao:           var += 1
        else:               var -= 1
        if int(arr[i]) == 1 and isDao:
            k += 1
    return k%2
if __name__ == '__main__':
    print('Nhap vao ky tu: ')
    y = str(input())
    x = ord(y)
    a = bin(int(x))[2:].zfill(8)
    b = [0,0,0,a[0],0,a[1],a[2],a[3],0,a[4],a[5],a[6],a[7]]

    b[1] = custom(1,b)
    b[2] = custom(2,b)
    b[4] = custom(4,b)
    b[8] = custom(8,b)
    print('Ma Hamming: ')
    for i in b[1:]:
        print(int(i),end='')
    #print('\n',b)


#------------------------------------------------------- Hamming Nguoc Tìm lỗi
#
# def custom(vt,arr):
#     k = 0
#     var = 0
#     isDao = True
#     for i in range(vt,12):#
#         if var == 0:        isDao = True
#         elif var == vt:     isDao = False
#         if isDao:           var += 1
#         else:               var -= 1
#         if int(arr[i]) == 1 and isDao:
#             k += 1
#     return k%2
#
# if _name_ == '_main_':
#     print('Nhap ma Hamming(11 bit): ')
#     arr = input()
#     b = [0]
#     for i in arr:
#         b.append(i)
#     c = []
#     c.append(custom(1,b))
#     c.append(custom(2,b))
#     c.append(custom(4,b))