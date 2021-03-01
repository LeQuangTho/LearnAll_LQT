#include <bits/stdc++.h>
using namespace std;
typedef struct{
	char ht[100];
	int N,K;
}DangL[100],D;
void nhap(FILE *f,int *n,DangL *a)
{
	fscanf(f,"%d\n",n);
	for(int i=1;i<=*n;i++)
	{
		fscanf(f,"%[^\n]s",&(*a)[i].ht);
		fscanf(f,"%d %d\n",&(*a)[i].N,&(*a)[i].K);
	}
}
void phan1(FILE *f,int n,DangL a)
{
	for(int i=1;i<n;i++)
	for(int j=i;j<=n;j++)
	{
		if(a[i].K>a[i].K)
		{
			D t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
	char b[]="ho ten",c[]="Nam sinh",d[]="nam K";
	fprintf(f,"%-25s\t%-10s\t%-10s\n",b,c,d);
	for(int i=1;i<=n;i++)
	fprintf(f,"%-25s\t%-10d\t%-10d\n",a[i].ht,a[i].N,a[i].K);
}
void phan2(FILE *f,int n,DangL a)
{
	fprintf(f,"may thang tren 20nam tuoi dang la! \n");
	char b[]="ho ten",c[]="Nam sinh",d[]="nam K";
	fprintf(f,"%-25s\t%-10s\t%-10s\n",b,c,d);
	for(int i=1;i<=n;i++)
	{
		if(2019-a[i].K>=20)
	  	fprintf(f,"%-25s\t%-10d\t%-10d\n",a[i].ht,a[i].N,a[i].K);
    }
}
int main()
{
   FILE *fi,*fo;
   fi=fopen("bai3in_2.txt","r");
   fo=fopen("bai3out_2.txt","w");
   DangL a;
   int n;
   nhap(fi,&n,&a);
   phan1(fo,n,a);
   phan2(fo,n,a);
   fclose(fi);
   fclose(fo);
}
