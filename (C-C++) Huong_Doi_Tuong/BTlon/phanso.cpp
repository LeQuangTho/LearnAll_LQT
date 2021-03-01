//phan so
#include<bits/stdc++.h>

using namespace std;

class PS{
	int x,y;
	public:
		
	PS(){
		x=0;
		y=1;
	}
	
	PS(int tu,int mau){
		x=tu;
		y=mau;	
	}
	
	friend int UCLN(int &x,int &y);
	friend void rutgon(PS &p);
	
	friend istream &operator>>(istream& in,PS &p); 
	friend ostream &operator<<(ostream& out,PS &p); 
	
	PS operator+(PS p1){
		PS p;
		p.x=(x*p1.y)+(p1.x*y);
		p.y=(y*p1.y);
		rutgon(p);
		return p;
	}
	
	PS operator-(PS p1){
		PS p;
		p.x=x*p1.y-p1.x*y;
		p.y=y*p1.y;
		rutgon(p);
		return p;
	}
	
	PS operator*(PS p1){
		PS p;
		p.x=x*p1.x;
		p.y=y*p1.y;
		rutgon(p);
		return p;
	}
	
	PS operator/(PS p1){
		PS p;
		p.x=x*p1.y;
		p.y=y*p1.x;
		rutgon(p);
		return p;
	}
};

int UCLN(int x,int y){
		x=abs(x);
		y=abs(y);
		if(x==y) return x;
		else if(x==0) return 1;
		else if(x>y) return UCLN(x-y,y);
		else return UCLN(x,y-x);
	}
void rutgon(PS &p){
	int a=UCLN(p.x,p.y);
		p.x=p.x/a;
		p.y=p.y/a;
	}
istream &operator>>(istream& in,PS &p){
	cout<<"\nnhap tu so: ";
	in>>p.x;
	cout<<"\nnhap mau so: ";
	in>>p.y;
	return in;
}

ostream &operator<<(ostream& out,PS &p){
	rutgon(p);
	if (p.x*p.y>0 && p.x<0) out<<p.x<<"/"<<abs(p.y);
	else if(p.x==p.y) out<<1;
	else if(abs(p.y)==1) out<<p.x*p.y;
	else if(p.x==0 || p.y==0) out<<0;
	else out<<p.x<<"/"<<p.y;
	return out;
}

	
int main()
{
	PS p1,p2,p3,p4,p;
	cin>>p1;
	cin>>p2;
	p=p1+p2;
	cout<<"\np1+p2 ="<<p;
	p=p1-p2;
	cout<<"\np1-p2 ="<<p;
	
	p=p1*p2;
	cout<<"\np1*p2 ="<<p;
	p=p1/p2;
	cout<<"\np1/p2 ="<<p;
	cin>>p3;
	cin>>p4;
	p= (p1+p2)/(p3-p4)*p1;
	cout<<"\n(p1+p2)/(p3-p4)*p1= "<<p;
}
