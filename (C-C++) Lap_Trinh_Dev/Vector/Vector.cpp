#ifndef VECTOR_CPP
#define VECTOR_CPP 1

template <class T>
class Vector{
	private:
		int N;    //so chieu toi da cua vector
		T *V;     //Luu tru du lieu
		int n;	  //so phan tu hien co trong Vector
	public:
		Vector();
		~Vector();	
		int getAtRank(int r,T &o);
		int replaceAtRank(int r,T o);
		int insertAtRank(int r,T o);
		int removeAtRank(int r,T &o);
		int size();
		int isEmpty();
};

//ham tao
template<class T>
Vector<T>::Vector()
{
	V=new T[1];
	N=1;
	n=0;
}

//ham huy
template<class T>
Vector<T>::~Vector()
{
	delete V;
	N=0;
	n=0;
}

//Chen
template<class T>
int Vector<T>::insertAtRank(int r,T o)
{
	r--;
	if(r<0|| r>n) return 0;
	
	//phat trien mang
	if(n==N)
		{
			T *A;
			N = 2*N;
			A = new T[N];
			for(int i=0; i<n; i++)
			{
				A[i]=V[i];
			}
			delete V;
			V=A;
			
			int k=n-1;
			
			while(k>=r) //lui mang lai
			{
				V[k+1]=V[k];
				k--;
			}
		}
		V[r]=o;
		n++;
		return 1;
}

//lay ra mot phan tu
template<class T>
int Vector<T>::getAtRank(int r, T &o)
{
	if(r<0 || r>n-1) return 0;
	o=V[r];
	return 1;
}

//Thay the 1 phan tu
template<class T>
int Vector<T>::replaceAtRank(int r,T o)
{
	if(r<0 || r>n-1) return 0;
	V[r]=o;
	return 1;
}

//xoa mot phan tu
template<class T>
int Vector<T>::removeAtRank(int r,T &o)
{
	if(r<0 || r>n-1)
	return 0;
	o= V[r];
	
	int k;
	
	while(k<n-1)  // don mang len
	{
		V[k] = V[k=1];
		k++;
	}
	n--;
	return 1;
}

template<class T>
int Vector<T>::size()
{
	return n;
}

template<class T>
int Vector<T>::isEmpty()
{
	return n==0;	
} 

#endif
