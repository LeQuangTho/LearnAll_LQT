# http://laptrinhonline.club/problem/tichpxbupbenga
# 2 2 4 7 2 8 4 1 6 3
from queue import Queue
if __name__ == '__main__':
    k,*a=list(map(int,input().split()))
    a.sort(reverse=True)
    Q=Queue()
    for x in a:
        if Q.qsize()>0 and x+k<=Q.queue[0]: Q.get()
        Q.put(x)
    print("So bup be",Q.qsize())
    for _ in range(Q.qsize()):
        print(Q.get())
