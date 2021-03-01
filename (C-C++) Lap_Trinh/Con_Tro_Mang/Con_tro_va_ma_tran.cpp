#include<bits/stdc++.h>
using namespace std;
int **Alloc(int n,int m)
{
    int **a=(int **)calloc(n+1,sizeof(int *));
    for(int i=1;i<=n;i++)
    {
        a[i]=(int *)calloc(m+1,sizeof(int));
    }
        return a;
}
void Free(int n,int ***a)
{
    for(int i=1;i<=n;i++) free((*a)[i]);
    free(*a);
}
void nhap(int &n,int &m,int **&a)
{
    printf("Nhap so hang so cot\n");
    scanf("%d%d",&n,&m);
    a=Alloc(n,m);
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            printf("A[%d][%d]=",i,j);
            scanf("%d",&a[i][j]);
        }
    }
}
void xuat(int n,int m,int **&a)
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            printf("%d ",a[i][j]);
        }
        printf("\n");
    }
}
int main()
{
    int **a,n,m;
    nhap(n,m,a);
    xuat(n,m,a);
    Free(n,&a);
}
/*int main()
{
    //tam giac pascal cap n
    int *a[100],n;     //mang cac con tro
    scanf("%d",&n);
    for(int i=0;i<=n;i++)
    {
        a[i]=(int *)calloc(i+1,sizeof(int));
        a[i][0]=a[i][i]=1;
        for(int j=1;j<i;j++)
        {
            a[i][j]=a[i-1][j-1]+a[i-1][j];
        }
    }
    //xuat
    for (int i=0;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            printf("%4d",a[i][j]);
        }
        printf("\n");
    }
    //giai phong bo nho
    for(int i=0;i<=n;i++) free(a[i]);
}
/*int main()
{
    //tam giac pascal cap n
    int **a,n;     //mang cac con tro
    scanf("%d",&n);
    a=(int **) calloc(n+1,sizeof(int *));
    for(int i=0;i<=n;i++)
    {
        a[i]=(int *)calloc(i+1,sizeof(int));
        a[i][0]=a[i][i]=1;
        for(int j=1;j<i;j++)
        {
            a[i][j]=a[i-1][j-1]+a[i-1][j];
        }
    }
    //xuat
    for (int i=0;i<=n;i++)
    {
        for(int j=1;j<=i;j++)
        {
            printf("%4d",a[i][j]);
        }
        printf("\n");
    }
    //giai phong bo nho
    for(int i=0;i<=n;i++) free(a[i]);
}*/

