'''
#Nối thanh kim loại độ dài a1,a2,a2...
-chi phí nối 2 thanh x,y tìm x+y
- cần nối

'''
from queue import PriorityQueue
if __name__ == '__main__':
    Q = PriorityQueue()
    for x in list(map(int,input().split())): Q.put(x)
    res = 0
    while Q.qsize()>1:
        u = Q.get()
        u += Q.get()
        res += u
        Q.put(u)
    print(res)
