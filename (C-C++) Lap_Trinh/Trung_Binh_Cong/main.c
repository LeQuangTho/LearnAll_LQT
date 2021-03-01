#include <stdio.h>
#include<math.h>
int main()
{
    int n,m[2500],s=0,dem=0,so=0,tb=0;
    scanf("%i",&n);
    for (int i = 1; i <= n; i++)
        {
            scanf("%i",&m[i]);
        }
    for (int i = 1; i<=n; i++)
    {
        s+=m[i];
        dem++;
    }
    tb=s/dem;
    for (int i = 1;i<=n; i++)
        {
           if (m[i]<tb) so++;
        }
    printf("%i %i",tb,so);
    return 0;
}
