//Bo lap tren danh sach lien ket don
#ifndef SINGLE_LIST_ITR_H
#define SINGLE_LIST_ITR_H 1
#include "slist.cpp"
template <class T>
class SingleList{
	private:
		SingleList<T> * slist;
		Node<T> *cur;
	public:
		SingleListItr(SingleList<T>* list) {
			slist	= list;
			cur		=slist->first();
		}
		void reset(){
			cur	= slist->first();
		}
//--------------------------------------------------------------------------------------------------------------------------------------------------
		int hasNext(){
			return cur!=NULL;
		}
//--------------------------------------------------------------------------------------------------------------------------------------------------
		T next(){
			T o;
			o	= cur->getElem();
			cur	= cur->getNext();
			return o;
		}
};
#endif
