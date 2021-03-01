#include<bits/stdc++.h>

using namespace std;

class HCN{
	double a,b;
	public:
		void nhap();
		void xuat();
		double dientich();
};

void HCN::nhap(){
	cout<<"\nNhap chieu rong: "; cin>>a;
	cout<<"\nNhap chieu dai: "; cin>>b;
}

void HCN::xuat(){
	cout<<"\nKich thuc HCN "<<a<<" x "<<b;
}

double HCN::dientich(){
	return a*b;
}
int main()
{
	HCN *a;
	int n;
	cout<<"\nNhap so luong HCN: "; cin>>n;
	a=new HCN[n+1];
	
	double S=0;
	for(int i=0;i<n;i++){
		a[i].nhap();
		S+=a[i].dientich();
	}
	
	cout<<"\nDien tich trung binh: "<<S/n;
	
	double min=a[0].dientich();
	int k=1;
	for(int i=0;i<n;i++){
		if(a[i].dientich()<min) {min=a[i].dientich(); k=i; }
	}
	
	cout<<"\nDien tich HCN nho nhat: "<<min<< " Hinh thu "<<k;
	delete[] a;
}

