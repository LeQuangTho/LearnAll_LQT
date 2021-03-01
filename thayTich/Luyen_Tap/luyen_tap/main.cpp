#include <bits/stdc++.h>
using namespace std;
int main()
{
    int test;
    cin>>test;
    for (int tt=1;tt<=test;tt++)
    {
    int n,k,d=0;
    cin>>n>>k;
    int a[n];
    for (int i=0;i<n;i++) cin>>a[i];
        sort(a,a+n);
    int L=0 , R=n-1;
    while (L<=R )
    {
        while(L<R && a[L]+k>=a[L+1]) L++;
        L++;
        d++;
    }
    cout <<"Case #"<<tt<<": "<<d<<endl;
    }
}
