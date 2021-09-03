#include <iostream>
#include <map>
using namespace std;
int main()
{
    map<int, int> D;
    int n, x, m, sum = 0;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        cin >> x; //vd nhap vao mang thu nhat 3 4 2 2
        D[x]++;
        // D[3] = 1; D[4] = 1; D[2] = 2
    }
    for (int i = 1; i <= m; i++)
    {
        cin >> x; //vd nhap vao mang thu 2: 2 2 1 5
        if (D[x] > 0) // D[x] = phan tu x da xuat hien o mang thu nhat
        {
            sum += x;
            D[x]--; // giam 1 khi da cong
        }
    }
    cout << sum;
}
