#include<bits/stdc++.h>

using namespace std;

int main()
{
	long long n,k, res= 0;
	cin>>n>>k;
	priority_queue<long long> Q;
	if(n<k){
		for(long long i = 0; i<n;i++){
			int a;
			cin>>a;
		res += a;
		}
	}else{
	
	for(long long i = 0;i<n;i++){
		long long a;
		cin>>a;
		Q.push(a);
	}
	
	for(long long i = 0; i<k;i++){
		res += Q.top(); Q.pop();
	}
	}
	cout<<res;
}

