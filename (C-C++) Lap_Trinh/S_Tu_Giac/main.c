#include <stdio.h>
#include <math.h>
double xA,xB,xC,xD,yA,yB,yC,yD,p1,p2,s,AB,BC,CD,AD,AC,AD,BD;
int main()
{
    scanf("%lf%lf%lf%lf%lf%lf%lf%lf", &xA,&yA,&xB,&yB,&xC,&yC,&xD,&yD);
    AB=sqrt((xB-xA)*(xB-xA)+(yB-yA)*(yB-yA));
    BC=sqrt((xB-xC)*(xB-xC)+(yB-yC)*(yB-yC));
    CD=sqrt((xD-xC)*(xD-xC)+(yD-yC)*(yD-yC));
    AD=sqrt((xD-xA)*(xD-xA)+(yD-yA)*(yD-yA));
    AC=sqrt((xC-xA)*(xC-xA)+(yC-yA)*(yC-yA));
    BD=sqrt((xD-xB)*(xD-xB)+(yD-yB)*(yD-yB));
    if (AC<BD)
    {
    p1=(AB+BC+AC)/2;
    p2=(AD+AC+CD)/2;
    s=sqrt(p1*(p1-AB)*(p1-AC)*(p1-BC))+sqrt(p2*(p2-AD)*(p2-AC)*(p2-CD));
    }
    else
    {
    p1=(AB+AD+BD)/2;
    p2=(BC+CD+BD)/2;
    s=sqrt(p1*(p1-AB)*(p1-AD)*(p1-BD))+sqrt(p2*(p2-BC)*(p2-CD)*(p2-BD));
    }
   printf("%lf",s);
    return 0;
}
