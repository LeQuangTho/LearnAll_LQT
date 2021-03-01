def gcd(a,b):
    while (b != 0):
        r = a % b # chia lấy phần dư
        a = b
        b = r
    return a
if __name__ == '__main__':
    print(gcd(int(input()), int(input())))