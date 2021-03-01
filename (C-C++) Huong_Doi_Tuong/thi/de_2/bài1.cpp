#include<bits/stdc++.h>

using namespace std;

class DT{
	int bac, *hs;
	public:
		void nhap(){
			cout<<"\nNhap bac cua da thuc: "; cin>>bac;
			hs= new int[bac+1];
			for(int i = (this->bac);i>=0 ; i--){
				cout<<"a"<<i<<"= ";  cin>>hs[i];
			}
		}
		
		int gt(int x);
};

int DT::gt(int x){
	int s=0;
	for(int i = (this->bac);i>=0 ; i--){
		s+=(i*pow(x,i-1)*hs[i]);
	}
	return s;
}
int main()
{
	DT a;
	int n;
	a.nhap();
	cout<<"\nNhap x= "; cin>>n;
	cout<<"\nf'(x)= "<<a.gt(n);
}

