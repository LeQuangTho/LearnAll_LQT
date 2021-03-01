#include<bits/stdc++.h>
using namespace std;
// Nhap 1 mang
// dao mang
// Sap xep
typedef int Arr[100];
void nhap(int *n,int *A)    //C
{
    printf("nhap so phan tu:  ");
    scanf("%d",&(*n));
    for(int i=1;i<=*n;i++)
    {
        printf("A[%d]= ",i);
        scanf("%d",&A[i]);          /////
    }
}
/*void input(int &n,Arr &A)     //C++
{
    printf("nhap so phan t:  ");
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        printf("A[%d]= ",i);
        scanf("%d",A+i);
    }
}*/
void xuat(int n,Arr A)
{
    for(int i=1;i<=n;i++)
    {
        printf("A[%d]= %d\n",i,A[i]);
    }
}
int main()
{
    int n,m;
    Arr A,B;
    nhap(&n,A);
    // input(m,B);
    xuat(n,A);
    //xuat(m,B);
}
