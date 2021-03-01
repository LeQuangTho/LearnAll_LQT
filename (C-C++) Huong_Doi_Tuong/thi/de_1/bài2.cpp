#include<bits/stdc++.h>

using namespace std;

class Diem{
	int x,y;
	public:
		Diem(){x=0;y=0;}
		Diem(int a,int b){x=a;y=b;}
		
		friend istream &operator>>(istream& in, Diem &a);
		friend ostream &operator<<(ostream& out, Diem &a);
		double kc();
		void nhap(){
			cout<<"\nnhap hoanh do: "; cin>>x;
			cout<<"\nnhap tung do: "; cin>>y;
		}
		
		void xuat(){
			cout<<"("<<x<<" , "<<y<<")";
		}
};
istream &operator>>(istream& in, Diem &a){
	cout<<"\nnhap hoanh do: "; in>>a.x;
	cout<<"\nnhap tung do: "; in>>a.y;
	return in;
}

ostream &operator<<(ostream& out, Diem &a){
	out<<"("<<a.x<<" , "<<a.y<<")";
	return out;
}

double Diem::kc(){
	return sqrt(x*x+y*y);
}

class DiemMau : public Diem{
	int mau;//1 do 2 vang 3 xanh
	public:
		DiemMau():Diem(){
			mau=0;
		}
		
		DiemMau(Diem a,int b):Diem(a){
			mau=b;
		}
		
		void nhap(){
			Diem::nhap();
			cout<<"\nNhap mau: ";
			cin>>mau;
		}
		
		void xuat(){
			Diem::xuat();
			cout<<"mau "<<mau<<"\n";
		}
		int getMau(){
			return mau;
		}
};

int main()
{
	int n;
	DiemMau *a;
	cout<<"\nNhap so diem: "; cin>>n;
	a =new DiemMau[n+1];
	for(int i=0; i<n; i++){
		cout<<"thong tin diem "<<i+1<<" ";
		a[i].nhap();
	}
	
	for(int i=0; i<n; i++){
		cout<<"thong tin diem "<<i+1<<" ";
		a[i].xuat();
	}
	
	cout<<"\nthong tin diem do";
	for(int i=0; i<n; i++){
		if(a[i].getMau()==1){
			cout<<"\nthong tin diem "<<i+1<<" ";
			a[i].xuat();
		}
	}
	
	cout<<"\nthong tin diem vang";
	for(int i=0; i<n; i++){
		if(a[i].getMau()==2){
			cout<<"\nthong tin diem "<<i+1<<" ";
			a[i].xuat();
		}
	}
	
	cout<<"\nthong tin diem xanh";
	for(int i=0; i<n; i++){
		if(a[i].getMau()==3){
			cout<<"\nthong tin diem "<<i+1<<" ";
			a[i].xuat();
		}
	}
	
	delete[] a;
}

