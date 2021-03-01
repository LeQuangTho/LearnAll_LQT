import math
def kc(x1,y1,x2,y2):
    return math.sqrt(pow(x1-x2,2)+pow(y1-y2,2))
def heron(a,b,c):
    p = (a+b+c)/2
    return math.sqrt(p*(p-a)*(p-b)*(p-c))
if __name__ == '__main__':
    a1, a2 = map(float, input().split())
    b1, b2 = map(float, input().split())
    c1, c2 = map(float, input().split())
    d1, d2 = map(float, input().split())
    ab = kc(a1,a2,b1,b2)
    bc = kc(b1,b2,c1,c2)
    cd = kc(c1,c2,d1,d2)
    ad = kc(a1,a2,d1,d2)
    ac = kc(a1,a2,c1,c2)
    bd = kc(b1,b2,d1,d2)
    s1 = heron(ab,bc,ac)+heron(ad,ac,cd)
    s2 = heron(ab,bd,ad)+heron(bd,bc,cd)
    if(s1>s2): print(format(s2,'.3f'))
    else: print(format(s1,'.3f'))




