//viet theo if
#include <stdio.h>
#include <stdlib.h>
float x,y,n;
int main()
{
    scanf("%f%f",&x,&y);

    if (x==0)
    {
        if (y==0) printf ("Origem");
        else printf ("Eixo Y");
    }
    else
    {
        if (y==0) printf("Eixo X");
        else if (x>0&&y>0) printf("Q1");
        else if (x>0&&y<0) printf("Q4");
        else if (x<0&&y<0) printf("Q3");
        else if (x<0&&y>0) printf("Q2");
    }
    return 0;
}
