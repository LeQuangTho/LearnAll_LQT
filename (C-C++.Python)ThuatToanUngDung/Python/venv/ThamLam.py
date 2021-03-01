'''Giai bai toán có yeu to toi uu
    luon luon so sanh de tim cach tot nhat
    2 loai ------- co chien luoc tong the tu dau
           		+ lua chon p/ an
				+ lua chon p/ an
					(sort)
		 -------Tinh chinh tung buoc so sanh cac phuong an theo tung buoc
					(hang doi uy tien)


    bai toan vat sua
    4 7 2 8 1 6
    b1: sort
    b2: duyet
'''
if __name__ == '__main__':
    a = list(map(int, input().split()))
    a.sort(reverse= True)
    res = 0
    for i,x in enumerate(a):
        if x-i<0: break
        res+= x-i
    print(res)