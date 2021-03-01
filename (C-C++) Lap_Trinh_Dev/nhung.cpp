#include<bits/stdc++.h>
using namespace std;
typedef int Arr[100];
void nhap(int *n,Arr *A)   
{
	printf("\nNhap so phan tu: ");
    scanf("%d",n);
    for(int i=1;i<=*n;i++)
    {
    	printf("\nA[i]= ",i);
        scanf("%d",&(*A)[i]);
    }
}

void phan1(int n,Arr A)  
{
	int d=0;
	for(int i=1;i<=n;i++)
	if(A[i]>=50&&A[i]<=100) d++;
	printf("\nSo phan tu nam trong doan [50,100] la: %d",d);
}
int max(int n,Arr A)
{
	int max=A[1];
	for(int i=1;i<=n;i++)
	if(A[i]>max) max=A[i];
	return max;
}
void phan2(int n,Arr A)
{
	int d=0;
	int k=max(n,A);
	for(int i=1;i<=n;i++)
	if(A[i]==k) d++;
	printf("\nSo phan tu bang so lon nhat la: %d",d);
}
void phan3(int n,Arr A)
{
	int tl,c=0,tc;
	for(int i=1;i<=n;i++)
	{
		if(A[i]%2==0) 
		{
			tc+=A[i];
			c++;
		}
		else 
		{
			tl+=A[i];
		}
	}
	printf("\nTong cac phan tu le la: %d",tl);
	printf("\nTrung binh cong cac phan tu chan la: %d",tc/c);
}
void phan4(int n,Arr A)
{
	int S=0,d=0;
	for(int i=1;i<=n;i++)
	if(A[i]>=20&&A[i]<=200)
	{
		d++;
		S+=A[i];	
	}
	printf("\nTrung binh cong cac phan tu thuoc doan [] la: %d",S/d);
}
int main()
{
    Arr a,b;
	int n;
	nhap(&n,&a);
	phan1(n,a);
	phan2(n,a);
	phan3(n,a);
	phan4(n,a);
}

