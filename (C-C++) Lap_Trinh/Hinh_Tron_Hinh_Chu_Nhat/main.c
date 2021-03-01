#include <stdio.h>
#include<math.h>
int n,x[10000],y[10000];
int main()
{
    scanf("%d",&n);
    for (int i=1;i<=n;i++) scanf("%d %d",&x,&y);
    double kc(double u,double v,double x,double y)
{
	return sqrt(pow(u-v,2)+pow(v-y,2));
}
double max=0;
  for(int i=1;i<=n;i++)
      if (max<kc(x[i],y[i],0,0)) max =kc(x[i],y[i],0,0);
            printf("%lf",M_PI*max*max);
    double maxx=minx=x[1];
    double maxy=miny=y[1];
    for(int i=1;i<=n;i++)
    {
    	 if (maxx<x[i]) maxx=x[i];
    	 if (minx>x[i]) minx=x[i];
    	 if (maxy<y[i]) maxy=y[i];
    	 if (minx<x[i]) minx=y[i];
	}
	printf("\n%lf",(maxx-minx)*(maxy-miny));

}
