#include<bits/stdc++.h>

using namespace std;

int main()
{
	//unordered_map<char, int> M;   //Bang bam
	map<char, int> M;	// cay do den
	string x;
	cin>>x;
	for(char c:x) M[c]++;
	for(auto z:M) cout<<"\nKy tu "<< z.first<<" tanxuat "<<z.second;
}

