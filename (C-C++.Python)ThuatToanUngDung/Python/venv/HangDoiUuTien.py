from queue import PriorityQueue


class diem:
    def __init__(self, u=0, v=0):
        self.x, self.y = u, v

    def __lt__(self, other):
        if self.y == other.y: return self.x < other.x
        return self.y < other.y
    def __str__(self):
        return "("+str(self.x)+","+str(self.y)+")"

if __name__ == '__main__':
    n = int(input())
    Q = PriorityQueue()
    for _ in range(n):
        u, v = map(int, input().split())
        Q.put(diem(u, v))
    while Q.qsize():
        d = Q.get()
        print(d)