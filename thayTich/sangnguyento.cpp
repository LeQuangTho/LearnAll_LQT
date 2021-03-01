#include<bits/stdc++.h>

using namespace std;
void sang(int n, vector<int> &P)
{
	bool s[n+5] = {};
	fill(s+2,s+n+1,true);
	for (int i=2;i<=n;i++)
	if(s[i]){
	P.push_back(i);
	for(int j = i*i;j<= n;j+=i) s[j] = 0;
	} 
}
int main()
{
	int n;
	vector<int> P;
	cin>>n;
	sang(n,P);
	for(int x:P) cout<<x<<" ";

}

