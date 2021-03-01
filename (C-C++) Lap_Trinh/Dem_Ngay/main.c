#include <stdio.h>
#include <stdlib.h>
#define nhuan(i) i%400==0?1:(i%4==0 && i%100!=0)?1:0
int d,m,y,d1,m1,y1,dem,h;
int main()
{
    int A[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    scanf("%i%i%i\n%i%i%i",&d,&m,&y,&d1,&m1,&y1);
    if (y == y1)
    {
        if (m == m1)
        {
            if (d == d1) printf("0");
            else printf("%i", d1-d);
        }
        else
        {
            nhuan(y)== 0?A[2]:A[2]++;
            for (int i = m; i< m1 ; i++) dem += A[i] + d1;
            printf("%i", dem);
        }
    }
    else
    {
        for (int i=y; i<=y1;i++) h+=nhuan(i)==0?0:1;
        dem=(y1-y)*365+h;
        for (int i=1;i<m1;i++) d1+=A[i];
        if (nhuan(y1)!=0) d1++;
        for (int i=1;i<m;i++) d+=A[i];
        if (nhuan(y1)!=0) d1++;
      printf("%i",dem-d+d1);
     }
    return 0;
}
