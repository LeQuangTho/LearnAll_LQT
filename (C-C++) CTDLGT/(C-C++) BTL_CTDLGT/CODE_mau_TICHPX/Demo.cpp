//Cay tim kiem nhi phan
#include<bits/stdc++.h>
using namespace std;
class Tre
{
	public:
	int Elem;
	Tre *Left,*Right;
	Tre(int x,Tre *L=0,Tre *R=0) {Elem=x,Left=L,Right=R;} //Ham tao	
};
void Insert(Tre *&T,int x)
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
Tre *Find(Tre *T,int x)
{
	if(T==0 || T->Elem==x) return T;
	return x<T->Elem?Find(T->Left,x):Find(T->Right,x);
}
int Max(Tre *T){return T->Right?Max(T->Right):T->Elem;}
int Min(Tre *T){return T->Left?Min(T->Left):T->Elem;}
void Remove(Tre *&T,int x)
{
	if(T==0) return;
	if(T->Elem>x) return Remove(T->Left,x);
	if(T->Elem<x) return Remove(T->Right,x);
	if(T->Left==0) T=T->Right;
	else 
	{
		int k=Max(T->Left);
		T->Elem=k;
		Remove(T->Left,k);
	}
}
int main()
{
	int a[]={34,56,23,12,48,60,43,72,30,17,21,9,98,85,56};
	Tre *T=0; //Khoi tao cay rong
	for(int x=0;x<15;x++) Insert(T,a[x]);
	cout<<"\nCay sau khi chen cac gia tri \n";
	InOrder(T);
	Tre *p=Find(T,85);
	if(p==0) cout<<"Khong co";
	else {cout<<"Tim thay \n"; InOrder(p,"  ");}
	cout<<"\nGia tri nho nhat tren cay "<<Min(T);
	cout<<"\nGia tri lon nhat tren cay "<<Max(T);
	Remove(T,56);
	cout<<"\nCay sau khi xoa cac gia tri \n"; InOrder(T);	
}
