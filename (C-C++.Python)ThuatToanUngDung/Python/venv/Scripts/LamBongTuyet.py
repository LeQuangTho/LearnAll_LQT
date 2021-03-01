from queue import PriorityQueue
if __name__ == '__main__':
    n=int(input())
    V=[int(x) for x in input().split()]
    T=[int(x) for x in input().split()]
    Q=PriorityQueue()
    z=0
    for v,t in zip(V,T):
        Q.put(z+v)
        s=0
        while Q.qsize() and Q.queue[0]-z<=t: s+=Q.get()-z
        s+=Q.qsize()*t
        z= z+t if Q.qsize() else 0
        print(s, end=" ")