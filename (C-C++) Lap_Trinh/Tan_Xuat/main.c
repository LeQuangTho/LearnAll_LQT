#include <stdio.h>
int main()
{
    int a[1000],n,s=0;
    scanf("%d",&n);
    for (int i=0;i<n;i++) scanf("%d",&a[i]);
    for (int i=0;i<n||s==n;i++)
    {
        int d=0,min=99999;
        for (int j=0;j<n;j++)
        {
            if (a[j]<min) min=a[j];
        }
        for (int j=0;j<n;j++)
        {

            if (a[j]==min)
            {
                d++;
                a[j]=99999;
            }
        }
       printf("%d %d\n",min,d);
       s+=d;
       if (s==n) break;
    }
}
