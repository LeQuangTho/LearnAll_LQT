if __name__ == '__main__':
    n,m = map(int,input().split())
    C = [int(-1e9)] * (m+1)
    for i in range(n):
        a = [0] + list(map(int, input().split()))
        if i == 0: C[1] = a[1]
        for j in range(1,m+1):
            if i == 0 and j==1: C[j] = a[j]
            else:
                C[j] = max(C[j],C[j-1]) + a[j]
    print(C[-1])
