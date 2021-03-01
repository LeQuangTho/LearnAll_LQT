#include<bits/stdc++.h>

using namespace std;
class hvl
{
	int d= 0;
	map<char,int> M;  // Ki tu va tan xuat
	void TRY(string x, int n)
	{
		if(x.length()==n) cout<<"\n"<<++d<<" :"<<x;
		else 
		{
			for(auto &t:M) 
			if(t.second >0)
			{
				t.second--;
				TRY(x+string(1,t.first),n);
				t.second++;
			}
		}
	}
	public: void sol()
	{
		string s;
		cin>>s;
		for(auto c:s) M[c]++;
		TRY("",s.length());
	}
};
int main()
{
	hvl H;
	H.sol();
}

