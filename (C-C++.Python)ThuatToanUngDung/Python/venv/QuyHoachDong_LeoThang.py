if __name__ == '__main__':
    n = int(input())
    C = [0,1,2,4] +[0]*(n+1)
    for i in range(4,n+1):
        C[i] = C[i-1] + C[i-2] + C[i-3]
    print(C[n])