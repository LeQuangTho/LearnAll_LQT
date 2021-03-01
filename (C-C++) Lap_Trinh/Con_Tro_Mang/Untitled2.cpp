#include<bits/stdc++.h>
using namespace std;
void nhap(int *n,int *a)
{
    printf("Nhap so phan tu:  ");
    scanf("%d",n);
    for(int i=1;i<=*n;i++)
    {
        printf("a[%d]= ",i); scanf("%d",&a[i]);
    }
}

int main()
{
    int n,a[1000];
    int *p=a;      //p va a la hai mang chung bo nho
    p[1]=3;       //a[1]=3
    a[2]=5;      //p[2]=5
    *(p+3)=7;    //a[3]=p[3]=7
    for(int i=1;i<=4;i++)
    {
        printf("A[%d]= %d\n",i,a[i]);
    }

    nhap(&n,a);

    for(int i=1;i<=n;i++)
    {
        printf("A[%d]= %d\n",i,a[i]);
    }
}
