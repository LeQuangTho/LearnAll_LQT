#include<stdio.h>
#include<math.h>
#include<string.h>
int main()
{
    int c[100],b,a;
    scanf("%i",&a);
    for(int i=0;i<=9;i++)
    {
        c[9-i]=a%10;
        a=(a-c[9-1])/10;
    }
    for(int i=0;i<=9;i++)
    {
        printf("%i",c[i]);
    }
}
