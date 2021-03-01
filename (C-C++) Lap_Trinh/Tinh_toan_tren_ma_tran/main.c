#include <stdio.h>
int a,b,max[200],m[200][200];
int main()
{
    scanf("%i %i",&a,&b);
    for (int i=1;i<=a;i++)
        for(int j=1;j<=b;j++) scanf("%d",&m[i][j]);
    for (int i=1;i<=a;i++)
        {
            int S=0;
            for(int j=1;j<=b;j++)
            {
              S+=m[i][j];
            }
            printf("%i ",S);
        }
        printf("\n");
    for (int i=1;i<=b;i++)
        {
            max[i]=m[1][i];
            for(int j=1;j<=a;j++)
            {
              if (max[i]<m[j][i]) max[i]=m[j][i];
            }
            printf("%i ",max[i]);
        }
        double S=0,d=0;
    for (int i=2 ;i<=a; i+=2)
        for (int j=1; j<=b;j+=2)
        {
            if (m[i][j]%3==0)
            {
            S+=m[i][j];
            d++;
            }
        }
    if (d==0) printf("\nkhong co so thoa man");
    else printf("\n%.3lf",S/d);
    return 0;
}
