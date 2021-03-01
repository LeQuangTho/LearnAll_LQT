#include<stdio.h>
#include<math.h>
#include<stdlib.h>
typedef struct{
	int d,m,y;
}ns;
typedef struct{
	char a[100];
	int L;
}nv;

int main()
{
    int n;
    char x[100];
    ns *p;
    nv *q;
    FILE *f;
    gets(x);
    f=fopen(x,"rt");
    fflush(stdin);
    fscanf(f,"%d",&n);
    p=(ns*)malloc((n)*sizeof(ns));
    q=(nv*)malloc((n)*sizeof(nv));
    for(int i=0;i<n;i++)
    {
    	fflush(stdin);
        fgets(q[i].a,100,f);
    	fflush(stdin);fscanf(f,"%d%d%d",&p[i].d,&p[i].m,&p[i].y);
    	fflush(stdin);fscanf(f,"%d",&q[i].L);
	}
	for(int i=0;i<=n;i++)
    {
        printf("\nHo va ten: %s\n",q[i].a);
        printf("sinh ngay %d thang %d nam %d\n",p[i].d,p[i].m,p[i].y);
        printf("%d",q[i].L);
	}
}
