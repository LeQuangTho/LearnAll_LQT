#include <stdio.h>
#include <math.h>
int main()
{
    double m[1000],s1=0,s2=0,n,d1=0,d2=1,x=0,y=0;
    scanf("%lf",&n);
    for (int i = 1; i<=n;i++)
    {
        scanf("%lf",&m[i]);
        if (m[i]<0)
            {
                d1+=m[i];
                x++;
            }
            else if (m[i]>0)
                {
                    d2*=m[i];
                    y++;
                }
    }
    if (x==0) printf("khong co so am\n");
    else
    {
        s1=d1/x;
        printf("%lf\n",s1);
    }
    if (y==0) printf("khong co so duong");
    else
    {
        s2=pow(d2,1/y);
        printf("%lf",s2);
    }
}
