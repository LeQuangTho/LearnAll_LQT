#include<stdio.h>
int main()
{
    long long a[100][100],b[100][100],c[100][100];
    int m,n,p,sum=0;
    scanf("%d %d %d",&m,&n,&p);
    for (int i=1;i<=m;i++)
        for (int j=1;j<=n;j++) scanf("%lld",&a[i][j]);
    for (int i=1;i<=n;i++)
        for (int j=1;j<=p;j++) scanf("%lld",&b[i][j]);
     for (int i = 1; i <= m; i++)
     {
      for (int j = 1; j <= p; j++)
      {
         sum = 0;
         for (int k = 1; k <= n; k++)
         {
            sum = sum + a[i][k] * b[k][j];
         }
         c[i][j] = sum;
       }
      }
     for (int i = 1; i <=m ; i++) {
      for (int j = 1; j <=p; j++) {
         printf(" %lld ", c[i][j]);
      }
      printf("\n");
   }
}
