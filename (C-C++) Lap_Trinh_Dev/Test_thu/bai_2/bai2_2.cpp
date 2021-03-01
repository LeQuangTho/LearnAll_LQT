#include<stdio.h>
#include<string.h>
typedef struct{
	char ht[100];
    int L,maCV;
}NV[100],NV1;
void nhap(FILE *f,int *n,NV *A)
{
	fscanf(f,"%d\n",n);
	for(int i=1;i<=*n;i++)
	{
		fscanf(f,"%[^\n]",&(*A)[i].ht);
		fscanf(f,"%d\n",&(*A)[i].L);
		fscanf(f,"%d\n",&(*A)[i].maCV);
	}
}
void phan1(FILE *f,int n,NV A)
{
	fprintf(f,"%d\n",n);
	for(int i=1;i<=n;i++)
	{
		fprintf(f,"%s\n%d\n%d\n",A[i].ht,A[i].L,A[i].maCV);
	}
}
void phan2(FILE *f,int n,NV A)
{
	char a[]="Ho ten", b[]="luong", c[]="ma CV";
	fprintf(f,"%d\n",n);
	fprintf(f,"%-25s\t%-10s\t%-5s\n",a,b,c);
	for(int i=1;i<n;i++)
	for(int j=i;j<=n;j++)
	{
		if (A[i].L>A[j].L)
		{
			NV1  t;
			t=A[i];
			A[i]=A[j];
			A[j]=t;
		}
	}
	for(int i=1;i<=n;i++)
	{
		fprintf(f,"%-25s\t%-10d\t%-5d\n",A[i].ht,(A)[i].L,A[i].maCV);
	}
}
int main()
{
	FILE *fi,*fo;
	fi=fopen("bai2in_2.txt","r");
	fo=fopen("bai2out_2.txt","w");
    NV a;
    int n;
    nhap(fi,&n,&a);
    phan1(fo,n,a);
    phan2(fo ,n,a);
    fclose(fi);
    fclose(fo);
}

