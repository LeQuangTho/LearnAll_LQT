if __name__ == '__main__':
    # 4 -7 2 8 -1 6 -3 -2 7 -4
    n = int(input())
    a = [int(x) for x in input().split()]
    C = [a[0]]
    for x in a[1:]: #x chạy trên mảng a lấy từ 1 đến hết
        C.append(x+ max(0,C[-1]))
    print(max(C))