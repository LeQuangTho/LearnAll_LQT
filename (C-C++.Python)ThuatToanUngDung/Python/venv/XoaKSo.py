from  collections import deque
if __name__ == '__main__':
    n = input()
    m = int(input())
    k = []
    for i in range(m):
        k.append(int(input()))
    b =[]
    for j in range(m):
        st = deque()
        st.append(int(n[0]))
        for i in range(1,len(n)):
            if k[j] == 0 and i < len(n):
                st.append(n[i])
            else:
                if  k[j] != 0 and int(n[i]) >= int(st[len(st)-1]):
                    if int(n[i]) == int(st[len(st) - 1]):
                        if n[i] == 9:
                            st.append(n[i])
                        else:
                            st.pop()
                            st.append(n[i])
                            k[j] -= 1
                    else:
                        #st.append(n[i])
                        st.pop()
                        st.append(n[i])
                        k[j]-=1
        #     while k[j] != 0:
        #         st.pop()
        #         k[j]-=1
        b.append(st)

    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print("")

