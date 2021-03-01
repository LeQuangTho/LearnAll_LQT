#include <stdio.h>
#include <stdlib.h>
int a[2000],n,b=0,c=0,le=0,chan=0;
int main()
{
    scanf("%i",&n);
    for (int i=1;i<=n;i++)
    {
        scanf("%i",&a[i]);
    }
    for (int i=1;i<=n;i++)
    {
        if (a[i]%2==0)
        {
            chan=chan+a[i];
            b++;
        }
        else
        {
            le=le+a[i];
            c++;
        }
    }
    if(c == 0)
   		printf("0\n");
	else
    	printf("%d\n",le/c);

    if(b == 0)
		printf("0");
	else
    	printf("%d",chan/b);

    return 0;
}

