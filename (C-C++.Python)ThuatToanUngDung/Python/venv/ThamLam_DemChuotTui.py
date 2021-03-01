def dem(x,y):
    d=0
    i=0
    j=0
    n=len(x)
    m=len(y)
    while i<n and j<m:
        while j<m and y[j]<2*x[i]: j+=1
        if j<m:
            d+=1;
            j+=1;
        i+=1
    return n+m-d
n = int(input())
a = []
for i in range(n):
    a.append(int(input()))
a=sorted(a)
u = dem(a[:n//2],a[n//2:])
print(u)
