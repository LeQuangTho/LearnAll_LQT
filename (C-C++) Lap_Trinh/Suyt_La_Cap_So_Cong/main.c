#include<stdio.h>

int main()
{
    int n,a[1000],thu=0,dem=0,vitri=0;
    scanf("%d",&n);
    for (int i=1;i<=n;i++) scanf("%d",&a[i]);
     thu=a[2]-a[1];
    for (int i=2;i<n;i++)
    {
        if (a[i+1]-a[i]!=thu)
        {
            dem++;
            vitri=thu<0?(i+1):i;
        }
        if (dem==3) break;
    }
    if (dem==0) printf("day la day cap so cong");
    else if (dem==3) printf("day la gan cap so cong tai vi tri %d",vitri);
    else printf("day khong la day gan cap so cong");
}
