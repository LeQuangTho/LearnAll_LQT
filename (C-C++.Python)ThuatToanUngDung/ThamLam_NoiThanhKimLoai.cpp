#include<bits/stdc++.h>

using namespace std;

int main()
{
	priority_queue<int,vector<int>,greater<int>> Q;
	int u,res = 0;
	for(int x:{4,7,2,8,1,6}) Q.push(x);
	while(Q.size())
	{
//		cout<<Q.top()<<" ";
//		Q.pop();
		u = Q.top(); Q.pop();
		u += Q.top();Q.pop();
		res+=u;
		Q.push(u);
	}
	cout<<res;
}

