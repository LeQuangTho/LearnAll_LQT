####################### Bài này là bài nối thanh kim loại
"""""
from heapq import *
from queue import  PriorityQueue
if __name__ == '__main__':
    n = input()
    a = list(map(int,input().split()))
    h = []
    for x in a: heappush(h,x)
    res = 0
    while(len(h)>1):
        u = heappop(h)
        u = u + heappop(h)
        res += u
        heappush(h,u)
        print(res)
"""
# bộ test
# 10 4
# 4 7 2 8 4 6 3 5 7 2
from collections import deque
if __name__ == '__main__':
    n , k=map(int,input().split())
    a = list(map(int,input().split()))
    d = deque([])
    for x,i in enumerate(a):
        if i<k-1:
            while len(d) and d[-1][0] <x: d.pop()
            d.append((x,i))
        else:
            while len(d) and d[-1][0] <x: d.pop()
            d.append((x,i))
            while i-d[0][1] + 1 >k: d.popleft()
            print(d[0][0],end = ' ')
