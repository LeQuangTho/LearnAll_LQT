#ifndef NODE_H
#define NODE_H 1
#include"iostream"
using namespace std;
template <class Keys, class T>
class NODE{
	private:
      	Keys key;
		T elem;
		NODE<Keys,T> *parent;
		NODE<Keys,T> *left;
		NODE<Keys,T> *right;
	public:
     	NODE();
		NODE<Keys,T> *getParent();
		NODE<Keys,T> *getLeft();
		NODE<Keys,T> *getRight();
		Keys getKey();
		T getElem();
		void setElem(T e);
		void setKey(Keys k);
		void setLeft(NODE<Keys,T>* p);
		void setRight(NODE<Keys,T>* p);
		void setParent(NODE<Keys,T>* p);
};
#endif
