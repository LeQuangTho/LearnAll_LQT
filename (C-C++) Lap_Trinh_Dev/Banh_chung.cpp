#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n,f;
	cin>>n;
	int a[5] = {0,0,0,0,0};
	map<int,int>::iterator it;
	for(int i = 1; i <= n; i++)
	{
		cin>>f;
		if(f == 1) a[1]++;
		else if(f == 2) a[2]++;
		else if(f == 3) a[3]++;
		else a[4]++;
	}
	int tong = 0;
	tong += a[4];
	if(a[3] == a[1]) 
	{
		tong = tong + a[3];
		tong = tong + a[2]/2;
		tong = tong + a[2]%2;
	}
	else if(a[3] > a[1]) 
	{
		tong = tong + a[1];
		a[3] -= a[1];
		tong += a[3];
		tong = tong + a[2]/2;
		tong = tong + a[2]%2;
	}
	else
	{
		tong += a[3];
		a[1] -= a[3];
		if(a[1]/2 < a[2])  
		{
			if(a[1]%2!=0)
			{
				tong = tong + 1 + a[1]/2;
				a[2] = a[2] - 1 - a[1]/2;
				tong += a[2]/2;
				tong += a[2]%2;
			}
			else 
			{
				tong = tong + a[1]/2;
				a[2] = a[2] - a[1]/2;
				tong += a[2]/2;
				tong += a[2]%2;
			}
		}
		else 
		{
			tong = tong + a[2];
			a[1] = a[1] - a[2]*2;
			if(a[1]>4)
			{
				tong = tong + a[1]/4;
				tong = tong + a[1]%4;
			}else tong++;
		}
	}
//	for(int i = 1; i <=n; i++)
//	{
//		cout<<"["<<i<<","<<a[i]<<"]";
//	}
	cout<<tong;
}

