'''
if __name__ == '__main__':
    b = [x for x in range(1,20,2)]  #range(1,20,2) là chạy từ 1 đến 20 bước nhẩy 2
    print(b)
    print("Năm phần tử đầu: ", b[:5])
    print("Năm phần tử cuối: ", b[-3:])
    print("Hai phần tử cuối", b[-1],b[-2])
    print("Đảo dãy", b[::-1])
    print("Phần tử chẵn", b[::2])
    print("Phần tử lẻ", b[1::2])

    b.append(4)
    b.append([4,5])
    b.append(5)
    b.append(5)
    b.append(5)

    print(b)
    b.pop()
    print(b)
    c = [x for x in b if x!= 5]
    print(c)
    b.remove(5)
    d = list (filter(lambda x:x!= 5,b))
    print(d)

    a = [1,2,3] + [4,5,6,7]
    print(a)


from functools import reduce
from math import gcd as ucln
if __name__ == '__main__':

    #n = int(input())
    #print(reduce(lambda x,y:x*y,range(1,n+1)))

    d = [120, 240, 180, 144]

    """print(reduce(ucln,d,9))
    e = list(map(lambda x:x%13,d))
    print(e)
    print("Tong day",sum(d))
    print("Max day", max(d))
    print("Min day", min(d))"""

    n = input()
    a = list(map(int,input().split()))
    for k in range(3):
        b = list(filter(lambda x:x%3 ==k,a))
        if b: print(min(b),max(b))
        else: print("Khong co so nao chia 3 du",k)



#Ngày tiếp theo
def nhuan(y): return y%400==0 or (y%4==0 and y%100!=4)
if __name__ == '__main__':
    d,m,y = map(int, input().split('/'))
    t=[0,31,28+nhuan(y),31,30,31,30,31,31,30,31,30,31]

    if d==t[m]:
        d = 1
        m = m+1
        if m ==13: m,y = 1, y+1
    else: d = d+1
    print("{0:d}/{1:d}/{2:d}".format(d,m,y))

'''

# Giải phương trình ^4
from math import sqrt
def nghiem(t):
    if t<0: return []
    if t ==0: return [0]
    return [-sqrt(t),sqrt(t)]

def gpt(a,b,c):
    if a == 0:
        if b == 0:
            return "vo so nghiem" if c==0 else "vo nghiem"
        else: return nghiem(-c/b)
    else:
        b /=2
        d =  b*b - a*c
        if d<0: return []
        elif d==0: return nghiem(-b/a)
        else: return nghiem(-b/a-sqrt(d)/a) + nghiem(-b/a+sqrt(d)/a)
if __name__ == '__main__':
    a, b, c = map(float, input().split())
    k = gpt(a,b,c)
    if len(k) ==5: print("vo so nghiem")
    elif len(k) == 0: print("vo nghiem")
    else:
        for x in k: print("%.3f"%x,end="\n")




# bài tập về nhà
    # Đếm số nghiệm phương trình trùng phương
    # Tiền điện
    # Lại là tiền điện
    # Tính số ngày
    # Mã vùng điện thoại