import math
def dem(t): return 2 if t > 0 else int(t==0)
if __name__ == '__main__':
    a,b,c = map(float,input().split())
    if a == 0:
        if b == 0: print(0 if c else -1)
        else:print(dem(-c/b))
    else:
        d = b*b - 4*a*c
        if d > 0: print(dem((-b-math.sqrt(d))/2/a)+ dem((-b+math.sqrt(d))/2/a))
        else: print(dem(-b/2/a) if d == 0 else 0)