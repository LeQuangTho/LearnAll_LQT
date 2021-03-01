#include <bits/stdc++.h>

using namespace std;

class NV{
	string hoten,ma,cv;
	int tuoi,ngaycong;
	public:
		void nhap();
		void xuat();
		NV(string s1="",string s2="",string s3="NV",int t=18)
		{
			hoten=s1;
			ma=s2;
			cv=s3;
			tuoi=t;
		}
		int gettuoi()
		{
			return tuoi;
		}
		double tinhluong(){
			if(strcmp(cv,"GD")==1) return ngaycong*1000000;
			else if(strcmp(cv,"TP")==1) return ngaycong*600000;
			else return ngaycong*300000;
		}
};
class DSNV{
	int n;
	NV *ds;
	public:
		DSNV();
		DSNV(const int &n);
		void nhap();
		void tuoimin();
		double luongTB();
};

int main()
{

}

