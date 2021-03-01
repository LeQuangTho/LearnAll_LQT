#include<stdio.h>
long m[20],n[20],t[20];
int k;
int main()
{
    scanf("%ld",&k);
    for (long i = 1 ; i <= k ; k++)
    {
    scanf ("%ld",&m[i]);	
	}
	for (long j = 1 ; j <= k ; k++)
        {
   	       scanf("%ld",&n[j]);
	    }
	for (long h = 1 ; h <= k ; h++)
	{
		t[h] = m[h] + n[h];
    }
    for (long h = 1 ; h <= k ; h++)
    {
    	printf("%ld",t[h]);
	}
	
}
