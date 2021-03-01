#ifndef SINGLELIST_CPP
#define SINGLELIST_CPP 1
#include "node.cpp"
#include "iostream"
using namespace std;
template <class T>
class SingleList{
	private:
		Node<T> *header;		//con tro tro vao dau danh sach.
		Node<T> *trailer;		//contro tro vao phan tu cuoi cua danh sach.
		long n;					//so phan tu hien co cua danh sach.
	public:
		SingleList();	
		long size();
		int isEmpty();
		Node<T> *first();		//tra lai dia chi con tro header tro den.
		Node<T> *last();		//tra lai dia chi con tro trailer tro den.
		void replace(Node<T> *p,T e);				//thay the phan tu luu trong p bang phan tu e va tra lai dia chi p.
		Node<T> *inserAfter(Node<T> *p,T e);		//chen them node sau node do p tro toi.
		Node<T> *inserFirst(T e);					//chen them 1 node vao dau danh sach.
		Node<T> *inserLast(T e);					//chen them 1 node vao cuoi danh sach.
		void remove(Node<T> *p);					//loai bo node do con tro p tro toi.
		Node<T> *getNode(int i);
};
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
SingleList<T>::SingleList(){
	header 	= NULL;
	trailer = NULL;
	n 		= 0;
}		
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
long SingleList<T>::size(){
	return n;
}		
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
int SingleList<T>::isEmpty(){
	return n == 0;
}		
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::first(){
	return header;
}		
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::last(){
	return trailer;
}		
//------------------------------------------------------------------------------------------------------------------------------------------------
//thay the phan tu luu trong node do co dia chi luu trong p bang phan tu co gia tri e
template <class T>
void SingleList<T>::replace(Node<T> *p,T e){
	p->setElem(e);
}	
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::inserAfter(Node<T> *p,T e){
	Node<T> *q;
	q = new Node<T>;
	q->setElem(e);
	
	q->setNext(p->getNext());
	p->setNext(q);
	
	if(p==trailer) trailer=q;
	n++;
	return q;
}	
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::inserFirst(T e){
	Node<T> *q;
	q = new Node<T>;
	q->setElem(e);
	
	if(isEmpty()) {
		header	= q;
		trailer	= q;
	}
	else {
		q->setNext(header);
		header	= q;
	}
	n++;
	return q;
}
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::inserLast(T e){
	Node<T> *q;
	q = new Node<T>;
	q->setElem(e);
	
	if(isEmpty()) {
		header	= q;
		trailer	= q;
	}
	else {
		trailer->setNext(q);
		trailer	= q;
	}
	n++;
	return q;
}
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
void SingleList<T>::remove(Node<T> *p){
	Node<T> *q;
	if(p==header) {
		if(size()==1) {
			header	= NULL;
			trailer	= NULL;
		}
		else
			header	= header->getNext();
	}
	else {
		q	= header;
		while(q->getNext() != 1) 				//Vong lap tim den vi tri cua node truoc node p
			q	= q->getNext();
		if(p!=NULL) {							//tim node can xoa
			if(p!=trailer) 
				q->setNext(p->getNext());
			else trailer	= q;
		}
	}
	n--;
	delete []p;
}
//------------------------------------------------------------------------------------------------------------------------------------------------
template <class T>
Node<T>* SingleList<T>::getNode(int i){
	if(i<0 || isEmpty()) return NULL;
	Node<T>  *p;
	int dem=0;
	p	= header;
	while(dem<i && p!=NULL) {
		dem++;
		p	= p->getNext();
	}
	return p;
}
#endif
