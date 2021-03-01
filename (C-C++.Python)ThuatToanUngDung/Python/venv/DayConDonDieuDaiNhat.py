from bisect import bisect_left
if __name__ == '__main__':
    n = int(input())
    a = list(map(int,input().split()))
    b = [int(-1e9+1)]
    for x in a:
        if b[-1]<x:
            b.append(x)
            print(b)
        else:
            b[bisect_left(b,x)]=x
            print(b)
    print(len(b)-1)
