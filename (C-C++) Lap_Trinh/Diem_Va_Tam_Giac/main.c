#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define dt(xA,yA,xB,yB) (xA*yB-yA*xB)
#define S(xA,yA,xB,yB,xC,yC) fabs(dt(xA,yA,xB,yB)+dt(xB,yB,xC,yC)+dt(xC,yC,xA,yA))
double xA,yA,xB,yB,xC,yC,x,y;
int main()
{
    scanf("%lf%lf%lf%lf%lf%lf%lf%lf",&xA,&yA,&xB,&yB,&xC,&yC,&x,&y);
   double s=S(xA,yA,xB,yB,xC,yC);
   double s1=S(xA,yA,xB,yB,x,y);
   double s2=S(xB,yB,xC,yC,x,y);
   double s3=S(xC,yC,xA,yA,x,y);
    if (s1+s2+s3==s) printf(s1*s2*s3==0?"M o tren canh tam giac":"M o trong tam giac");
    else printf("M o ngoai tam giac");
    return 0;
}
