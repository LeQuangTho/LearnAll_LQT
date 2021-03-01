#ifndef NODE_CPP
#define NODE_CPP 1
#include"iostream"
using namespace std;
template <class T>
class Node{
	private:
		T elem;
		Node *next;
	public:
		Node();
		Node *getNext();
		void setNext(Node<T>*);
		T getElem();
		void setElem(T);
};
//-----------------------------------------------------------------
template <class T>
Node<T>::Node(){
	next = NULL;
}
//-----------------------------------------------------------------
template <class T>
Node<T> *Node<T>::getNext(){
	return next;
}
//-----------------------------------------------------------------
template <class T>
void Node<T>::setNext(Node<T> *p){
	next = p;
}
//------------------------------------------------------------------
template <class T>
T Node<T>::getElem(){
	return elem;
}
template <class T>
void Node<T>::setElem(T e){
	elem = e;
}
#endif
