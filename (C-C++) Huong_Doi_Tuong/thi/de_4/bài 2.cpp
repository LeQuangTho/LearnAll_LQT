#include<bits/stdc++.h>

using namespace std;

class People{
	string name;
	int old;
	public:
		void nhap();
		void xuat();
};

void People::nhap(){
	cout<<"\nName: "; fflush(stdin); getline(cin,name);
	cout<<"\nOld: "; cin>>old;
}

void People::xuat(){
	cout<<"\nName: "<<name;
	cout<<"\nOld: "<<old;
}

class QLNV : public People{
	double hs1,hs2;
	public:
		void nhap(){
			People::nhap();
			cout<<"\nHe so luong chinh: "; cin>>hs1;
			cout<<"\nHe so luong phu: "; cin>>hs2;
		}
		double money();
		double phu(){
			double luong2=0;
			if(hs2==2) return luong2= 300;
			else if(hs2==1) return luong2= 200;
			else return luong2= 100;
		}
		
		void xuat(){
			People::xuat();
			cout<<"\nTien luong: "<<money();
		}
};

double QLNV::money(){
	double S=0,lcb = 200,luong2=0;
	if(hs2==2) luong2= 300;
	else if(hs2==1) luong2= 200;
	else luong2= 100;
	
	return S+=hs1*lcb+luong2;
}


int main()
{
	QLNV *a;
	int n;
	cout<<"\nNhap so luong nhan vien: "; cin>>n;
	a= new QLNV[n+1];
	for(int i=0;i<n;i++){
		cout<<"\nNhap nhan vien "<<i+1<<": ";
		a[i].nhap();
	}
	
	system("cls");
	
	for(int i=0;i<n;i++){
		
		cout<<"\n\nNhan vien "<<i+1<<": ";
		a[i].xuat();
		cout<<"\nTi le luong phu: "<<(a[i].phu()/a[i].money())*100;
	}
	double max= a[0].money();
	int k=0;
	
	for(int i=0;i<n;i++){
		if(max< a[i].money()) {
			k=i;
			max= a[i].money();
		}
	}
	
	cout<<"\n\nLuong cao nhat la nguoi thu "<<k<<": "<<max; 
	a[k].xuat();
	
	delete[] a;
}

