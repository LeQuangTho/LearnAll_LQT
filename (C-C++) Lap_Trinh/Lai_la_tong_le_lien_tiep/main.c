#include<stdio.h>
int main()
{
    double a,thue=0;
    scanf("%ld",&a);
    if(a<=2000.0) printf("Isento");
    else if(a>2000.0&&a<=3000.0) printf("R$ %.2ld",(a-2000)*0.08);
}
