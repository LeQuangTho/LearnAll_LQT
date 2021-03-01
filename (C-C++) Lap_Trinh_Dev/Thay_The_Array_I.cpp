#include<bits/stdc++.h>

using namespace std;

int main()
{
	int a[15];
	for(int i = 1; i<=10; i++) cin>>a[i];
	for(int i = 1; i<=10; i++) 
		if(a[i]<=0) a[i] = 1;
	for(int i = 1; i<=10; i++)
	{
		cout<<"X["<<i-1<<"] = "<<a[i]<<"\n";
	}
}

