// giai pt bac nhat a.aa*X.XXX+b.bb=0
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float a,b,x;
int main()
{
    scanf("%f %f",&a,&b);
    if (a==0 && b==0) printf("Vo So Nghiem");
     else if (a==0) printf("Vo Nghiem");
     else if (a!=0 && b==0) printf("%.3f",x=0/a);
     else printf("%.3f",x=-b/a);
      return 0;
}
