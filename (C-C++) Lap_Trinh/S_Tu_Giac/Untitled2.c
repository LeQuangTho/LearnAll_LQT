#include<stdio.h>
#include<math.h>
#define dt(xA,yA,xB,yB) (xA*yB+xB*yA)
#define s(xA,yA,xB,yB,xC,yC) fabs(dt(xA,yA,xB,yB)+dt(xC,yC,xB,yB)+dt(xA,yA,xC,yC))
int main()
{
    double xA,yA,xB,yB,xC,yC,xD,yD,s1=0,s2=0,AC,BD;
    scanf("%lf %lf\n",&xA,&yA);
    scanf("%lf %lf\n",&xB,&yB);
    scanf("%lf %lf\n",&xC,&yC);
    scanf("%lf %lf",&xD,&yD);
    AC=sqrt((xC-xA)*(xC-xA)+(yC-yA)*(yC-yA));
    BD=sqrt((xD-xB)*(xD-xB)+(yD-yB)*(yD-yB));
    if (AC<BD)
    {
        s1=s(xA,yA,xB,yB,xC,yC);
        s2=s(xA,yA,xD,yD,xC,yC);
    }
    else
    {
        s1=s(xA,yA,xB,yB,xD,yD);
        s2=s(xB,yB,xD,yD,xC,yC);
    }
    printf("%.2lf",0.25*(s1+s2));
}
