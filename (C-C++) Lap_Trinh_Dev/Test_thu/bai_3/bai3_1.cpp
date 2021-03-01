// Câu 1
#include<stdio.h>
typedef int Arr[100][100];
void nhap(FILE *f,int *m,int *n,Arr *A)
{
	fscanf(f,"%d%d\n",m,n);
	for(int i=1;i<=*n;i++)
	for(int j=1;j<=*m;j++)
	fscanf(f,"%d",&(*A)[i][j]);	
}
void phan4(FILE *f,int m,int n,Arr A)
{
	fprintf(f,"\n Ma tran trong tep la:\n");
	for(int i=1;i<=n;i++)
	{
	for(int j=1;j<=m;j++)
	fprintf(f,"%d ",A[i][j]);
	fprintf(f,"\n"); 
	}	
}
void inConsol(int m,int n,Arr A)
{
	
	for(int i=1;i<=n;i++)
	{
	for(int j=1;j<=m;j++)
	printf("%d ",A[i][j]);
	printf("\n"); 
	}	
}
void phan2(FILE *f,int m,int n,Arr A)
{
	int d=0,S=0;
	for(int i=1;i<=n;i++)
	for(int j=1;j<=m;j++)
	if(A[i][j]%2==0 && A[i][j]%3==1) 
	{
		d++;
		S+=A[i][j];
	}
	fprintf(f,"TBC cac so chan va chia het cho 3 du 1 la: %d",S/d);
}
void phan3(FILE *f,int m,int n,Arr A)
{
	
	for(int i=1;i<=n;i++)
	{
		int S=0;
	for(int j=1;j<=m;j++)
	{
		
		S+=A[i][j];
	}
	fprintf(f,"\nTong hang %d la: %d",i,S);
    }
}
int main()
{
	FILE *fi,*fo;
	fi=fopen("bai3in_1.txt","rt");
	fo=fopen("bai3out_1.txt","wt");
	int m,n;
	Arr a;
	nhap(fi,&m,&n,&a);
	inConsol(m,n,a);
	phan2(fo,m,n,a);
	phan3(fo,m,n,a);
	phan4(fo,m,n,a);
	fclose(fi); 
	fclose(fo); 
}

