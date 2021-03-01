from queue import PriorityQueue
class elem:
    def __init__(self,v,w): self.v,self.w = u,w
    def __lt__(self, other): return self.w<other.w

if __name__ == '__main__':
    f = open("g.txt","r")
    n,m = map(int,f.readline().split())
    a = [[] for i in range(n+5)]
    for i in range(m):
        u,v,w = map(int, f.readline().split())
        a[u].append(elem(v,w))
        a[v].append(elem(u, w))
    f.close()
    Q = PriorityQueue()
    L = [int(1e9)]*(n+1)
    d = [True]*(n+5)
    Q.put(elem(1,0))
    L[1]=0
    res = 0
    while Q.qsize():
        u = Q.get()
        if d[u.v] == False: continue
        res+=u.w
        d[u.v] = False
        for x in a[u.v]:
            if L[x.v]>x.w:
                L[x.v] = x.w
                Q.put(x)
    print(res)