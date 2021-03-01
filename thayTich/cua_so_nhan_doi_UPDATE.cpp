#include<bits/stdc++.h>

using namespace std;

typedef pair<string, int> spair;   // pair <fisrt, second>

int main()
{
		queue<spair> Q;  // khai bao cap doi
		Q.push({"dong",1});
		Q.push({"Tay",1});
		Q.push({"nam",1});
		Q.push({"bac",1});
		Q.push({"trung",1});
		int n;
		cout<<"Nhap n: "; cin>>n;
		
	while(1){
		if(n<= Q.front().second) { 
			cout<<Q.front().first;  
			break;
			}
			n-= Q.front().second;
			Q.push({Q.front().first,Q.front().second*2});
			Q.pop();

	}
}

