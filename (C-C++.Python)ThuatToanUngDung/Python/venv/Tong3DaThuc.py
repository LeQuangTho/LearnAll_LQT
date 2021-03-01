class dt:
    def __init__(self,s):
        while len(s) > 1 and s[-1]== 0: s.pop()
        self.a = s
    def __str__(self): return " ".join(["%.2f"%x for  x in  self.a])
    def __add__(self, other):
        k= max(len(self.a),len(other.a))
        p= [0]*k
        for i,x in enumerate(self.a): p[i]+= self.a[i]
        for i, x in enumerate(other.a): p[i] += other.a[i]
        return dt(p)
if __name__ == '__main__':
    n = input()
    P = dt([float(x) for x in input().split()])
    n = input()
    Q = dt([float(x) for x in input().split()])
    n = input()
    R = dt([float(x) for x in input().split()])
    print(P+Q+R)