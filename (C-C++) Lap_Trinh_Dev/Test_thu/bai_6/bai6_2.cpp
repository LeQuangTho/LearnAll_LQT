#include <bits/stdc++.h>
using namespace std;
typedef struct{
	char TS[100],TTG[100];
	int NXB;
}sach[100];
void nhap(FILE *f,int *n,sach *a)
{
	fscanf(f,"%d\n",n);
	for (int i=1;i<=*n;i++)
	{
		fscanf(f,"%s\n",&(*a)[i].TS);
		fscanf(f,"%s\n",&(*a)[i].TTG);
		fscanf(f,"%d\n",&(*a)[i].NXB);
	}
}
void phan1(FILE *f,int n,sach a)
{
	int d=0;
	char x[100];
	printf("\nNhap ten sach can tim: "); gets(x);
		for (int i=1;i<=n;i++)
	{
		if(strcmp(x,a[i].TS)==0)
		{
			
			fprintf(f,"\nCuon sach tren nam o vi tri %d",i);
			fprintf(f,"\n-Ten tac gia: %s",a[i].TTG);			
			fprintf(f,"\n-Nam xuat ban: %d",a[i].NXB);			
		}
		else d++;
	}
	if(d==n) fprintf(f,"khong co cuon sach nay!"); 
}
void phan2(FILE *f,int n,sach a)
{
	char b[]="ten sach",c[]="ten tac gia",d[]="nam XB";
	fprintf(f,"\n%-10s\t%-20s\t%-10s",b,c,d);
	for (int i=1;i<=n;i++)
	{
		if(a[i].NXB<2000)
		{
			fprintf(f,"\n%-10s\t%-20s\t%-10d",a[i].TS,a[i].TTG,a[i].NXB);			
		} 
	}
}
void xuat(FILE *f,int n,sach a)
{
	fprintf(f,"\n danh sach tat ca sach!");
	char b[]="ten sach",c[]="ten tac gia",d[]="nam XB";
	fprintf(f,"\n%-25s\t%-20s\t%-10s",b,c,d);
	for (int i=1;i<=n;i++)
		fprintf(f,"\n%-25s\t%-20s\t%-10d",a[i].TS,a[i].TTG,a[i].NXB);
}
int main()
{
	FILE *fi,*fo;
	int n;
	sach a;
	fi=fopen("bai6in_2.txt","r");
	fo=fopen("bai6out_2.txt","w");
	nhap(fi,&n,&a);
	phan1(fo,n,a);
	phan2(fo,n,a);
	xuat(fo,n,a);
	fclose(fi);
	fclose(fo);
}
