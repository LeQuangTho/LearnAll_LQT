#lop phan so
"""
from math import gcd
class fraction:
    def __init__(self,a=0,b=1):
        d = gcd(a,b)
        self.tu = a
        self.mau = b
        if b<0: a,b = -a,-b
        self.tu = a//d
        self.mau = b//d
    def __str__(self):
        return str(self.tu)+"/"+ str(self.mau)
    def __mul__(self, other):
        u = self.tu * other.tu
        v = self.mau * other.mau
        return fraction(u,v)
    def __add__(self, other):
        u = self.tu * other.mau + self.mau * other.tu
        v = self.mau * other.tu
        return fraction(u,v)
if __name__ == '__main__':
    p = fraction(6,10)
    q = fraction(1,2)
    print("phan so p = ",p)
    print("phan so q = ",q)
    print("p*q =", p*q)
    print("p+q =", p + q)



#da thuc
class dt:
    def __init__(self,h):
        self.a= h
    def __add__(self, other):
        k = max(len(self.a),len(other.a))
        b = k*[0]
        for i,x in enumerate(self.a): b[i]+=x
        for i, x in enumerate(other.a): b[i] += x
        while len(b)>1 and b[-1] == 0: b.pop()
        return dt(b)
    def __str__(self):
        s=["%.3f"%x for x in self.a]
        " ".join(s)
    def __mul__(self, other):

        b = [0]*(len(self.a) + len(other.a))
        for i,x in enumerate(self.a):
            for j,y in enumerate(self.a):
                b[i+j] += self.a[i]*other.a[j]
            while len(b) > 1 and b[-1] == 0:b.pop()
            return dt(b)
if __name__ == '__main__':
    n = input()
    p = dt([float(x) for x in input().split()])
    n = input()
    q = dt([float(x) for x in input().split()])
    n = input()
    r = dt([float(x) for x in input().split()])
    print(p+q+r)
    print(p*q)

class sv:
    def __init__(self,a,b,c):
        self.ten = a
        self.diem = b
        self.tuoi = c
    def __str__(self):
        return "%-30s"%self.ten+ "%0.2f"%self.diem+"%5d"%self.tuoi
class lop:
    a = []
    def __init__(self,fn):
        f = open(fn,"r")
        for line in f.readlines():
            ten, diem, tuoi = line.rsplit(" ",2)
            self.a.append(sv(ten, float(diem),int(tuoi)))
        f.close()
    def __str__(self):
        return "\n".join([str(x) for x in self.a])
    def sx(self):
        self.a.sort(key= lambda x: x.ten.rsplit(' ',1)[-1])
    def diemmin(self):
         d = min(self.a,key=lambda x:x.diem)
         d = d.diem
         return filter(lambda x:x.diem == d,self.a)
if __name__ == '__main__':
    L = lop("ocsen.txt")
    print(L)
    L.sx()
    print(L)
    print("\n",*L.diemmin(),sep="\n")
"""
#sinh hoan vi
d = [0]*100
def TRY(n,a):
    if len(a) ==n: print(a)
    else:
        for i in range(1,n+1):
            if d[i] == 0:
                d[i] =1
                TRY(n,a+[i])
                d[i] = 0

if __name__ == '__main__':
    TRY(1,[])