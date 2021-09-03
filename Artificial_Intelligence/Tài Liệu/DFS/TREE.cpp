#ifndef BTREE_H
#define BTREE_H 1
#include"stdio.h"
#include"NODE.cpp"
template <class Keys, class T>
class TREE{
	private:
		NODE<Keys,T> *root;
		long count; 
		void inOrder(NODE<Keys,T>*,NODE<Keys,T>*&first,int &kt);
		void remove(NODE<Keys,T>*&);	

	public:
		TREE();
		NODE<Keys,T> *getRoot(){
			return root;
		}
		int size() {
			return count;	
		}
		NODE<Keys,T> *search(Keys, NODE<Keys,T>*);
		NODE<Keys,T> * insert(Keys, T);
		void inOrder(NODE<Keys,T>*, void (*visit)(NODE<Keys,T>*));
		void  remove(Keys);
};

template <class Keys, class T>
TREE<Keys,T>::TREE()
{
	root = NULL;		
	count=0;
}

#endif

