#include <bits/stdc++.h>
using namespace std;
int main()
{
	int n,k=2;
	scanf("%i",&n);
	while(n!=1)
	{
		int d=0;
		while(n%k==0)
		{
			n/=k;
			d++;
		}
		if (d!=0)
		printf("%i %i\n",k,d);
		k++;
	}
}

