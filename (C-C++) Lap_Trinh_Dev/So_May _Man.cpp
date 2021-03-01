#include <stdio.h>
#include <math.h>
int main()
{
	int n,n0,m1[10000],m2[10000];
	scanf("%d",&n);
    int d;
	while (n0!=0)
     {
     	n0=n;
     	n0=n0/10;
     	d++;
	 }
	 for (int i=1;i<=d;i++)
	 {
	 	m1[i]=n/pow(10,d-1);
	 }
	 for (int i=1;i<=d;i++)
	 {
	 	m2[i]=m1[i]<6?0:m1[i]<8?6:8;
	 }
    for (int i=1;i<=d;i++)	
    {
    	printf ("%d",m2[i]);
	}
	return 0;
}


