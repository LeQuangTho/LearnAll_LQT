#include<bits/stdc++.h>

/*
8
10 12 8 16 20 5 7 15
4 7 2 8 4 1 6 3
4 13 4 17 8 3 19 7

*/
using namespace std;

typedef long long LL;

int main()
{
	int n;
	priority_queue<LL, vector<LL>, greater<LL>> Q;
	LL t[100002],v[100002];
	cin>>n;
	for(int i = 1; i<=n;i++) cin>>v[i];
	for(int i = 1; i<=n;i++) cin>>t[i];
	LL z = 0;	// moc
	for(int i = 1; i<=n;i++){
		Q.push(v[i]+z);
		LL s = 0;
		while(Q.size() && Q.top()-z<=t[i]){
	 		s+= Q.top() - z; Q.pop();
		}
		z+=t[i];
		s+= Q.size()*t[i];
		if(Q.empty()) z=0;
		cout<<s<<" ";
	}
}

