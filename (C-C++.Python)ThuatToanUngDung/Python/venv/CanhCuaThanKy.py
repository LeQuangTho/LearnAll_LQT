from collections import deque
def IN(b):
    a = deque()
    a.append('dangdungcntt')
    a.append('tienquanutc')
    a.append('quang123')
    a.append('maianh')
    a.append('nguyenminhduc2820')
    for i in range(1,b):
        k = a.popleft()
        a.append(k)
        a.append(k)
    print(a.popleft())
if __name__ == '__main__':
    n = int(input())
    b = deque()
    for i in range(0, n):
        b.append(int(input()))

    for i in range(0, n):
        IN(b.popleft())
