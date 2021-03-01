class hv:
    d = [0]*100
    def TRY(self,x):
        if(len(x)==self.m): print(x)
        else:
            for t in range(x[-1]+1 if x else 1,self.n + 1):
                    self.TRY(x+[t])
    def sol(self):
        self.n = int(input())
        self.m = int(input())
        self.TRY([])
if __name__ == '__main__':
    h = hv()
    h.sol()

