#ifndef STUDENT_CPP
#include"conio.h"
#include"iostream"

using namespace std;

class Student{
	private:
		int id;
		char Name[30];
		char sex[5];
 	public:
 		friend istream & operator >>(istream &is, Student &s);
 		friend ostream & operator <<(ostream &os, Student s);
};

istream &operator >>(istream &is , Student &s)
{
	cout<<"\nNhap Ma Sv: ";
	is>>s.id;
	cout<<"\nNhap Ho Va Ten: ";
	is.ignore(1);
	is.get(s.Name,30);
	is.ignore(1);
	cout<<"\nEnter student sex: ";
	is.get(s.sex,5);
	return is;
}

ostream &operator <<(ostream &os, Student s)
{
	os<<s.id<<"\t"<<s.Name<<"\t"<<s.sex;
	return os;
}
#endif
