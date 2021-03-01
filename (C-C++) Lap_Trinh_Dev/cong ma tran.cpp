#include<stdio.h>
int main()
{
    long m[1000][1000],n[1000][1000],f[1000][1000],k,h;
    scanf("%ld %ld",&k,&h);
    for(long i=1;i<=k;i++) 
    {
        for (long j=1 ;j<=k;j++)
         {
		 scanf("%ld",&m[i][j]);}
    }
    
     for(long i=1;i<=k;i++) 
    {
        for (long j=1 ;j<=k;j++)
         {
		 scanf("%ld",&n[i][j]);}
    }
     for(long i=1;i<=k;i++) 
    {
        for (long j=1 ;j<=k;j++)
         {
		 f[i][j]=(m[i][j])+(n[i][j]);
		 }
    }
    
     for(long i=1;i<=k;i++) 
    {
        for (long j=1 ;j<=k;j++)
         {
		 printf ("%ld ",f[i][j]);}   
		 printf("\n");
    }
    
}
