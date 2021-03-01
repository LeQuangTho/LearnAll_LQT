#include <bits/stdc++.h>
using namespace std;
typedef int Arr[100];
void nhap(FILE *f,int *n,Arr *a,Arr *b)
{
	fscanf(f,"%d\n",n);
	for(int i=1;i<=*n;i++)
	{
		fscanf(f,"%d%d\n",&(*a)[i],&(*b)[i]);
	}
}
double kc(int x,int y)
{
	return sqrt(x*x+y*y);
}
void phan1(FILE *f,int n,Arr a,Arr b)
{
	int ngoai=0,trong=0;
	for(int i=1;i<=n;i++)
	{
		if(kc(a[i],b[i])>5) ngoai++;
		else if(kc(a[i],b[i])<5) trong++;
	}
	fprintf(f,"Co %d diem nam ngoai va %d diem nam trong duong tron tam O voi R=5 !",ngoai,trong);
	fprintf(f,"\nCo %d doan nam trong duong tron tam O voi R=5 !",trong*(trong-1));
}
int main()
{
	FILE *fi,*fo;
	Arr a,b;
	int n;
	fi=fopen("bai8in_1.txt","r");
	fo=fopen("bai8out_1.txt","w");
	nhap(fi,&n,&a,&b);
	phan1(fo,n,a,b);
	fclose(fi);
	fclose(fo);
}
