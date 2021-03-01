#include <stdio.h>
char M[][10]={"Origem","Eixo X","Eixo Y","Q1","Q2","Q3","Q4"};
float x,y;
int t;
int main()
{
    scanf("%f%f",&x,&y);
    if (x==0) t=y==0?0:2;
       else if (y==0) t=1;
       else
       {
            if (x>0) t= y>0?3:6;
            else if (x<0) t= y<0?5:4;
       }
       printf("%s",M[t]);
  return 0;
}
