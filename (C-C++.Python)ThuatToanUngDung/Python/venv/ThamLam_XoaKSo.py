def ketqua(a,k):
    stack = [0]
    k+=1
    for i in range(len(a)):
        while len(stack) and k and int(a[i]) > int(stack[len(stack)-1]):
            stack.pop()
            k-=1
        stack.append(a[i])
    while len(stack) and k:
        k-=1
        stack.pop()
    for j in range(len(stack)):
        print(stack[j], end="")
    print("")
if __name__ == '__main__':
    a = input()
    k = int(input())
    while k:
        ketqua(a,int(input()))
        k-=1

