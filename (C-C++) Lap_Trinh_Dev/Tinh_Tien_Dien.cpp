#include <bits/stdc++.h>
using namespace std;
int main()
{
	double n,s;
   cin>>n;
   if (n>=0&&n<=100) s+=n*1.0;
   else if (n>100&& n<=250) s+=(100.0*1.0)+(n-100)*1.2;
   else if (n>250&& n<=500) s+=(100.0*1.0)+150*1.2+(n-250)*1.7;
   else if (n>=500) s+=100.0*1.0+150*1.2+250*1.7+(n-500)*2.2;
   printf("%.3lf",s);
   return 0;
}


