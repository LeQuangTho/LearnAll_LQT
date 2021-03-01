#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int i,a,b;
int main()
{
    b=0;
    scanf("%i",&a);
    if (a<2) printf("NO");
    else if (a==2) printf("YES");
      else
      {
        for (i=2;i<=(a-1);i++)
            {
                if (a%i==0) b=b+1;
            }
            if (b==0) printf("YES");
                else printf("NO");
      }
    return 0;
}
