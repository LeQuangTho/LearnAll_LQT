#include <stdio.h>
#include <stdlib.h>
int X,Y,i,B;
float p;
int main()
{
    B=0;
    scanf("%i%i",&X,&Y);
    if (X<Y)
     {
         for (i=X;i<=Y;i++)
        {
            p=i%13;
            if (p!=0) B=B+i;
        }
        printf("%i",B);
     }
    else
        {
         for (i=Y;i<=X;i++)
        {
            p=i%13;
            if (p!=0) B=B+i;
        }
        printf("%i",B);
     }
    return 0;
}
