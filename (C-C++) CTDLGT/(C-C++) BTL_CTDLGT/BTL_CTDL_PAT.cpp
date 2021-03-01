#include<bits/stdc++.h>
#include <fstream>
#include"conio.h"
#include"stdio.h"
#include"iostream"
using namespace std;

class tree{
	public:
	string a;
	tree *left,*right;
	public:
		tree(string x,tree *l = NULL,tree *r = NULL){
			a = x;
			left = l;
			right = r;
		}
};
void them(tree *&T,string x)//-------------------------------------Them------------------------------------------
{
	if(T == NULL) {T= new tree(x); return;}
		if(x<T->a) 
		{
			if(T->left==NULL) T->left=new tree(x);
			else them(T->left,x);
		}
		else
		{
			if(T->right==NULL) T->right=new tree(x);
			else them(T->right,x);
		}	
}	


void ghi(tree* &T,ofstream &fo,string p="  ")//----------------Ghi tep-------------------------------------------
{
	if(!T) return;
	ghi(T->right,fo,p+string(5,' '));
	fo<<p<<T->a<<"\n";
	ghi(T->left,fo,p+string(5,' '));
}

void doc(tree *&T,ofstream &fo)//---------------------------------------Doc-----------------------------------
{
	char b[100];
	cout<<"\nNhap ten nhap input: ";
	fflush(stdin);
	gets(b);
	ifstream fi;
	fi.open(b);
	while(true){
		string x;
		getline(fi,x);
		them(T,x);
		cout<<x<<"\n";
		if(fi.eof()==true) break;
		}
	cout<<"\nNhap thanh cong!";
	fi.close();
	ghi(T,fo);
}
void duyet(tree *&T,ofstream &fo)//----------------------Duyet-------------------------------------------------
{
	if(T!=NULL) {
		duyet(T->left,fo);
		fo<<T->a <<endl;
		duyet(T->right,fo);
	}
}
tree *Find(tree *T, string x)//-------------------------------Tim kiem-----------------------------------------
	{
		if (T == 0 || T->a == x)
			return T;
		return x < T->a ? Find(T->left, x) : Find(T->right, x);
	}

string Max(tree *T) //---------------------------------------Tim max--------------------------------------------
	{ 
		return T->right ? Max(T->right) : T->a; 
	}
			
void Remove(tree *&T, string x) //----------------------------------Xoa------------------------------------------
	{
		if (T == 0)
			return;
		if (T->a > x)
			return Remove(T->left, x);
		if (T->a < x)
			return Remove(T->right, x);
		if (T->left == 0)
			T = T->right;
		else
		{
			string k = Max(T->left);
			T->a = k;
			Remove(T->left, k);
		}
	}

void update(tree *&T, string x, string y) //-----------------------------Thay doi gtri---------------------------
	{
		if (T == 0)
			return;
		if (T->a > x)
			return update(T->left, x, y);
		if (T->a < x)
			return update(T->right, x, y);
		T->a = y;
	}

void apptk(tree *&T, ofstream &fo)//-----------------------------------------App tim kiem----------------------------------------------
{
	string s1;
	cout << "\nNhap tu khoa can tim: ";
	fflush(stdin);
	getline(cin,s1);
	tree *p = Find(T,s1);
	if (p == 0)
	{
		cout << "Khong co tu khoa can tim trong cay!\7\7";
		fo<< "Khong co tu khoa can tim trong cay!";
	}
	else
	{
		cout << "Tim thay \n";
		cout << s1 <<"\7\7";
		fo<< "Tu khoa can tim: "<< s1;
	}
}

void appx(tree *&T, ofstream &fo)//-----------------------App Xoa------------------------------------------
{
	string s1;
	cout << "\nNhap tu khoa can xoa: ";
	fflush(stdin);
	getline(cin,s1);
	tree *q = Find(T,s1);
	if (q == 0)
	{
		cout << "\nKhong co tu khoa can xoa trong cay!";
		fo<< "\nKhong co tu khoa can xoa trong cay!";
	}
	else
	{
		Remove(T,s1);
		cout << "\nTim thay va da xoa: "<<s1<<endl;
		fo<< "\nCay sau khi xoa tu khoa: "<<s1<<endl;
		ghi(T,fo);
	}
}
void  apptdgt(tree *&T, ofstream &fo)//--------------App Thay doi gia tri----------------------
{
	string s3,s4;
	cout << "\nNhap tu khoa can thay doi: ";
	fflush(stdin);
	getline(cin,s3);
	tree *w = Find(T, s3);
	if (w == 0)
	{
		cout << "\nKhong co tu khoa can thay doi!";
		fo<< "\nKhong co tu khoa can thay doi!";
	}	
	else
	{
		cout << "\nThay doi tu khoa thanh: ";
		fflush(stdin);
		getline(cin,s4);
		update(T, s3, s4);
		cout << "\nDa thay doi tu khoa!";
		fo<< "\nCay sau khi thay doi tu khoa:\n";
		ghi(T,fo);
	}
}

void appd(tree *&T, ofstream &fo)
{
	cout<<"\nDa duyet theo thu tu giua va luu vao file \7\3";
	duyet(T,fo);
}

void appt(tree *&T, ofstream &fo)
{
	string s;
	cout<<"\nNhap vao thu khoa can them: ";fflush(stdin);getline(cin,s);
	them(T,s);
	ghi(T,fo);
	cout<<"\nDa them tu khoa vao cay! ";
}

int menu(){
			
			cout<<"--------------Chon chuc nang tu 1..7-----------------\n";
		    cout<<"-1.Nhap cay tu file.\n";
			cout<<"-2.Duyet cay theo thu tu giua.\n";
			cout<<"-3.Xoa tu.\n";
			cout<<"-4.Thay doi tu.\n";
			cout<<"-5.Tim kiem.\n";
			cout<<"-6.Them tu.\n";
			cout<<"-7.Ket thuc chuong trinh.\n";
			int n;
			cin>>n; 
			return n;			
}

void run(tree* &T, ofstream &fo)
{
		int ch;
		do{
			system("cls"); // xoa man hinh
			ch = menu();
			system("cls");
			switch(ch){
				case 1:
					doc(T,fo);
					break;
				case 2:
					appd(T,fo);
					break;
				case 3:
					appx(T,fo);
					break;
				case 4:
					apptdgt(T,fo);
					break;
				case 5:
					apptk(T,fo);
					break;
				case 6:
					appt(T,fo);
					break;
			}
			getch();
		}while(ch!=7);
}
int main()
{
	tree *T=NULL;
	string s1,s2,s3,s4;
	ofstream fo;
	fo.open("xuat.txt");
	run(T,fo);
	fo.close();
//	tree T;
//	T=NULL;
}
