#include <stdio.h>
#include <stdlib.h>
int a,b,c;
int max, max1;
int main()
{
    scanf("%i%i%i", &a, &b, &c);
        max1 = a>b?a:b;
        max = max1> c? max1:c;
    printf("Max = %i", max);
    return 0;
}
