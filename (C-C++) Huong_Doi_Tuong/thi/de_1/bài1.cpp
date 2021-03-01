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
int main()
{
	int n;
	Diem *a;
	cout<<"\nNhap so diem: ";cin>> n;
	a = new Diem[n];
	for(int i=0;i<n;i++){
		cout<<"\nhap diem a["<<i+1<<"]= "; cin>>a[i];
	}
	
	double S=0,*b;
	b=new double[n+1];
	for(int i=0;i<n;i++){
		b[i]=a[i].kc();
		S+=a[i].kc();
	}
	
	double min=b[1];
	int k;
	for(int i=0 ;i<n ;i++){
		if(b[i]<min) {
		min=b[i]; 
		k=i;
		}
	}
	
	cout<<"diem gan O nhat la diem a"<<k+1<<a[k];
	
	delete[] a;
	delete[] b;
}

