#include<bits/stdc++.h>
using namespace std;
struct diem{
    float x,y;
};
int nhap(diem *a)
{
    int m;
    printf("nhap so diem: ");
    scanf("%d",&m);
    for(int i=1;i<=m;i++)
    {
        printf("a[%d]= ",i); scanf("%d%d",&a[i].x,&a[i].y);
    }
    return m;
}
void xuat(int n,diem *a)
{
     for(int i=1;i<=n;i++)
    {
        printf("a[i]=(%f,%f)",(a[i].x),(a[i].y));
    }
}
float dgk(int n,diem *a)    //tinh duong gap khuc qua diem a1...a[n]
{
    int d=0;
    for(int i=1;i<=n;i++)
    {
        d+=sqrt((a[i].x-a[i+1].x)*(a[i].x-a[i+1].x) + (a[i].y-a[i+1].y)*a[i].y-a[i+1].y);
    }
    return d;
}
float xaO(int n,diem *a)    //tim khoang cach diem xa O nhat
{
    float max = sqrt((a[1].x*a[1].x) + (a[1].y*a[1].y));
    for(int i=1;i<=n;i++)
    {
        if(max< sqrt((a[i].x*a[i].x) + (a[i].y*a[i].y)));
    }
    return max;
}
float gannhau(int n,diem *a)    // tim khoang cach hai diem gan nhau nhat
{
     float min=sqrt((a[1].x-a[2].x)*(a[1].x-a[2].x) + (a[1].y-a[2].y)*a[1].y-a[2].y);
     for(int i=1;i<n;i++)
     {
         for (int j=i;j<=n;j++)
         {
             if(min>sqrt((a[i].x-a[j].x)*(a[i].x-a[j].x) + (a[i].y-a[j].y)*a[i].y-a[j].y))
                min =sqrt((a[i].x-a[j].x)*(a[i].x-a[j].x) + (a[i].y-a[j].y)*a[i].y-a[j].y);
         }
     }
     return min;
}
int demdoan(int n,diem *a)    //dem so doan co hai dau mut trong goc 1
{
    int d=0;
    for(int i=1;i<=n;i++)
    {
        if(a[i].x>0 && a[i].y>0) d++;
    }
    return d*(d-1);
}
int main()
{
    int n;
    diem A[1000];
    n=nhap(A);
    xuat(n,A);
    printf("\nDo dai duogn gap khuc: d=%f",dgk(n,A));
    printf("\nDo dai diem xa O nhat: d=%f",xaO(n,A));
    printf("\nKhoang cach cua hai diem gan nhau nhat la: d=%f",gannhau(n,A));
    printf("\nSo doan thang tao tu N diem tren la: d=%d",demdoan(n,A));
}
