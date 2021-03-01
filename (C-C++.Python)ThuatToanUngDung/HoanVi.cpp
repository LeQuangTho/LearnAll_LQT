#include<bits/stdc++.h>

using namespace std;

class hv 
{
	int n, x[100],d[100] ={};
	void TRY(int k)
	{
		if(k == n){
			for(int i= 1; i<=n;i++) cout<< x[i]<<" "; cout<<"\n"; return;
		}
		for(int t = 1; t<=n; t++)
		if(d[t]==0){
			x[k+1] = t;
			d[t] = 1;
			TRY(k+1);
			d[t]=0;
		}
	}
	
	public: void sol()
	{
		cin>>n;
		TRY(0);
	 } 
};
int main()
{
	hv H;
	H.sol();	
}

