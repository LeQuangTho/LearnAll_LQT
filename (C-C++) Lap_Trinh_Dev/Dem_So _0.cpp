#include<stdio.h>
int dem(int a,int b,int x[])
{
	int k=0;
	for(int i=a;i<=b;i++)
	{
		if(x[i]==0) k++;
		else break;
	}
	return k;
}
int gtln(int a,int b[])
{
	int max=b[1];
	for(int i=1;i<=a;i++)
	if (b[i]>max) max=b[i];
	return max;
}
int main()
{
	int n,a[10007],b[100];
	scanf("%d",&n);
	for(int i=1;i<=n;i++) scanf("%d",&a[i]);
	int j=1;
	for (int i=1;i<=n;i++)
	{
		if(a[i]==0) 
		{
			b[j]= dem(i,n,a);
		    i+=b[j];
		    j++;
		}
		else continue;
	}
	int max=0;
	max=gtln(j,b);
	printf("%d",max);
}

