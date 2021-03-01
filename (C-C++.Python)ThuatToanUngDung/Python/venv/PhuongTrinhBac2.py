import  math
def delta(a,b,c):
    return math.pow(b,2) - 4*a*c

if __name__ == '__main__':
    a,b,c = map(float,input().split())
    if a == b == c == 0: print("vo so nghiem")
    else:
        if a == b == 0: print("vo nghiem")
        else:
            if a == 0:
                print(format((-c/b),'.3f'))
            else:
                if delta(a,b,c) < 0: print("vo nghiem")
                else:
                    if delta(a,b,c) == 0:
                        print(format((-b/2*a),'.3f'))
                    else:
                        if delta(a,b,c) > 0:
                            if (-b+math.sqrt(delta(a,b,c)))/(2*a)>=(-b-math.sqrt(delta(a,b,c)))/(2*a):
                                print(format((-b - math.sqrt(delta(a, b, c))) / (2 * a),'.3f'))
                                print(format((-b + math.sqrt(delta(a, b, c))) / (2 * a),'.3f'))
                            else:
                                print(format((-b + math.sqrt(delta(a, b, c))) / (2 * a),'.3f'))
                                print(format((-b - math.sqrt(delta(a, b, c))) / (2 * a),'.3f'))