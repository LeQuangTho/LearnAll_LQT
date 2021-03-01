#include <bits/stdc++.h>
using namespace std;
typedef int Arr[100][100];
void nhap(FILE *f,int *m,int *n,Arr *a)
{
	fflush(f);
	fscanf(f,"%d%d",m,n);
	for(int i=1;i<=*m;i++)
	for(int j=1;j<=*n;j++)
	{
		fscanf(f,"%d",&(*a)[i][j]);
	}
}
void phan1(FILE *f,int m,int n,Arr a)
{
	double S=0;
	int d=0;
	for(int i=1;i<=m;i++)
	for(int j=1;j<=n;j++)
	{
		if(a[i][j]>=-10 && a[i][j]<=-1) 
		{
			S+=a[i][j];
			d++;
		}
	}
	if (d==0) fprintf(f,"Ma tran ko co phan tu am!");
	else fprintf(f,"\ntrung binh cong cac phan tu thuoc [-10,-1]: %lf",S/d);
}
int kiemtra(int m,int n,Arr a)
{
	for(int i=1;i<=m;i++)
	for(int j=1;j<=n;j++)
	{
		if(a[i][j]<0) 
		{
			return a[i][j];
		}
	}
	return 1;
}
void phan2(FILE *f,int m,int n,Arr a)
{
	if(kiemtra(m,n,a)==1) fprintf(f,"\nMa tran ko co phan tu am!");
	else
	{
		int max=kiemtra(m,n,a);
			for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
			{
				if(a[i][j]<0 && a[i][j]>max) 
				{
					max= a[i][j];
				}
			}
	fprintf(f,"\nphan tu am lon nhat: %d",max);
	}
}
int main()
{
	FILE *fi,*fo;
	fi=fopen("bai6in_1.txt","r");
	fo=fopen("bai6out_1.txt","w");
	int m,n;
	Arr A;
	nhap(fi,&m,&n,&A);
	phan1(fo,m,n,A);
	phan2(fo,m,n,A);
	fclose(fi);
	fclose(fo);
}

