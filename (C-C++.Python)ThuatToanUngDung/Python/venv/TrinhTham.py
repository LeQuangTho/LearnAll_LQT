from collections import deque
if __name__ == '__main__':
    n,k=map(int,input().split())
    a=list(map(int,input().split()))
    d=deque([])
    for i,x in enumerate(a):
        if i<k-1:
            while len(d) and d[-1][0]<x: d.pop()
            d.append((x,i))
        else:
            while len(d) and d[-1][0]<x:
                d.pop()
            d.append((x,i))
            while i-d[0][1]+1>k:
                d.popleft()
            print(d[0][0],end=' ')