class elem:
    def __init__(self,v): self.value = v
    def __lt__(self, other): return self.value>other.value

from queue import PriorityQueue
if __name__ == '__main__':
    Q = PriorityQueue()
#   for x in [6,7,4,5]: Q.put(elem(x))
#   while Q.qsize(): print(Q.get().value, end=" ")
    n = int(input())
    a = []
    for i in range(int(1e6)+1): a.append([])
    for _ in range(n):
        t,v = map(int, input().split())
        a[t].append(v)
    res =0
    for i in range(1000000,0,-1):
        for x in a[i]: Q.put(elem(x))
        if(Q.qsize()): res+= Q.get().value
    print(res)