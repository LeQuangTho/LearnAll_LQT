#include<bits/stdc++.h>
#include<queue>

using namespace std;
// doi voi bai toan co N lon thi dung Queu chua gia tri va tan xuat xuat hien 

int main()
{
	queue<string> Q;
	Q.push("dong");
	Q.push("Tay");
	Q.push("nam");
	Q.push("bac");
	Q.push("trung");
	int n;
	cout<<"Nhap n: "; cin>>n;
	for(int i=1;i<=n;i++){
		Q.push(Q.front());
		Q.push(Q.front());
		Q.pop();
	}
	
	cout<< Q.front();
}

