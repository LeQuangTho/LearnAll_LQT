#include<bits/stdc++.h>

using namespace std;

template<class T>
void QuickSort(T *&a,int left,int right){
	if(left>=right) return;
	int i=left, j= right;
	int key=(i+j)/2;
	do{
		while(a[i]<a[key]) i++;
		while(a[j]>a[key]) j--;
		if(i<=j){
			swap(a[i],a[j]);
			i++;
			j--;
		}
	}while(i<j);
	QuickSort(a,left,j);
	QuickSort(a,i,right);
}
int main()
{
	int n,*a;
	cin>>n;
	a=new int[n+1];
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	QuickSort(a,0,n-1);
	for(int i=0;i<n;i++){
		cout<<" "<<a[i];
	}
}

