#include <bits/stdc++.h>
class student{
public:
	std:: string name;
	int id;
};
int nearestPowerOf2(int n){
	int count=0;
	while (n){
		n>>=1;
		count++;
	}
	return 1ULL<<count;
}
template <class T>
class vector{
private:
	T *vectorPointer;
	int size,capacity;
public:
	vector();
	vector(int n);
	~vector();
	void reserve(int newCapacity);
	void insert(int pos, const T& val);
	void pushBack(const T& val);
	T front();
	T back();
	void replace(int pos, const T& val);
	void remove(int pos);
	void remove(int begin, int end);
	T operator[] (const int pos);
	T operator = (const T& vectorCopy);
	int sizeVector();
	bool empty();
};
template <class T>
T vector<T>:: operator [](const int pos){
	return vectorPointer[pos];
}
template <class T>
T vector<T>::operator = (const T& vectorCopy){
	swap(*this,vectorCopy);
	return *this;
}
template <class T>
vector<T>::vector(){
	vectorPointer=NULL;
	size=0;
	capacity=0;
}
template <class T>
vector<T>::vector(int n){
	size=n;
	n=nearestPowerOf2(n);
	reserve(n);
	capacity=n;
}
template <class T>
vector<T>::~vector(){
	delete[] vectorPointer;
}
template <class T>
void vector<T>::reserve(int newCapacity){
	newCapacity=nearestPowerOf2(newCapacity);
	if (newCapacity>capacity){
		T *tmp=new T[newCapacity];
		std::copy(vectorPointer,vectorPointer+capacity,tmp);
		delete vectorPointer;
		vectorPointer=tmp;
		capacity=newCapacity;
	}
}
template <class T>
void vector<T>::pushBack(const T& val){
	if (capacity<=size)
		reserve(size);
	vectorPointer[size]=val;
	size++;
}
template <class T>
T vector<T>::front(){
	return vectorPointer[0];	
}
template <class T>
T vector<T>::back(){
	return vectorPointer[size-1];
}
template <class T>
void vector<T>::insert(int pos, const T& val){
	if (capacity<=size)
		reserve(size);
	size++;
	for (int i=size;i>pos;i--)
		vectorPointer[i]=vectorPointer[i-1];
	vectorPointer[pos]=val;
}
template <class T>
void vector<T>::replace(int pos, const T& val){
	vectorPointer[pos]=val;
}
template <class T>
void vector<T>::remove(int pos){
	vectorPointer[pos].~T();
	for (int i=pos;i<size;i++)
		vectorPointer[i]=vectorPointer[i+1];
	size--;
}
template <class T>
void vector<T>::remove(int begin, int end){
	for (int i=begin; i<=end; i++)
		vectorPointer[i].~T();	
	int d=end-begin+1;
	for (int i=begin; i+d<size;i++)
		vectorPointer[i]=vectorPointer[i+d];
	size-=d;
}
template <class T>
int vector<T>::sizeVector(){
	return size;
}
template <class T>
bool vector<T>::empty(){
	return size==0;
}
int main(){
	std::cout<<std::boolalpha;
	vector<student> v;
	v.pushBack({"name",10});
	std::cout << v[0].id;
}
