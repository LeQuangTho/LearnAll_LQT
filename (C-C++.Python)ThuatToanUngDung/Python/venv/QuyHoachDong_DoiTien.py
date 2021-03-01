class money:
    C = []
    def thuan(self):
        self.a = [0]+[int(x) for x in input().split()]
        self.M = int(input())
        for _ in range(len(self.a)):
            self.C.append([int(1e9)]*(self.M+1))
        self.C[0][0] = 0
        for i in range(1, len(self.a)):
            for j in range(0,self.M + 1):
                if j < self.a[i]: self.C[i][j] = self.C[i-1][j]
                else: self.C[i][j] = min(self.C[i-1][j], 1+ self.C[i][j-self.a[i]])
        if self.C[-1][self.M] == int(1e9): print("Khong doi duoc")
        else:
            print(self.C[-1][self.M])
    def nghich(self,u,v):
        if(self.C[u][v] == 0): return
        while self.c[u][v] == self.C[u-1][v]:u-=1
        self.nghich(u-1,v-self.a[u])
if __name__ == '__main__':
    M = money()
    M.thuan()