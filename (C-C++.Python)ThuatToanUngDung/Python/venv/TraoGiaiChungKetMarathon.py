if __name__ == '__main__':
    n = int(input())
    a = []
    for i in range(n):
        a.append(input().split(" "))
    for i in range(n):
        for j in range(i,n):
            if int(a[i][len(a[i])-2]) < int(a[j][len(a[j])-2]):
                a[i],a[j] = a[j],a[i]
    ok = 0
    i = 0
    b = []
    while ok != 3:
        if(a[i][len(a[i])-1]) == "DDT":
            for j in range(1, len(a[ok]) - 2):
                a[i][0] += " "
                a[i][0] += a[i][j]
            b.append(a[i][0])
            ok+=1
        i+=1
    b[0] = "Giai nhat :"+ b[0]
    b[1] = "Giai nhi :" + b[1]
    b[2] = "Giai ba :" + b[2]
    print(b[0])
    print(b[1])
    print(b[2])
    ok = 0
    i = 0
    while ok != 1:
        if (a[i][len(a[i]) - 1]) != "DDT":
            for j in range(1, len(a[ok]) - 2):
                a[i][0] += " "
                a[i][0] += a[i][j]
            b.append(a[i][0])
            ok += 1
        i += 1
    b[3] = "Giai giao luu :" + b[3]
    print(b[3])
