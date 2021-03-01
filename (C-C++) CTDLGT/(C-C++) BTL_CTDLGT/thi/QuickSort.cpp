#include<bits/stdc++.h>

using namespace std;

template <class T>
void QuickSort(T *a, int left, int right){
	if(left>=right) return;
	int i=left, j=right;
	T key= a[(i+j)/2];
	do{
		while(a[i]<key) i++;
		while(a[j]>key) j--;
		if(i<=j){
			swap(a[i],a[j]);
			i++;
			j--;
		}
	}while(i<j);
	QuickSort(a,left,j);
	QuickSort(a,i,right);
}

void Merge(int *&a,int left,int middle ,int right){
	int i,j,k= left;
	int n1= middle-left+1, n2= right-middle;
	int *L= new int[n1];
	int *R= new int[n2];

	for(i = 0;i<n1;i++)
	{
		L[i]=a[left+i];
	}
	for(j = 0;j<n2;j++){
		R[j]= a[middle+j+1];
	}
	
	//tron
	i=0; j=0;
	while(i<n1 && j<n2){
		a[k++]= (L[i]<=R[j])?L[i++]:R[j++];
	}
	
	while(i<n1){
		a[k++]= L[i++];
	}
	
	while (j<n2){
		a[k++]= R[j++];
	} 
}

void MergeSort(int *&a,int left,int right){
//	if(left<right){
//		int middle= left+(right-left)/2;
//		MergeSort(a,left,middle);
//		MergeSort(a,middle+1,right);
//		Merge(a,left,middle,right);
//	}
if(left<right){
		int middle = left+(right-left)/2;
		MergeSort(a,left,middle);
		MergeSort(a,middle+1,right);
		Merge(a,left,middle,right);
	}
}

void builhead(int *&a, int n, int i){
	int cha=i;  // bien nay de xem ve cuoi co thay doi ko
	int left=2*i+1, right= 2*i+2;  //tinh theo do cao cua cay
	 
	if(left<n && a[left]>a[cha]){
		cha= left;
	}
	
	if(right<n && a[right]>a[cha]){
		cha= right;
    }
    
	if (cha!=i){
		swap(a[cha],a[i]);
		builhead(a,n,cha);
	}
}

void HeapSort(int *&a,int n){
	int i;
	for(i=n/2-1;i>=0;i--){
		builhead(a,n,i);
	}
	for(i=n;i>=0;i--){
		swap(a[i],a[0]);
		builhead(a,n,0);
	}
}
int main()
{
	int *a,*b,n,m;
//	cin>>n;
//	a=new int[n+1];
//	for(int i=1;i<=n;i++){
//		cin>>a[i];
//	}
//	QuickSort(a,1,n);
//	for(int i=1;i<=n;i++){
//		cout<<" "<<a[i];
//	}
//	
	cin>>m;
	b=new int[m+1];
	for(int i=0;i<m;i++){
		cin>>b[i];
	}
	
	MergeSort(b,0,m);
	for(int i=0;i<m;i++){
		cout<<" "<<b[i];
	}
//	
//	HeapSort(b,m+1);
//	for(int i=0;i<m;i++){
//		cout<<" "<<b[i];
//	}
	delete[] a;
	delete[] b;
}

