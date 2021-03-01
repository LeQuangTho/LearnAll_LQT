from math import floor,sqrt
class zero:
    def __init__(self,v):
         self.n=v
         self.p=[0]*v+[1]
    def DFS(self,s):
         for a in range (1,floor(sqrt(s))+1):
            if s%a==0:
                t=(a-1)*(s//a+1)
                if self.p[t]==0:
                    self.p[t]=1
                    self.DFS(t)
    def sol(self):
        self.DFS(self.n)
        for i in range (0,self.n+1):
            if self.p[i]: print(i,end=" ")
if __name__ == '__main__':
    n=int(input())
    Z=zero(n)
    Z.sol()