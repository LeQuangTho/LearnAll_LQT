#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n, lai=0;
	cin>>n;
	int a[n+1];
	int b[n+1];
	for(int i = 1; i<=n; i++)
	{
		cin>>a[i];
		b[i] = i;
	}
	
	for(int i = 1; i<n; i++)
	{
		for(int j = i+1; j<=n;j++)
		{
			if(a[i]>a[j])
			{
				swap(a[i],a[j]);
				swap(b[i],b[j]);
			}
		}
	}
	
	for(int j = 1; j<=n;j++)
	{
		cout<<b[j]<<" ";	
	}
}

