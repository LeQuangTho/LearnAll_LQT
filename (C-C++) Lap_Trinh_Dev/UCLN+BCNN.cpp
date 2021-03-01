#include<bits/stdc++.h>

using namespace std;
int UCLN(int a, int b)
{
	if(a*b == 0) return a + b;
	if (a > b)
	{
        a %= b;
        return UCLN(a,b);	    
    }
    b %= a;
    return UCLN(a,b);  
}

int BCNN(int a,int b,int u)
{
	return a*b/u;
}

int main()
{
	int a,b,U;
	do
	{	
		cin>>a>>b;
		U = UCLN(a,b);
		cout<<U<<" "<<BCNN(a,b,U)<<"\n";
	}while(a!=0 && b!=0);
}
