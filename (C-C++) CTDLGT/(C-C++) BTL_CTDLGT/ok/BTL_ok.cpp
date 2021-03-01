#include<bits/stdc++.h>
#include <fstream>
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
void them(tree *&T,string x=" ")//-------------------------------------Them------------------------------------------
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

void ghi(tree* &T,ofstream &fo,string p="  "){
	if(!T) return;
	ghi(T->left,fo,p+string(10,' '));
	fo<<p<<T->a<<"\n";
	ghi(T->right,fo,p+string(10,' '));
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
	fo.open("xuat.txt");
	ghi(T,fo);
	fo.close();
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

int menu(){
		    cout<<"1.Nhap cay tu file.";
			cout<<"\n2.Them tu.";
			cout<<"\n3.Xoa tu.";
			cout<<"\n4.Thay doi tu.";
			cout<<"\n5.Tim kiem.";
			cout<<"\n6.Ket thuc chuong trinh";
			cout<<"\n--------------Chon chuc nang tu 1..6----------------- ";
			int n;
			cin>>n; 
			return n;			
}

void run(tree* &T){
		ofstream fo;
		fo.open("xuat.txt");
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
					them(T);
					break;
				case 3:
					Remove(T);
					break;
				case 4:
					update(T);
					break;
				case 5:
					Find();
					break;
			}
			getch();
		}while(ch!=6);
}

int main()
{
	tree *T=NULL;

	ofstream fo;
	
	fo.open("xuat.txt");
	
	run(T);
	
	fo.close();

}
