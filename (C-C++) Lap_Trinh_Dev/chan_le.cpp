#include<bits/stdc++.h>

using namespace std;
bool chan_le(int a)
{
	if(a%2 == 0) return true;
	else return false;
}
int main()
{
	int n;
	cin>>n;
	int a[n+1];
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
	}
	for(int i=1;i<=n;i++)
	{
		if(a[i] == 0) cout<<"NULL\n";
		else if(a[i]>0 && chan_le(a[i]) == true) cout<<"EVEN POSITIVE\n";
		else if(a[i]>0 && chan_le(a[i]) == false) cout<<"ODD POSITIVE\n";
		else if(a[i]<0 && chan_le(a[i]) == true) cout<<"EVEN NEGATIVE\n";
		else if(a[i]<0 && chan_le(a[i]) == false) cout<<"ODD NEGATIVE\n";
	}
}

