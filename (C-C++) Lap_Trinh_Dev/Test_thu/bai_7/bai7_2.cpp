#include <bits/stdc++.h>
using namespace std;
#include<string.h>
typedef struct{
	char ht[100],Dh[100];
	double D;
}sv[100],sv1;
void nhap(FILE *f,int *n,sv *a)
{
	fscanf(f,"%d\n",n);
	for(int i=1;i<=*n;i++)
	{
		fscanf(f,"%[^\n]",&(*a)[i].ht);
		fscanf(f,"%lf\n",&(*a)[i].D);
		fscanf(f,"%c\n",&(*a)[i].Dh);
	}
}
void xuat(FILE *f,int n,sv a)
{
	for(int i=1;i<=n;i++)
	{
		fprintf(f,"\n%s",a[i].ht);
		fprintf(f,"\n%lf",a[i].D);
		fprintf(f,"\n%s",a[i].Dh);
	}
}
void phan1(FILE *f,int n,sv a)
{
	double A=0,B=0,C=0;
	for(int i=1;i<=n;i++)
	{
		if(stricmp(a[i].Dh,"A")==0) A+=a[i].D;
		else if(strcmp(a[i].Dh,"B")==0)  B+=a[i].D;
		else C+=a[i].D;	
    }
    double D=(A<B?(A<C?A:C):(B<C?B:C));
    char x[10];
    if(D==A) strcmp(x,"A"); 
    else if(D==B) strcmp(x,"B");
    else strcmp(x,"C");
	fprintf(f,"Truong co so diem thap nhat: %c %lf ",x,D);
}
void phan2(FILE *f,int n,sv a)
{
	for(int i=1;i<n;i++)
	for(int j=i;j<=n;j++)
	{
		if(a[i].D<a[j].D)
		{
			sv1 b;
			b=a[i];
			a[i]=a[j];
			a[j]=b;
		}
	}
	fprintf(f,"\n3 thi sinh co diem cao nhat:\n");
	for(int i=1;i<=3;i++)
	{
		fprintf(f,"\n%d. %s",i,a[i].ht);
		fprintf(f,"\n%lf",a[i].D);
		fprintf(f,"\n%s",a[i].Dh);
	}
	
}
int main()
{
	FILE *fi,*fo;
	fi=fopen("bai7in_2.txt","r");
	fo=fopen("bai7out_2.txt","w");
	int n;
	sv a;
	nhap(fi,&n,&a);
	xuat(fo,n,a);
	phan1(fo,n,a);
	phan2(fo,n,a);	
    fclose(fi);
    fclose(fo);
}

