#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n,x;
	int A[100005] = {INT_MIN}; // chua day tang
	cin>>n;
	for(int i= 1;i<n;i++)
	{
		cin>>x;
		if(A.back()<x) A.push_back(x);
		else{
		auto it = lower_bound()
		}
		cout<<A.size()-1;
	}
}

