if __name__ == '__main__':
    n,k = map(int, input().split())
    a = list(map(int, input().split()))
    res = 0
    if n<=k:
        for i in range(n):
            res+=a[i]
    else:
        a.sort(reverse= True)
        for i in range(k):
            res+=a[i]
    print(res)
