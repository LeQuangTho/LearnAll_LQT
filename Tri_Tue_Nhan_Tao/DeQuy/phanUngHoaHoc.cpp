//De quy theo chieu sau
#include <bits/stdc++.h>
//sai
using namespace std;
struct graph {
	int n, m, d[99] = {};
	vector<int> A[55];
	void nhap() {
		cin>>n>>m;
		for(int i=1; i<=m;i++) {
			int u,v;
			cin>>u>>v;
			A[u].push_back(v);
			A[v].push_back(u);
		}
	}
	
	long long DFS(int s) {
		d[s] = true;
		long long k=1;
		for(int x:A[s]){
			if(d[x] == 0) {
				k+=DFS(x);
			}
		}
		return k;
	}
	
	void sol() {
		nhap();
		long long res = 1;
		for(int i=1;i<=n; i++) {
			if(d[i]==0) res*=1<<(DFS(i)-1);
		}
		cout<<res;
	}
};
int main()
{
	graph d;
	d.sol();
}

