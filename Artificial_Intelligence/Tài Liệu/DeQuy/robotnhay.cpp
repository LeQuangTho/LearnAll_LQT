#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;

map<pii, bool> D;
void robot (pii p) {
	if(D[p]) return;
	D[p] = 1;
	if(p.first%2 == 0) robot({p.second, p.first/2});
	if(p.second%2) robot({p.second/2+1, p.first});
} 
int main()
{
	int x,y;
	cin >>x>>y;
	robot({x,y});
	cout<<D.size();
}

