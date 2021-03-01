#include<stdio.h>
#include<math.h>
void doctep(int a[],int b[],int *p)
{
	FILE *f;
	char x[100];
    gets(x);
	f=fopen(x,"rt");
	fscanf(f,"%d",p);
	for (int i=1;i<=*p;i++)
	fscanf(f,"%d %d\n",&a[i],&b[i]);
}
int kcln(int a,int b[],int c[])
{
	int max=1,vt=sqrt(c[1]*c[1]+b[1]*b[1]);
	for (int i=1;i<=a;i++)
	{
		if(vt<sqrt(c[i]*c[i]+b[i]*b[i]))
	    {
		   vt=sqrt(c[i]*c[i]+b[i]*b[i]);
		   max=i;
		}
	}
	return max;
}
int goc3(int n,int a[],int b[])
{
	int d=0;
	for(int i=1 ;i<=n ;i++)
	{
		if(a[i]<0&&b[i]<0) d++;
	}
	return d*(d-1);
}
int main()
{
	int p,a[100],b[100];
	doctep(a,b,&p);
	printf("Vi tri xa goc toa do nhat la diem thu %d",kcln(p,a,b));
	printf("\nso doan thang goc phan tu thu 3 la %d",goc3(p,a,b)/2);
}

