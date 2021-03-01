#include<bits/stdc++.h>

using namespace std;

int main()
{
	string n,a,b,c;
	getline(cin,n);
	a = n.substr(0,5);
	b = n.substr(6,7);
	c = n.substr(14);
	cout<<a<<" "<<b<<" "<<c;
}

