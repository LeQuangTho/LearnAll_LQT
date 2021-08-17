//De quy theo chieu sau
//Disjoin set: Tap diem roi nhau
#include <bits/stdc++.h>
//sai
using namespace std;
struct graph {
	int n, m, R[99] = {}, N[99];
	void nhap() {
		cin>>n>>m;
		fill(N, n+n+1, 1);
		for(int i=1; i<=m;i++) {
			int u,v;
			cin>>u>>v;
			int x=goc(u), y = goc(v);
			if(x!=y) {
				N[x] += N[y];
				R[y] = x;
			}
		}
		long long res = 1;
		for(int i=1;i<=n; i++) {
			if(R[i] ==0) res*=1<<R[i]+1;
 		}
	}
	int goc(int x) {
		return R[x]==0?x:goc(R[x]);	
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

