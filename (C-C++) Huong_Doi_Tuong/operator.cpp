#include<bits/stdc++.h>
using namespace std;
void htron()
{
	double R;
	do{
		cout<<"nhap R > 0 \n";
		cin>>R;
	}while(R<=0);
	cout<<"dien tich hinh tron R= "<<R<<":"<<R*3.14;
}
void hcn()
{
	double a,b;
	do{
		cout<<"nhap hai canh hinh chu nhat a*b> 0 va a>0 \n";
		cin>>a>>b;
	}while(a<=0 || b<=0);
	cout<<"dien tich hinh chu nhat a= "<<a<<";"<<"b= "<<b<<": "<<a*b;
}
double p(double a, double b, double c)
{
	return ((a+b+c)/2);
}
double s(double a, double b, double c )
{
    double P,s;
    P=p(a,b,c);
    s=sqrt(P*(P-a)*(P-b)*(P-c));
	return s;
}
void htg()
{
	double a,b,c;
	do{
		cout<<"nhap hai canh hinh tam giac a*b*c > 0 va a>0 \n";
		cin>>a>>b>>c;
	}while(a<=0 || b<=0 || c<=0);
	cout<<"dien tich hinh tam giac a= "<<a<<";"<<"b= "<<b<<";"<<"c= "<<c<<": "<<s(a,b,c);
}
int main()
{
	int n;
	cout<<"Chon phep hinh dang"<<endl;
	cout<<"1. Hinh tron"<<endl;
	cout<<"2. hinh chu nhat"<<endl;
	cout<<"3. hinh tam giac"<<endl;
	do{
		cin>>n;
	}
	while(n<0);
	if(n==1) htron();
	else if(n==2) hcn();
	else if(n==3) htg();
}
