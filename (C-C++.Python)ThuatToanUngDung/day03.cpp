/*******************************bài trinh thám 
tool --> compiler option --> --std=c++11	

#include<bits/stdc++.h>

using namespace std;

int main()
{
	priority_queue<int> Q;    // hàng <<
	for(int x:{3,7,2,1}) Q.push(x);
	while (Q.size()){
		cout<<Q.top()<<"\t";
		Q.pop();
		}
}
*/




//**************************************** Noi thah kim loai
/*
#include<bits/stdc++.h>

using namespace std;

int main()
{
	priority_queue<int,vector<int>,greater<int>> Q;  // hàng >>
//	for(int x:{3,7,2,1}) Q.push(x);
//	while (Q.size()){
//		cout<<Q.top()<<"\t";
//		Q.pop();
//		}
	int n,x;
	cin>>n;
	while(n--){ cin>>x; Q.push(x);}
	
	long long res = 0;
	while(Q.size()>= 2)
	{
		int u = Q.top(); Q.pop();
		u += Q.top(); Q.pop();
		res+=u;
		Q.push(u);
	}
	cout<<res;
}
*/







/****************************  bài toán trinh thám                  */
/*
#include<bits/stdc++.h>

using namespace std;

int main()
{
		priority_queue<pair<int,int>> Q;
		int n,k,a[100005];
		cin>>n>>k;
		for(int i = 1; i<= n ; i++) cin>>a[i];
		for(int i = 1; i<= k ; i++) Q.push({a[i],i});
		for(int i=k; i<=n ; i++)
		{
			Q.push({a[i],i});
			while(i-Q.top().second + 1 > k) Q.pop();
			cout<<Q.top().first<<" ";
		}
}
*/





//-------------------------------- Cách hai bài toán trinh thám
#define giatri first
#define vitri second
#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n,k,a[100005];
	deque<int> Q;
    cin>>n>>k;
	for(int i=1;i<=n;i++) cin>>a[i];
	for(int i=1;i<k;i++) 
	{
		while(Q.size() && a[Q.back()]<=a[i])  Q.pop_back();
		Q.push_back(i);
	}
	for(int i=k;i<=n;i++)
	{
		while(Q.size()&&a[Q.back()]<=a[i])  Q.pop_back();
		Q.push_back(i);
		while(i-Q.front()>=k) Q.pop_front();
		cout<<a[Q.front()]<<" " ;
	}
}




