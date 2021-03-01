p = [1]* 10003
def pt(n):
     global p
     i = 2
     while i*i<=n:
         while n%i == 0:
             p[i]+=1
             n//= i
         i+=1
     p[n] += 1

if __name__ == '__main__':
    n = int(input())
    for i in range(2,n+1): pt(i)
    res = 1
    for i in range(2,10001): res = res* p[i]%1000000007
    print(res)