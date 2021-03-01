#include<bits/stdc++.h>

using namespace std;

class MH{
	char ma[10],ten[30];
	int tin;
	public:
		MH();
		MH(char s1[10],char s2[30],int TC);
//		{
//			strcpy(ma,s1);
//			strcpy(ten,s2);
//			tin=TC;
//		}
		friend istream& operator>>(istream&,MH &);
		friend ostream& operator<<(ostream&,MH &);
		int operator +(MH &mh2)
		{
			return(tin + mh2.tin);
		} 	
		char getT()
		{
			return ten[30];
		}
		int getTC()
		{
			return tin;
		}
};
MH::MH()
{
	strcpy(ma,"");
	strcpy(ten,"");
	tin=2;
}
MH::MH(char s1[10],char s2[30], int TC)
{
	strcpy(ma,s1);
	strcpy(ten,s2);
	tin=TC;
}
istream& operator>>(istream&in,MH &mh)
{
	cout<<"Nhap ma mon: "; in.get(mh.ma,10);
	cout<<"Nhap ten mon: "; in.ignore(1); in.get(mh.ten,30);
	cout<<"Nhap so tin chi: "; in>>mh.tin;
}
ostream& operator<<(ostream&out,MH &mh)
{
	out<<"Ma mon: "<<mh.ma<<endl;
	out<<"Ten mon: "<<mh.ten<<endl;
	out<<"So tin chi: "<<mh.tin<<endl;
}
class list{
	int n;
	MH *A;
	public:
		list (int n=2)
		{
			A= new MH[n+1];
			for(int i=0;i<n;i++)
			{
				cin>>A[i];
			}
		}
};

int main()
{
	MH mh1("01","Toan roi rac",3), mh2;
	cin>>mh2;
	cout<<mh1<<mh2;
	cout<<"Tong tin chi: "<<mh1+mh2;
}
