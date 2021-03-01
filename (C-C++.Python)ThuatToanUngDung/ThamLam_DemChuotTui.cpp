#include<bits/stdc++.h>

using namespace std;

bool check(long long a, long long b){
	if(b*2<=a) return true;
	return false;
}

int main()
{
	long long n,ok = 0;
	cin>> n;
	long long a[n+2];
	
	for(long long i = 1; i<=n; i++){
		cin>>a[i];
	}
	
	sort(a+1,a+n+1,greater<long long>());
	
	for(long long i = 1; i<= n; i++){
		for(long long j = n/2 +1; j <= n; j++){
			if(a[i] != -1 && a[j]!= -1)
			if(check(a[i],a[j])){
				a[i] = -1;
				a[j] = -1;
				ok++;
				break;
			}
		}
	}
	for(int i = 1; i<= n; i++)
	{
		if(a[i] != -1) ok++; 
	}
	cout<<ok;
}
