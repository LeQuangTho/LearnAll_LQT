#include <stdio.h>
#include <stdlib.h>

int main()
{
    float a , b;
    do
    {
        printf("nhap a : ");
        scanf("%f",&a);
    }
    while ( a < 0 || a > 10);
    do
    {
        printf("nhap b : ");
        scanf("%f",&b);
    }
    while ( b < 0 || b > 10);
    printf("%f",(a+b)/2);
}
