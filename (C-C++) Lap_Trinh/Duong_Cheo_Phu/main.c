#include <stdio.h>
double m[12][12], S=0;
double sum()
{
    for(int i=1;i<12;i++)
        for(int j=12-i;j<12;j++) S+=m[i][j];
        return S;
}

int main()
{
    char n;
    scanf("%s",&n);
    for(int i=0;i<12;i++)
        for(int j=0;j<12;j++) scanf("%lf",&m[i][j]);
    if (n=='S') printf("%.1lf",sum());
        else if (n=='M') printf("%.1lf",sum()/66);
    return 0;
}
