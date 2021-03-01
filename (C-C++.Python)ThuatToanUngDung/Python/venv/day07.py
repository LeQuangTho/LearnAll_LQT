# Vi dụ về hàm
'''
def  gpt(a,b):  #ax+b =0
    if a==0 and b== 0: return "vô số nghiệm"
    if a==0: return "Vô nghiệm"
    return -b/a

if __name__ == '__main__':
    a = float(input("a ="))
    b = float(input("b ="))
    x = gpt(a,b)
    print(x)


def gt(n):
    return 1 if n ==0 else n*gt(n -1) #Giống ? :
if __name__ == '__main__':
    for i in range(int(input("n = "))):
        print(i,gt(i))


# Tính tổng các ước của n!
def analyze(n): # phân tích ra thừa số nguyên tố
    k = []
    i = 2
    d = 0
    while i*i <=n:
        while n%i == 0:
            d +=1
            n//=i
        if d: k.append((i,d))
        i+=1
    if(n>1): k.append((n,1))
    return k

def divide_count(n):    #Đếm ước
   p =[0]*(n+1)
   for i in range(2,n+1):
       for u,v in analyze(i): p[u]+=v
   d,s = 1,1
   for i in range(2,n+1):
       if p[i]:
           d *= (p[i]+1)
           s *= (i**(p[i]+1)-1)//(i-1)
    return d,s

if __name__ == '__main__':
    n = int(input())
    d,s = divide_count(n)
    print("Số ước", d)
    print("Tổng ước", s)




#
def pow(x,n):
    if n == 0: return 1
    return pow(x*x,n//2)*(x if n%2 else 1)

def Fib(n): #^O(2^n)
    return 1 if n<= 1 else (Fib(n-1) + Fib(n-2))

def fib(n): #O(n)
    if n == 0: return 1,1
    u,v = fib(n-1)
    return v,u+v
def Fibo(n):
    if n == 1: return 1,1
    a,b = Fibo(n//2)
    a,b=a*a+b*b,2*a*b -b*b
    return (a+b,a) if n%2 else (a,b)
if __name__ == '__main__':
#    print(pow(2,10))
    for n in range (1,10):
        u,v = Fibo(n)
        print(n,v)



# Đệ quy DFS (Depth First Search)
from math import floor,sqrt
class zero:
    def __init__(self,v):
        self.n = v
        self.p = [0]*v+[1]
    def DFS(self,s):
        for a in range(1,floor(sqrt(s))+1):
            if s%a ==0:
                t=(a-1)*(s//a+1)
                if self.p[t] == 0:
                    self.p[t] == 1
                    self.DFS(t)
    def sol(self):
        self.DFS(self.n)
        for i in range(0,self.n+1):
            if self.p[i]: print(i,end=" ")
if __name__ == '__main__':
    n = int(input("n = "))
    z = zero(n)
    z.sol()
'''
class ocsen:
    m = []
    count = 0
    def __init__(self,fname):
        f = open(fname,"r")
        for line in f.read().split("\n"):
            a = list(map(int,line.split()))
            self.m.append([1] + a [1])
        f.close()
        n = len(self.m[0])
        m = [1]*n+self.m+[1]*1
    def dfs(self, u, v):
        self.m[u][v] = 1
        self.count +=1
        hh =[1,-1,0,0]
        hc =[0,0,1,-1]
        for z,t in zip(hh,hc):
            if self.m[u+z][v+t] == 0: self.dfs(u+z,v+t)
    def sol(self):
        u,v =  map(int,input("toa do oc sen: ").split())
        self.dfs(u,v)
        print("so o di duoc", self.count)
if __name__ == '__main__':
    