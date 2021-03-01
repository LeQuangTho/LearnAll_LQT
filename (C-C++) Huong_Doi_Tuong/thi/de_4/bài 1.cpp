#include<bits/stdc++.h>

using namespace std;

class DT{
	int bac, *hs; // he so
	public:
		DT();
		DT(int n);
		~DT();
		void nhap();
		friend ostream &operator<<(ostream &out, DT &a){
			for(int i = a.getBac(); i>0 ; i-- ){
				out<<a.hs[i]<<"x"<<"^"<<i<<"+";
			}
			out<<a.hs[0];
			return out;
		}
		friend int GT(DT a);
		int getBac(){
			return bac;
		}
		
		int *getHS(){
			return hs;
		} 
};

DT::DT(){
	bac=1;
	hs=new int[bac];
}

DT::DT(int n){
	bac=n;
	hs=new int[bac];
}

DT::~DT(){
	delete[] hs;
}

void DT::nhap(){
	cout<<"Nhap bac: "; cin>>bac;
	hs = new int[bac+1];
	for(int i = bac; i>=0 ; i--){
		cout<<"a"<<i<<" = "; cin>>hs[i];
	}
}

double GT(DT a,double x){
	double S=0;
	int *hs=a.getHS();
	for(int i = a.getBac(); i>=0 ;i--){
		S+=(hs[i]*pow(x,i));
	}
	return S;
}
int main()
{
	DT a;
	double d1,d2;
	a.nhap();
	cout<<a;
	cout<<"\nNhap d1 = "; cin>>d1;
	cout<<"\nNhap d2 = "; cin>>d2;
	cout<<"S= "<<GT(a,d1)+GT(a,d2);
	
	a.~DT();
}

