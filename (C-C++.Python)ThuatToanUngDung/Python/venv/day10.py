#########BackTracking
'''
def TRY(x,k,T,n,M):
    if k == n-1:
        x.append(M-T)
        print(*x,sep = "+")
    else:
        for t in range(M-T +1 ): TRY(x +[t],k+1,T+t,n,M)

if __name__ == '__main__':
    TRY([],0,0,3,5)



###phan tich n thanh cac day ko giam
def TRY(x,T,n):
    if T == n: print (*x[1:], sep = "+")
    else:
        for t in range(x[-1],n- T+1): TRY(x+[t],T+t,n)
if __name__ == '__main__':
    TRY([1],0,15)


class money:
    def nhap(self):
        self.a = list(map(int, input().split()))
        self.M = int(input())
        self.n = len(self.a)
    def TRY(self,x,k,T):
        if len(x) == self.n-1:
            if (self.M-T)%self.a[-1] == 0:
                t = (self.M-T)//self.a[-1]
            print(*(x+[t]),sep=" ")
        else:
            for t in range((self.M-T)//self.a[k]+1):
                self.TRY(x+[t],k+1,T+t*self.a[k])
    def sol(self):
        self.nhap()
        self.TRY([],0,0)
if __name__ == '__main__':
    m = money()
    m.sol()
'''
class Hau:
    def Nhap(self):
        self.n = int(input())
        self.A = { }
        self.B = { }
        self.C = { }
    def TRY(self,x):
        if len(x) == n: print(*x,sep = " ")
        else:
            for t in range(1,self.n+1):
                if (t not in self.C.keys() or self.C[t] == False) and (t-k not in self.A.keys() or ) and (t+k not in self.B.keys()):