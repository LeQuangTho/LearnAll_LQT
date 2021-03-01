class elem:
    def __init__(self,v,c): self.value,self.cost = v,c
    def __lt__(self, other): return self.cost<other.cost
from queue import  PriorityQueue
from math import *

if __name__ == '__main__':
    s,f = map(int, input().split())
    p= [0]*(s+5)
    L = [int(1e9)]*(s+5)
    Q = PriorityQueue()
    Q.put(elem(s,0))
    while Q.qsize():
        u = Q.get()
        if u.value ==f:
            #path(s,f,p)
            break
        for a in range(1,floor(sqrt(u.value))+1):
            if u.value%a==0:
                b= (u.value//a+1)
                v =(a-1)*(b+1)
                c =b//a if b%a==0 else b-a
                if L[v]>L[u.value]+c:
                    Q.put(elem(v,c))
                    p[v]= u
                    L[v]= L[u.value]+c