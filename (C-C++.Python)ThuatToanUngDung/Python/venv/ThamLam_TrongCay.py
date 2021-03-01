class edge:
    def __init__(self,L,R,W):
        self.u,self.v,self.w = L,R,W
    def __str__(self):
        return "(" + str(self.u) +"->"+ str(self.v)+" : "+str(self.w)+")"

class Graph:
    def Read(self):
        f = open("g.txt","r")
        self.n, self.m = map(int,f.readline().split())
        self.A = []
        for _ in range(self.m):
            u,v,w = map(int, f.readline().split())
            self.A.append(edge(u,v,w))
        f.close()
        self.D = [0]*(self.n +5)
    def getroot(self,x):
        if self.D[x]== x: return x
        return self.getroot(self.D[x])

    def Kruskal(self):
        self.A.sort(key=lambda x:x.w)
        res = 0
        for e in self.A:
            x = self.getroot(e.u)
            y = self.getroot(e.v)
            if x != y:
                res += e.w
                self.D[x] = y
                print(e)
        print("trong so nho nhat")

    def Print(self):
        for i in range(self.m): print(self.A[i])

if __name__ == '__main__':
    G = Graph()
    G.Read()
    G.Print()
