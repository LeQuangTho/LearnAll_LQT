//Cay tim kiem nhi phan
#include<bits/stdc++.h>
using namespace std;
class Tre
{
	public:
	char Elem;
	Tre *Left,*Right;
	Tre(char x,Tre *L=NULL,Tre *R=NULL) {Elem=x,Left=L,Right=R;} //Ham tao	
};
void Insert(Tre *&T,char x)
{
	if(T==0) {T=new Tre(x); return;}
	if(x<T->Elem) 
	{
		if(T->Left==0) T->Left=new Tre(x);
		else Insert(T->Left,x);
	}
	else
	{
		if(T->Right==0) T->Right=new Tre(x);
		else Insert(T->Right,x);
	}
}
void InOrder(Tre *T,string p="  ")
{
	if(!T) return;
	InOrder(T->Left,p+string(5,' '));
	cout<<p<<T->Elem<<"\n";
	InOrder(T->Right,p+string(5,' '));
}
Tre *Find(Tre *T,char x)
{
	if(T==NULL || T->Elem==x) return T;
	return x<T->Elem?Find(T->Left,x):Find(T->Right,x);
}
char Max(Tre *T){return T->Right?Max(T->Right):T->Elem;}
char Min(Tre *T){return T->Left?Min(T->Left):T->Elem;}
void Remove(Tre *&T,char x)
{
	if(T==NULL) return;
	if(T->Elem>x) return Remove(T->Left,x);
	if(T->Elem<x) return Remove(T->Right,x);
	if(T->Left==NULL) T=T->Right;
	else 
	{
		int k=Max(T->Left);
		T->Elem=k;
		Remove(T->Left,k);
	}
}
int main()
{
	char a[]={'a','c','b','d','e','f','g','h','i','k','l','m','n','o','p'};
	Tre *T=0; //Khoi tao cay rong
	for(int x=0;x<15;x++) Insert(T,a[x]);
	cout<<"\nCay sau khi chen cac gia tri \n";
	InOrder(T);
	Tre *p=Find(T,'p');
	if(p==0) cout<<"Khong co";
	else {cout<<"Tim thay \n"; InOrder(p,"  ");}
	cout<<"\nGia tri nho nhat tren cay "<<Min(T);
	cout<<"\nGia tri lon nhat tren cay "<<Max(T);
	Remove(T,'p');
	cout<<"\nCay sau khi xoa cac gia tri \n"; InOrder(T);	
}
