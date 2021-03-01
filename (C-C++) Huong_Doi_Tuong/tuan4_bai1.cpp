#include<bits/stdc++.h>

using namespace std;

class DT{
	int bac;
	float *hs;
	public:
		DT();
		DT(const int &n);
		void nhap();
		void xuat();
		friend  float tinhgt(const DT &P,const float &x);
		friend  DT operator+(const DT &P,const DT &Q);
};
DT::DT(){
	bac=1;
	hs=new float[2];
}
DT::DT(const int &n)
{
	bac=n;
	hs=new float[n+1];
}
void DT::nhap(){
	cout<<"Nhap bac cua da thuc: "; cin>>bac;
	for(int i=0;i<=bac;i++)
	{
		cout<<"nhap he so thu "<<i+1<<" "; cin>>hs[i];
	}
}
void DT::xuat(){
	for(int i=0;i<=bac;i++)
	{
		if(i<bac) cout<<hs[bac-i]<<"*x^"<<i<<"+  ";
		else cout<<hs[bac-i]<<endl;
	}
}
float tinhgt(const DT &P,const float &x){
	float S=0;
	for (int i=0;i<=P.bac;i++)
	{
		S+=P.hs[i]*pow(x,P.bac-i);
	}
	return S;
} 
DT operator+ (const DT &P,const DT &Q){
	DT K;
	K.bac=P.bac<Q.bac?Q.bac:P.bac;
	for(int i=0;i<=K.bac;i++)
	{
		K.hs[i]=P.hs[i]+Q.hs[i];
	}
	return K;
}
int main()
{
	DT a,b,c;
	int d,e;
	a.nhap();
	b.nhap();
	c=a+b;
	c.xuat();
	a.xuat();
	cout<<"\nS= "<<tinhgt(a,2);
	cout<<"\nNhap x1= ";cin>>d;
	cout<<"\nNhap x2= ";cin>>e;
	int s=sqrt(tinhgt(a,d)-tinhgt(b,e));
	cout<<"can P-Q = "<<s;
}
