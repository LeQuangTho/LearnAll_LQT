'''
class tapcon:
    def TRY(self,x,k,T): #x phan tu cuoi, da chon k pt co tong T
        if(k== self.m):
            if(self.res<T): self.res = T
        else:
            for t in range(x+1 ,self.n):
                    self.TRY(t,k+1,(T+self.a[t])%self.X)
    def sol(self):
        self.m,self.X,*self.a = list(map(int,input().split()))
        self.res = 0
        self.n = len(self.a)
        self.TRY(-1,0,0)
        print("Gia tri max", self.res)
if __name__ == '__main__':
    TC = tapcon()
    TC.sol()
'''

from itertools import combinations
#for x in combinations([4, 7,2,8],3):
#   print(x)
m,X,*a = list(map(int,input().split()))
res =0
for x in combinations(a,m):
    t = sum(x)%X
    if(t>res): res = t
print(res) 
