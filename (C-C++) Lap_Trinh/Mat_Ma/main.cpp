#include<stdio.h>
#include<string.h>
int main()
{
    int n,a;
    char x[10000];
    scanf("%d",&n);
    fflush(stdin);
    scanf("%[^\n]s",x);
    a=strlen(x);
    for(int i=0;i<a;i++)
        if ('Z'<x[i]+n) x[i]=x[i]-26+n;
        else x[i]+=n;
    printf("%i\n",n);
    printf("%s",x);
}
