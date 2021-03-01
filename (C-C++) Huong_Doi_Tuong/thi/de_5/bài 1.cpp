#include<bits/stdc++.h>

using namespace std;
class book{
	string ID,name,Author,NXB;     //Author: tác gia
	int Year;
	public:
		book(){
			ID = ' ';
			name=' ';
			Author=' ';
			Year=0;
			NXB=' ';
		}
		book(string a,string b, string c,int d ,string e){
			ID=a;
			name=b;
			Author=c;
			Year=d;
			NXB = e;
		}
		void nhap();
		void xuat();
		string getAuthor();
};

void book::nhap(){
	cout<<"\nID: "; fflush(stdin); getline(cin,ID);
	cout<<"\nName: "; fflush(stdin); getline(cin,name);
	cout<<"\nName Author: "; fflush(stdin); getline(cin,Author);
	cout<<"\nYear: "; cin>>Year; 
	cout<<"\nNha xuat ban: "; fflush(stdin); getline(cin,NXB);
}
void book::xuat(){
	cout<<"\nID: "<<ID;
	cout<<"\nName: "<<name;
	cout<<"\nName Author: "<<Author;
	cout<<"\nYear: "<<Year; 
	cout<<"\nNha xuat ban: "<<NXB;
}

string book::getAuthor(){
	return Author;
}
int main()
{
	book *a;
	int n;
	cout<<"\nNhap so dau sach: "; cin>>n;
	
	a= new book[n+1];
	for(int i=0 ; i<n ; i++){
		a[i].nhap();
	}
	system("cls");
	string Find;
	cout<<"\nNhap ten tac gia can tim: ";
	fflush(stdin);
	getline(cin,Find);
	
	system("cls");
	cout<<"\ndanh sach cac dau sach cua tac gia "<<Find<<": \n";
	for(int i=0 ; i<n ; i++){
		if(a[i].getAuthor()==Find)
		a[i].xuat();
	}
}

