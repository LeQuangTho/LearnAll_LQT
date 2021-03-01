#include<bits/stdc++.h>
using namespace std;
double bip(double x)
{
	return 1+x+x*x+x*x*x+x*x*x*x+x*x*x*x*x;  //hoac viet 1+x+pow(x,2)+pow(x,3)+pow(x,4)+pow(x,5)
}
int main()
{
	double a,b,c,d;
	printf("Nhap 4 so thuc a b c d !");
	scanf("%lf%lf%lf%lf",&a,&b,&c,&d);
	printf("ket qua F(a)+F(b)+F(c)+F(d) = %.5lf",bip(a)+bip(b)+bip(c)+bip(d));	
}
#include<bits/stdc++.h>
using namespace std;
double gta(double x)
{
	if(x>100) return x*sin(x+2)+5;
	else return sqrt(2*fabs(x)+3);
}
double gtf(double m,double n)
{
	return fabs(gta(m)-sqrt(17)) * (gta(m)+ log10(fabs(gta(m) + 25))+n);
}
int main()
{
	double m,n;
	printf("Nhap 2 so thuc m n !");
	scanf("%lf%lf",&m,&n);
	printf("ket qua F(m,n) = %.5lf",gtf(m,n));	
}
