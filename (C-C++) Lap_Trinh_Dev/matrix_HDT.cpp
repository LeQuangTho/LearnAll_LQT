#include<bits/stdc++.h>

using namespace std;

class matrix{
	int n,**a;
	public:
//		matrix(){
//		    a = new int*[n];
//			    for(int i = 0; i < n; i++)
//			        a[i] = new int[n]; 
//		}
//		~matrix();
		void nhap();
		void xuat();
		int tong();
		int chanmin();
};
//matrix::~matrix(){
//	for(int i = 0; i < 10; i++)
//    {
//        delete[] a[i];
//    }

 //   delete[] a;
//}

void matrix::nhap(){
	cout<<"\n Nhap cap cua ma tran: "; cin>>n;
	a = new int*[n];
    for(int i = 0; i < n; i++)
    a[i] = new int[n]; 
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			cout<<"a"<<i+1<<j+1<<"= ";
			cin>>a[i][j];
		}
	}
}

void matrix::xuat(){
	cout<<"\nma tran vua nhap:\n";
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			cout<<a[i][j]<<" ";
		}
		cout<<"\n";
	}
}

int matrix::tong(){
	int s=0;
	for(int i=0; i<n; i++)
	{
		for(int j=i; j<n; j++){
			if(i<j) s+=a[i][j];
		}
 	}
 	return s;
}

int matrix::chanmin(){
	int chan=99999998;
	
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++){
			if(a[i][j]%2==0 && a[i][j]<chan) chan=a[i][j];
		}
 	}
 	return chan;
}
int main()
{
	matrix h;
	h.nhap();
	h.xuat();
	cout<<"\nChan min: "<<h.chanmin();
	cout<<"\nTong "<<h.tong();
}

