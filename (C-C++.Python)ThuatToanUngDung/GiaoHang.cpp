#include<bits/stdc++.h>
#include"BillCayHeap.cpp"

using namespace std;

int main()
{
	int n;
	vector<int> *a;
	a = new vector<int>[1000002];
	cin>>n;
	for(int i = 1; i<=n; i++){
		int x,y;
		cin>>x>>y;
		a[x].push_back(y);
	}	
	for(int i = 1; i<=n; i++){
		int j =0;
		while(a[i].size())
		cout<<a[i][j++]<<" ";
		cout<<"\n";
	}	
}

