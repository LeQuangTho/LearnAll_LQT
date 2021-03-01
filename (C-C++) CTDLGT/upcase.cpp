#include<bits/stdc++.h>

using namespace std;
int  maxmin(int a, int b,int c, bool ismax=true)
{
	if(ismax==true) 
	{
		int max;
		max=a>=b?a:b>=c?b:c;
		return max;
	}	
	else
		{
			int min;
			min=a<=b?a:b<=c?b:c;
		}
} 
int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<(a+b+c)-maxmin(a,b,c)-maxmin(a,b,c,false);	
}

