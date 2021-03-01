#include <stdio.h>
#include<string.h>
int n,i=1,j=1,k=1;
char a[10000],b[10000];
int main()
{
    scanf("%d",&n);
    fflush(stdin);
    for (i=1;i<=n;i++) scanf("%s",&a[i]);
    for ( i=j;i<=n;i+=j)
        for(j=i+1;j<=n;j++)
    {
        if (a[i]==a[j]) b[k]=a[i];
            else
            {
                printf("%s",b[k]);
                k++;
                break;
            }
    }
    return 0;
}
