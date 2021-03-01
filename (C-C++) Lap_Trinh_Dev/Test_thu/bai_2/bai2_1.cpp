#include<bits/stdc++.h>
using namespace std;
typedef int Arr[100];
void nhap(FILE *f,int *n,Arr *A,Arr *B)    //c
{
    fscanf(f,"%d\n",n);
//  *A=(int *)calloc(*n,sizeof(int));
//	*B=(int *)calloc(*n,sizeof(int));
    for(int i=1;i<=*n;i++)
    {
        fscanf(f,"%d%d\n",&(*A)[i],&(*B)[i]);
    }
}
double kc(int x1,int x2,int y1,int y2)
{
	return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
void phan1(FILE *f,int n,Arr A,Arr B)
{
	int x=1;
	double max=kc(A[1],0,B[1],0);
	for(int i=2;i<=n;i++)
	if (max<kc(A[i],0,B[i],0)) 
	{
		max=kc(A[i],0,B[i],0);
		x=i;
	}
	fprintf(f,"\nCac diem co khoang cach xa O nhat d=%lf\n",max);
	
	for(int i=1;i<=n;i++)
	if (max==kc(A[i],0,B[i],0)) 
	{
		fprintf(f,"diem A[%d]=(%d, %d)\n",i,A[i],B[i]);
	}
}
void phan2(FILE *f,int n,Arr A,Arr B)
{
	int D=0;
	for(int i=1;i<=n;i++)
	if(A[i]<0&&B[i]<0) D++;
	fprintf(f,"\nSo doan thang nam o goc phan tu thu III la:  %d",D);
}
int main()
{
	FILE *fi,*fo; 
	fi=fopen("bai2in_1.txt","rt");
	fo=fopen("bai2out_1.txt","wt");
    Arr a,b;
	int n;
	nhap(fi,&n,&a,&b);
	phan1(fo,n,a,b);
	phan2(fo,n,a,b);
	fclose(fi);
	fclose(fo);
}

