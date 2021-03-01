#include <stdio.h>
int main()
{
    long m[100001],s1=0,s2=0,s3=0,n;
    scanf("%ld",&n);
    for (long i=1;i<=n;i++)
    {
        scanf("%ld",&m[i]);
    }
    for(long i=1,j=n;i<=n,j>=1;i++,j--)
    {
        s1+=m[i]*m[i];
        s2+=m[i]*m[j];
    }
    for(long i=1;i<=n;i++)
    {
        s3+=m[i]*m[i+1];
    }
    printf("%ld\n%ld\n%ld",s1,s2,s3);
    return 0;
}
