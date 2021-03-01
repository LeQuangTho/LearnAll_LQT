#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    int n,m[10001],ok=0,ok1=0;
    double s1=0,s2=0;
    scanf("%i",&n);
    for (int i=1;i<=n;i++)
    {
        scanf("%i",&m[i]);
    }
    while(ok=0)
    for (int i=1;i<=n;i++)
    {
        if (s1<0) ok=1;
        else s1=sqrt(s1+m[i]);
    }
    while(ok1=0)
    for (int i=n;i>=1 ;i--)
    {
        if (s2<0) ok1=1;
        else s2=sqrt(s2+m[i]);
    }
    if (s1!=0) printf("%.3lf\n",s1);
    else printf("Khong tinh duoc S1\n");
     if (s2!=0) printf("%.3lf",s2);
    else printf("Khong tinh duoc S2");
}
