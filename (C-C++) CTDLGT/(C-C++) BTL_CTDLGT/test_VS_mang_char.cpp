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
void them(tree *&T,string x){
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

void doc(tree *&T,ifstream &fi){
	while(true){
		string x;
		getline(fi,x);
		them(T,x);
		cout<<x;
		if(fi.eof()==true) break;
		}
}

void ghi(tree* &T,ofstream &fo,string p="  "){
	if(!T) return;
	ghi(T->left,fo,p+string(10,' '));
	fo<<p<<T->a<<"\n";
	ghi(T->right,fo,p+string(10,' '));
}
int main()
{
	tree *T=NULL;
	ifstream fi;
	ofstream fo;
	fi.open("nhap.txt");
	doc(T,fi);
	fo.open("xuat.txt");
	ghi(T,fo);
	fi.close();
	fo.close();
//	tree T;
//	T=NULL;
}
