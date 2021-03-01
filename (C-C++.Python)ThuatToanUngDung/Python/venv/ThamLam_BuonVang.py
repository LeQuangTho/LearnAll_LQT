if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))[::-1]
    lai = 0
    max = a[0]
    for i in a:
        if max < i:
            max = i
        else:
            lai += max - i
    print(lai)