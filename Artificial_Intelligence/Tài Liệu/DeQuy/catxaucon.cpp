#include <bits/stdc++.h>
using namespace std;

map<string, bool> M;
void lietke(string x) {
	if(M[x]) return;
	M[x] = true;
	if(x.size()>1){
		lietke(x.substr(0, x.size()-1));
		lietke(x.substr(1, x.size()));
	}
}
int main()
{	
	string x= "abcd";
	lietke(x);
	for(auto x:M) cout<<x.first<<endl;
}
