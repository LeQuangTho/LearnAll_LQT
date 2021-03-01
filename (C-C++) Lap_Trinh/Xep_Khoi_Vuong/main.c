#include <stdio.h>
#include <stdlib.h>
int n,i,p;
int main()
{
    scanf("%i",&n);
     if (n!=1)
    {
          for (i = 0 ; i <= n/2 ; i++)
      {
        if (i*i<=n) p=i;
      }
       printf("%i",p);
    }
    else printf("1");
    return 0;
}
