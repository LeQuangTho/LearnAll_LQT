// cho a,b la hai day hinh thang 2 goc o day 45*
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float a,b,s1,s2;
int main()
{
    scanf("%f%f",&a,&b);
    s1=(a*a-b*b)/4;
    s2=(b*b-a*a)/4;
   if (a>b) printf("%.2f",s1);
   else printf("%.2f",s2);
    return 0;
}
