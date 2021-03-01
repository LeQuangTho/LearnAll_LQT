#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int d;
int main()
{
    scanf("%i",&d);
    if (d==11) printf("Sao Paulo");
    else if (d==19) printf("Campinas");
    else if (d==21) printf("Rio de Janeiro");
    else if (d==27) printf("Vitoria");
    else if (d==31) printf("Belo Horizonte");
    else if (d==32) printf("Juiz de Fora");
    else if (d==61) printf("Brasilia");
    else if (d==71) printf("Salvador");
    else printf ("DDD not found");
    return 0;
}
