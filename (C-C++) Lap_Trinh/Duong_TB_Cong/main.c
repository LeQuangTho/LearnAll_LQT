#include <stdio.h>
double m[6];
int i,d=0;
double S=0;
int main()
{
    for(i=1;i<=6;i++)
    {
        scanf("%f",&m[i]);
    }
    for(i=1;i<=6;i++)
    {
        if (m[i]>0)
        {
            d++;
            S=S+m[i];
        }
    }
    printf("%i Gia tri duong",d);
    if (d==0) printf("\n0.0");
    else printf("\n%.1lf",S/d);
    return 0;
}
