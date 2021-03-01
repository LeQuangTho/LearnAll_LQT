#include <stdio.h>
#include <stdlib.h>

int main()
{
   int n,t;
   scanf("%i",&n);
   for(int i=1; i<=n;i++)
   {
        int j=0,k=1,d=0;
        scanf("%i",&t);
        if (t==2)  printf("Fib(%i) = 1\n",t);
        else
        {
            while (j<t||k<t)
        {
            j=j+k;
            k=k+j;
            d++;
        }
        printf("Fib(%i) = %i\n",t,d);
        }
   }
}
