"""
#############   1
if __name__ == '__main__':

     n,*a = list(map(int, input().split()))  #số đầu tiên và phần còn lại
     print(n,a)

################## 2
def bp(x): return x*x

if __name__ == '__main__':
    a = [3,7,2,1]
    b= list(map(bp,a))
    c= list(map(lambda x: 2**x,b))
    print(c)
    x = 3.14
    print("x = %.3f và x*x = %.3f"%(x,x*x))
    z = 12345
    print("{0:d} ở cơ số 2 là {0:b} cơ số 16 là {0:x}".format(z))
    a,b,c = 1,2,3
    a,b = b,a
    print("a = {0:d}\nb = {1:d}".format(a,b))
    z = "a,b,c,dhh".split(',',2)
    print(z)

    z = "Lê Quang Thọ 20 8.25"
    ten,tuoi,diem = z.rsplit(' ',2)
    print(ten)
    tuoi = int(tuoi)
    diem = float(diem)
    print("tuổi %d"%tuoi)
    print("điểm %.2f"%diem)


#################  3
if __name__ == '__main__':
    n= int(input('n = '))
    k = []
    for i in range (1,n+1):
        z = "* " * i
        z.center(2 * n + 1)
        k = k+[z]
    print(*k,sep="\n")


####################   4
if __name__ == '__main__':
    x = []
    y = [2,3]*5
    print(y)
    y.append(7)
    print(y)
    y.pop()
    print(y)
    y = [3,7,2,1,5,8]
    y.sort(key = lambda x: x%2,reverse=True)  # sort(điều kiện, (đúng trước, sai sau)
"""


######################    5
from collections import namedtuple
sv = namedtuple("sv","hodem ten diem")
if __name__ == '__main__':
    f = open("sv.txt")
             s=[]
    while not e
        x = f.readline():
        hd,t,d = x.split(' ',2)
        s.append(sv(hd,t,int))