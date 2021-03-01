#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n; 
	cin >>n;
	for(int i= 1;i<20;i++){
		if(n%2==0){
		n/=2;
		cout<<n<<"\n";
		}
		else{
		n/=2;
		cout<<n<<" "<<"+1\n";
			}
		}
}

