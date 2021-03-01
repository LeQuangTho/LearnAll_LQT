#include<stdio.h>
#include<math.h>
#include<string.h>
typedef struct{
    char ten[100];
    int a,b,c,d,e;
}thi;
int tinh(char a1[],int t,int i)
{
     if(a1[i]=='A') return t=1;
   else if(a1[i]=='B') return t=2;
   else if(a1[i]=='C') return t=3;
   else if(a1[i]=='D') return t=4;
   else if(a1[i]=='E'&&a1[i+1]!='N')  return t=5;
   else  return t=0;
}
int main()
{
   int n,t;
   char a1[100],a2[100];
   thi thi[1000];
   scanf("%i",&n);
   fflush(stdin); scanf("%[^\n]s",a1);
   thi[0].a=tinh(a1[0],t,0);
   printf("%i",thi[0].a);
}
