from collections import deque

def Luu(a,max,b):
    m = b.popleft()
    for i in range(1,max+1):
        k = a.popleft()
        a.append(k)
        a.append(k)
        if m == i:
            print(k)
            m = b.popleft()
        elif m == -1:
            return
if __name__ == '__main__':
    a = deque()
    a.append('dangdungcntt')
    a.append('tienquanutc')
    a.append('quang123')
    a.append('maianh')
    a.append('nguyenminhduc2820')
    n = int(input())
    b = deque()
    for i in range(0, n):
        b.append(int(input()))
    b.append(-1)
    Luu(a,max(b),b)