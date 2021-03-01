#include<bits/stdc++.h>
#include"BillCayHeap.cpp"
using namespace std;

int main()
{
	heap<int> H;
	for(auto x:{234,234,34,1231,736,11}) H.push(x);
	while(H.size()) {
		cout<<H.top()<<" "; H.pop();
	}
}

