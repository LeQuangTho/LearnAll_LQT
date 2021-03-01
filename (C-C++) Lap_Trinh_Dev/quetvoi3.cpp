#include<stdio.h>
int main()
{
       long long x[10000000],n,a,b,m,k,d;
       scanf("%lld %lld %lld",&n,&m,&k);
       for(long long i=1;i<=n;i++)
       {
           scanf("%lld %lld",&a,&b);
           x[a+1]++;
           x[b+1]--;
       }
	    for(long long i=1;i<=m;i++)
		{
		      x[i]+=x[i-1];
		      if (x[i]>=k) d++;	
	    }
	    printf("%lld",d);
}
