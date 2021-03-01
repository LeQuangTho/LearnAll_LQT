#include<bits/stdc++.h>

using namespace std;

class MH{   //mon hoc
	string ID,name;
	int STin;
	public:
		void nhap();
		void xuat();
		string getMon(){
			return name;
		}
		
		int getTin(){
			return STin;
		}
};

void MH::nhap(){
	cout<<"\nID: "; fflush(stdin); getline(cin,ID);
	cout<<"\nName: "; fflush(stdin); getline(cin,name);
	cout<<"\nSo Tin chi: ";   cin>>STin;
}
void MH::xuat(){
	cout<<"\nID: "<<ID;
	cout<<"\nName: "<<name;
	cout<<"\nSo Tin chi: "<<ID;
}

class DKMH{
	string IDs,names;
	int *check;
	public:
		void nhap(int m, MH *&a){
			check= new int[m];
			cout<<"\nNhap ID sinh vien: "; fflush(stdin);	getline(cin,IDs);
			cout<<"\nNhap ten sinh vien: "; fflush(stdin);	getline(cin,names);
			
			cout<<"\nnhap ban dang ki: (Dang ki: 1    Khong dang ki: 0)\n";
			for(int i = 0; i<m ; i++){
				cout<<"\nMon "<<a[i].getMon()<<" "; cin>>check[i];
			}
		}
		
		int Stin(int m , MH *a){
			int s=0;
			for (int i=0;i<m;i++){
				s+=(a[i].getTin()*check[i]);
			}
			return s;
		}
};
int main()
{
	MH *a;
	int m,n;
	DKMH *b;
	cout<<"\nNhap so mon hoc: "; cin>>m;
	cout<<"\nNhap so luong hoc sinh: "; cin>>n;
	a= new MH[m+1];
	b= new DKMH[n+1];
	cout<<"\nNhap cac mon hoc: ";
	for(int i = 0; i<m ; i++){
		cout<<"\nNhap mon thu "<<i+1<<": ";
		a[i].nhap();
	}
	 
	cout<<"\nNhap danh sach sinh vien: ";
	for(int i = 0; i<n ; i++){
		cout<<"\nNhap thong tin hoc sinh thu "<<i+1<<": ";
		b[i].nhap(m,a);
	}
	
	for(int i = 0; i<n ; i++){
		cout<<"\nSinh vien thu "<<i+1<<"dang ki : "<<b[i].Stin(m,a)<<" tin";
	}
	delete[] a;
	delete[] b;
}

