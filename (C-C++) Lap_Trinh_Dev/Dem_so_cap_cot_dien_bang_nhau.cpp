#include<bits/stdc++.h>

using namespace std;

int main()
{
	long long n,f;
	cin>>n;
	map<long,long> a;
	map<long,long>::iterator it;
//	7 4 2 8 6 4 2 4
//	a.insert({7,1});
//	a.insert({4,3});
//	a.insert({2,2});
//	a.insert({8,1});
//	a.insert({6,1});

//	it = a.find(6);

//	cout<<it->second;
//	it->second ++;
//	cout<<it->second;
	for(long long i = 1; i <= n; i++)
	{
		cin>>f;
		it = a.find(f);
		if(it->second == 0) a[f] = 1;
		else it->second++;
	}
	long long tong = 0;
	for(it = a.begin();it != a.end(); it++)
	{
//		cout<<it->second;
		tong += (it->second * (it->second - 1));
	}

	cout<<tong/2;
}
