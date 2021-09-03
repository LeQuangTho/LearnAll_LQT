#include <bits/stdc++.h>
using namespace std;
int const k = 1e4;
void gt (int n, list<int> &res)
{
	if (n==0) {
		res.push_back(1);
		return;
	}
	gt(n-1, res);
	long long m = 0;
	for(auto it=res.rbegin(); it!=res.rend(); it++) {
		m += *it*n;
		*it=m%k;
		m/=k;
	}
	while(n) {
		res.push_front(m%10);
		m/=1000;		 
	}
	 
}
int main()
{	
	list<int> L;
	gt(5, L);
	cout<<L.front();
	L.pop_front();
	for(int x:L) cout<<x;
}
