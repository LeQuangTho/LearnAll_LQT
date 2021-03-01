#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int a,b,c;
int main()
{
    scanf("%i%i%i", &a,&b,&c);
       if ((a-b)*(a-c)<0) printf("%i", a);
  else if ((b-a)*(b-c)<0) printf("%i", b);
  else if ((c-a)*(c-b)<0) printf("%i", c);
  else printf("KHONG CO SO O GIUA");
    return 0;
}
