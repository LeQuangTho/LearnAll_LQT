#include<stdio.h>
#include<math.h>

int main()
{
  int x,y,s=0;
  scanf("%d%d",&x,&y);
  if(fabs(x)<1000 && fabs(y)<1000)
  for (int i=x;i<=y;i++)
    {
     if(i%13!=0) s+=i;
    }
  printf("%d",s);
  return 0;
}
