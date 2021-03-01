#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float S,p,a,b,c;
int main()
{
       scanf("%f%f%f",&a,&b,&c);
       if (a!=0 && b!=0 && c!=0)
     {
        if ( a+b>c || a+c>b || b+c>a )
        if (a+b==c || a+c==b || b+c==a) printf("khong la tam giac");
        else
        {
          p=(a+b+c)/2;
          S = sqrt(p*(p-a)*(p-b)*(p-c));
          printf("%.2f\n%.2f",p*2,S);
        }
            else printf("khong la tam giac");
     }
       else printf("khong la tam giac");
    return 0;
}
