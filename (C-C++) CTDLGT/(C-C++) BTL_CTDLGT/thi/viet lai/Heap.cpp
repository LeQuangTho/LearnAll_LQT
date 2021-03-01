#include<bits/stdc++.h>

using namespace std;

void buidheap(int *&a,int n,int i){
	int cha= i;
	int left= 2*i+1;
	int right =2*i+2;
	if(left<n && a[left]> a[cha]){
		cha = left;
	}
	
	if(right<n && a[right]> a[cha]){
		cha = right;
	}
	
	if(cha!=i){
		swap(a[cha],a[i]);
		buidheap(a,n,cha);
	}
}

void HeapSort(int *&a,int n){
	//int i;
	for(int i=n/2-1;i>=0;i--){
		buidheap(a,n,i);
	}
	for(int i=n;i>=0;i--){
		swap(a[0],a[i]);
		buidheap(a,i,0);
	}
}
int main()
{
	int m,*b;
	cin>>m;
	b=new int[m+1];
	for(int i=0;i<m;i++){
		cin>>b[i];
	}
	
	HeapSort(b,m+1);
	for(int i=0;i<m;i++){
		cout<<" "<<b[i];
	}
}

