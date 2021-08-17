#include <bits/stdc++.h>
using namespace std;
//sai
map<int, long long> D;
long long mode = 1e9+7;
long long zero(int n) {
	if (D.find(n) != D.end()) return D[n];
	if (n == 0) return D[n] = 1;
	D[n] = 0;
	for(int a = 1; a * a <= n; a++) {
		if(n%a == 0) {
			D[n] = (D[n] + zero((a - 1) * (n / a+1))) % mode;
		}
	}
	return D[n];
}
int main()
{
	int t, n;
	cin >> t;
	while(t--) {
		cin >> n;
		cout << zero(n) << "\n";
	}
}

