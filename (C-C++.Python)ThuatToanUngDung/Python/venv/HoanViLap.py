class hvl:
    dem =0
    def TRY(self,x,n):
        if len(x) == n: print(x)
        for t in self.D.keys():
            if self.D[t] > 0:
                self.D[t] -= 1
                self.TRY(x+[t],n)
                self.D[t]+=1
    def sol(self):
        xau = input()
        self.D = { }
        for t in xau:
            if t not in self.D.keys(): self.D[t] = 1
            else: self.D[t]+= 1
        self.TRY([],len(xau))
if __name__ == '__main__':
    H = hvl()
    H.sol()