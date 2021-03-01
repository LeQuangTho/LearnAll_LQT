//lam lai theo kieu phu dinh
#include <stdio.h>
#include <stdlib.h>
#define nhuan(y) y%400==0?1:(y%4==0 && y%100!=0)?1:0
int d,m,y,r=1;
int main()
{
    scanf("%i%i%i",&d,&m,&y);

    if (r) printf("Ngay hop le");
    else printf("Ngay khong hop le");
     return 0;
}
