#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int a[n+1],c[n+5];
    for (int i=1;i<=n;i++) cin>>a[i];
        sort(a+1,a+n+1);
        c[0]=0;
        c[1]=a[1];
        c[2]=a[2];
        c[3]=a[1]+a[2]+a[3];
        for (int i=4;i<=n;i++)
        c[i]=min(c[i-1]+a[1]+a[i],a[i]+a[1]+2*a[2]+c[i-2]);
        cout<<c[n];
}
