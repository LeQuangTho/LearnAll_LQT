#include<bits/stdc++.h>

using namespace std;

int main()
{
	int a,b;
	cin>>a>>b;
	for(int i = 1; i<=b;i++)
	{
		if(a+1 == 24) a = 0;
		else a+=1;
	}
	cout<<a;
}

