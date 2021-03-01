#ifndef STUDENT_CPP
#include"bits/stdc++.h"
using namespace std;
class Student{
	private:
		int masv;
		char hoten[50];
		char gioi[5];
	public:
		friend istream & operator >>(istream &is, Student &s);
		friend ostream & operator <<(ostream &os, Student s);
};
istream & operator >>(istream &is, Student &s)
{
	cout<<"\nNhap ma SV: ";
	is>>s.masv;
	cout<<"\nNhap ho va ten: ";
	is.ignore(1);
	is.get(s.hoten,30);
	cout<<"\nNhap gioi tinh: ";
	is.ignore(1);
	is.get(s.gioi,5);
	return is;
}
ostream & operator <<(ostream &os, Student s)
{
	os<<s.masv<<"\t"<<s.hoten<<"\t"<<s.gioi;
	return os;
}
#endif
