def xoa(k,n,t):
    stack = []
    for i in range(len(t)):
        while len(stack) and n and int(t[i]//pow(10,len(str(t[i]))-1)) > int(stack[len(stack)-1]//pow(10,len(str(stack[len(stack)-1]))-1)) and len(str(stack[len(stack)-1])) <= len(str(t[i])):
            stack.pop()
            n -= 1

        stack.append(t[i])
    while len(stack) and n:
        n -= 1
        stack.pop()
    print(stack)
if __name__ == '__main__':
    k = int(input())
    n = int(input())
    t = []
    for i in range(k):
        t.append(int(input()))
        #print(int(t[i]//pow(10,len(str(t[i]))-len(str(t[i])))))
    xoa(k,n,t)
    #
    # 42
    # 50
    # 163
    # 21