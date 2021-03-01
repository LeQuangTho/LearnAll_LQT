#include <stdio.h>
#include <math.h>
float a,b,c,x1,x2,x,delta,t;
int main()
{
    scanf("%f%f%f",&a,&b,&c);
    if (a==0)
    {
     if (b==0)
     {
         if (c==0) printf("vo so nghiem");
         else printf("vo nghiem");
     }
     else printf("%.3f",x=c==0?0:((-c)/b));
    }
    else
    {
           float b_=b/2;
            delta=b_*b_-a*c;
        if (delta<0) printf("vo nghiem");
        else if (delta==0) printf("%.3f",x=-b_/a);
        else
        {
            x1=(-b_-sqrt(delta))/a;
            x2=(-b)/a-x1;
            t=x1<x2?x1:x2;
            float t1=(-b)/a-t;
            printf("%.3f\n%.3f",t,t1);
        }
    }
    return 0;
}
