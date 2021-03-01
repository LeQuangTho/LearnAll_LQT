"""
if __name__ == '__main__':
    D = { }
    x = input()
    for c in x:
        if c not in D.keys(): D[c] = 1
        else : D[c] +=1
    D = sorted(D)
    for c in D.keys():
        print (c,D[c])



#ap dao
if __name__ == '__main__':
    n = input()
    a= list(map(int, input().split()))
    D={ }
    for x in a:
        if x not in D.keys(): D[x]= 1
        else: D[x]+=1
        ok = "khong co"
    for x in D.items():
        if x[1] > n//2:
            ok = x[0]
            break
    print(ok)


if __name__ == '__main__':
    n = int(input())
    D = { }
    D[0] = -1
    res = 0
    s = 0

    for c,i in enumerate(input()):
        s+= (1 if c == 'X' else -1)
        if s not in D.keys(): D[s] = i
        else: res = max(res, i-D[s])
    print(res)
    print(D)
    #XXDDXDXXXDXXX


if __name__ == '__main__':
    n = int(input())
    a = list(map(int , input().split()))
    t = 0
    D ={ }
    res = 0
    for i,x in enumerate(a):
        if x not in D.keys() or D[x] < t:
            res = max(res, i - t)
            D[x] = i
        else:
             t = D[x]+1
    print(res)
    #10
    #3 4 2 4 7 2 8 4 8 3 2

#chan bo

from math import gcd
if __name__ == '__main__':
    n = int(input())
    D= { }
    for _ in range(n):
        x,y = map(int, input().split())
        d = gcd(x,y)
        D[(x//d,y//d)] =1
    print("so con bo ", len(D))




D = { }
def fibo(n):
    if n in D.keys(): return D[n]
    D[n] = 1 if n<=2 else fibo(n-1) + fibo(n-2)
    return D[n]
if __name__ == '__main__':
    for i in range(100): print(i, fibo(i))


# n= a*b <a<=b>--> (a-1)*(b+1)
D = {0:1}
def zero(n):
    if n in D.keys(): return D[n]
    D[n]=0
    a=1
    while a*a <=n:
        if n%a == 0: D[n]+=zero((a-1)*(n//a+1))
        a+=1
    return D[n]
if __name__ == '__main__':
    print(zero(300000))
"""

#liet ke xau con
D = { }
def enuma(s):
    D[s] = 1
    if len(s)>1:
        if s[:-1] not in D.keys():enuma(s[:-1])
        if s[1:] not in D.keys(): enuma(s[1:])
if __name__ == '__main__':
    s = input()
    enuma(s)
    k = D.keys()
    k = sorted(k)
    print(*k,sep = "\n")























