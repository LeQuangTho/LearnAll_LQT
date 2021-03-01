// bai giong thay
#include <stdio.h>
#include <stdlib.h>
#define nhuan(y) y%400==0?1:(y%4==0 && y%100!=0)?1:0
int d,m,y,r=1;
int main()
{
    scanf("%d/%d/%d",&d,&m,&y);
   {
    if (y<0 || m>12 ||d<0 || d>31) r=0;
    else if ((m==4||m==6||m==9||m==11)&&d==31) r=0;
    else if (m==2) r=nhuan(y)?d<30:d<29;
   }
    if (r==1) printf("Ngay hop le");
    else printf("Ngay khong hop le");
     return 0;
}

