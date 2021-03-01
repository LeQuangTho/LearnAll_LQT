#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n,a[100000],m = 1 ,r = 0;
	cin>>n;
	a[0] = 1;
	for(int i = 2; i <= n; i++)
	{
		for(int j=0;j<m;j++)
		{
            int s = a[j]*i+r;
                a[j]=s%10;
                r=s/10; 
		}
                
			while(r>0){
            	a[m]=r%10;
             	m++;
             	r/=10;  
				}
	}
	for(int j = m-1; j>=0 ; j--)
		{
			cout<<a[j];
		}
}

