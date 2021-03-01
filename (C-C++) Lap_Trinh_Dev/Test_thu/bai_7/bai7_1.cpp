#include <bits/stdc++.h>
using namespace std;
typedef float Arr[100];
void nhap(FILE *f,int *n,Arr *a,Arr *b)
{
	fscanf(f,"%d\n",n);
	for(int i=1;i<=*n;i++)
	{
		fscanf(f,"%f%f\n",&(*a)[i],&(*b)[i]);
	}
}
double kc(float x1,float y1,float x2,float y2)
{
	return sqrt(pow(x1-x2,2)+pow(y1-y2,2));
}
void phan1(FILE *f,int n,Arr a,Arr b)
{
	int j;
	float max=kc(a[1],b[1],0,0),x,y;
	for(int i=1;i<=n;i++)
	{
		if (max<kc(a[i],b[i],0,0))
		{
			max=kc(a[i],b[i],0,0);
			x=a[i];
			y=b[i];
			j=i;
		}
	}
	fprintf(f,"Khoang cach xa goc toa do nhat: d= %f  A%d(%f ,%f )",max,j,x,y);
}
void phan2(FILE *f,int n,Arr a,Arr b)
{
	float S=kc(a[1],b[1],a[n],b[n]);
	for(int i=2;i<=n;i++)
	{
		S+=kc(a[i],b[i],a[n],b[n]);
	}
	fprintf(f,"\nDo giai duong gap khuc(2,3,4,..,n,1): S =%f",S);
}
int main()
{
	int n;
	Arr a,b;
    char x[100];
    printf("Nhap ten tep input: ");gets(x);
	FILE *fi,*fo;
    fi=fopen(x,"r");
    printf("\nNhap ten tep output: ");gets(x);
	fo=fopen(x,"w");
	nhap(fi,&n,&a,&b);
	phan1(fo,n,a,b);
	phan2(fo,n,a,b);
	fclose(fi);
	fclose(fo); 
}
