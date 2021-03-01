D={}
def enuma(s):
    D[s]=1
    print(D)
    if len(s)>1 :
        if s[:-1] not in D.keys():
            enuma(s[:-1])
            print(D.keys())
        if s[1:] not in D.keys():
            enuma(s[1:])
            print(D.keys())

if __name__ == '__main__':
     s=input()
     enuma(s)
     k=[x for x in D.keys()]
     k=sorted(k)
     print(*k,sep="\n")