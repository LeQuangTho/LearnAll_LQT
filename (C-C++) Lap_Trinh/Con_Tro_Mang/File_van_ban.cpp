#include<bits/stdc++.h>
using namespace std;
/*void nhap(int &n,int *&a,FILE *f=stdin)
{
    fscanf(f,"%d",&n);
    a=new int[n];
    for(int i=1;i<=n;i++)
    {
        fscanf(f,"%d",&a[i]);
    }
}
void xuat(int n,int *a,FILE *f=stdout)    //ham co doi mac dinh (file *f=  )
{
    for(int i=1;i<=n;i++)
    {
        fprintf(f,"%5d",a[i]);
    }
}
int main()
{
    /*int n;
    fscanf(stdin,"%d",&n)   //= scanf
    fprintf(stdout,"gia tri cua n= )    //= printf
    int n,*a;
    nhap(n,a);
    xuat(n,a);
    delete []a;
}*/
void nhap(int &n,int *&a,FILE *f=stdin)
{
    fscanf(f,"%d",&n);
    a=new int[n];
    for(int i=1;i<=n;i++)
    {
        fscanf(f,"%d",&a[i]);
    }
}
void xuat(int n,int *a,FILE *f=stdout)    //ham co doi mac dinh (file *f=  )
{
    for(int i=1;i<=n;i++)
    {
        fprintf(f,"%5d",a[i]);
    }
}
int main()
{
    /*int n;
    fscanf(stdin,"%d",&n)   //= scanf
    fprintf(stdout,"gia tri cua n= )    //= printf*/
    int n,*a;
    FILE *f=fopen("input.txt","r");
    nhap(n,a,f);
    fclose(f);
    f=fopen("output.txt","wt");
    printf("\n Thong tin day so trong file \n"); 
	xuat(n,a,f);
    printf("da xong");
    delete []a;
}
