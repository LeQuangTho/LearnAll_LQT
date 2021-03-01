#include<stdio.h>
void ghi(int *a,int *m,int *n)
{
	FILE *f;
	char x[100];
	gets(x);
	f=fopen(x,"rt");
	fscanf(f,"%d%d",m,n);
	for (int i=1;i<=*n;i++)
    for (int j=1;j<=*m;j++)
    fscanf(f,"%d",a+100*i+j);
}
int main()
{
    int a[100][100],m,n;
    ghi(*a,&m,&n);
    for (int i=1;i<=n;i++){
	
    for (int j=1;j<=m;j++)
    {
    	printf("%d",a[i][j]);
	}
	   printf("\n");
	}
}

