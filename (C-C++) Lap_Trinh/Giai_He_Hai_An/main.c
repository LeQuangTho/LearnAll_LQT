#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float a,b,c,a1,b1,c1,x,y,d,dx,dy;
int main()
{
    scanf("%f%f%f%f%f%f",&a,&b,&c,&a1,&b1,&c1);
       d=a*b1-a1*b;
       dx=c*b1-c1*b;
       dy=a*c1-a1*c;
       if (d!=0)
       {
             x=dx/d;
             y=dy/d;
             printf("x = %.3f\ny = %.3f",x,y);
        }
       else if (dx!=0) printf("HE PHUONG TRINH VO NGHIEM");
       else printf ("HE PHUONG TRINH VO SO NGHIEM");
}
