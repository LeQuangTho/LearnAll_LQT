#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, long long> D;
long long C(int k, int n) {
	if(D.find({k, n})!=D.end()) return D[{k,n}];
	if(k==0 || k==n) {
		D[{k,n}] = 1;
	}
	return D[{k,n}] = C(k-1, n-1)+C(k, n-1);
}
int main()
{
	cout<<C(4, 6);
}

