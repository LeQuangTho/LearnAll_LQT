#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
    {
    float a0,b0,x0,y0,r,h,b_,k;
    float a,b,c,x1,x2,delta,t; scanf("%f%f\n%f%f%f",&a0,&b0,&x0,&y0,&r);
    a= a0*a0+1;
    b= -2*x0+2*a0*b0-2*a0*y0;
    c= x0*x0+b0*b0-2*b0*y0+y0*y0-r*r;
      b_=b/2;
      delta=b_*b_-a*c;
    if (delta<0) printf("Hai duong khong cat nhau");
    else if (delta==0) printf("Hai duong tiep xuc tai (%.3f, %.3f)",-b_/a,a0*(-b_/a)+b0);
    else
        {
        x1=(-b_-sqrt(delta))/a;
        x2=(-b/a)-x1;
     if (x1<x2)
       {
           h=x1;
           k=x2;
       }
       else
       {
           h=x2;
           k=x1;
       }
       }
     printf("Hai duong cat nhau tai hai diem phan biet (%.3f, %.3f) va (%.3f, %.3f)",h,a0*h+b0,k,a0*k+b0);

}
