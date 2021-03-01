#include<bits/stdc++.h>

using namespace std;

void Merge(int *&a,int left, int middle, int right){
	int i,j,k=left;
	int n1=middle-left+1, n2=right-middle;
	int *L=new int[n1], *R=new int[n2];
	for(i=0;i<n1;i++){
		L[i]=a[left+i];
	}
	for(j=0;j<n2;j++){
		R[j]=a[middle+j+1];
	}
	i=0;j=0;
	while(i<n1 && j<n2){
		a[k++]=(L[i]<=R[j])?L[i++]:R[j++];
	}
	
	while(i<n1){
		a[k++]=L[i++];
	}
	
	while(j<n2){
		a[k++]=R[j++];
	}
	
}

void MergeSort(int *&a,int left, int right){
	if(left<right){
		int middle = left + (right-left)/2;
		MergeSort(a,left,middle);
		MergeSort(a,middle+1,right);
		Merge(a,left,middle,right);
	}
}

int main()
{
	int *a,n;
	cin>>n;
	a=new int[n+1];
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	MergeSort(a,0,n);
	for(int i=0;i<n;i++){
		cout<<" "<<a[i];
	}
	delete[] a;
}

