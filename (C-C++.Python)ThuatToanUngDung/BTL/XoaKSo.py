from  collections import deque
if __name__ == '__main__':
    n = input()
    m = int(input())
    k = []
    for i in range(m):
        k.append(int(input()))
    st = deque()
    st.append(int(n[0]))
    b =[]
    for j in range(m):
        for i in range(1,len(n)):
            if k[j] == 0 and i < len(n):
                st.append(n[i])
            else:
                if  k[j] != 0 and int(n[i]) >= int(st[len(st)-1]):
                    st.pop()
                    st.append(n[i])
                    k[j]-=1
                else:
                    if k[j] != 0 and int(n[i]) <= int(st[len(st)-1]):
                        st.append(n[i])
        b.append(st)
        st = deque()
        st.append(int(n[0]))
    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print("")

