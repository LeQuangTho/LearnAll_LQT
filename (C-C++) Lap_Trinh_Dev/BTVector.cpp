#include <bits/stdc++.h>
using namespace std;
int min(int a, int b){
	return (a<b)?a:b;
}
class Vector{
private:
	int n;
	double *tp;
public:
	Vector();
	Vector(int &n);
	~Vector();
	friend std::ostream &operator <<(std::ostream &out, const Vector &v);
	friend std::istream &operator >>(std::istream &in, Vector &v);
	Vector operator +(const Vector &v1);
	double operator *(Vector &v1);
	friend Vector nhan(const double k, Vector &v);
//	Vector operator =(Vector &v);
};
Vector::Vector(){
	n=0;
	tp=new double;
}
Vector::Vector(int &n){
	this->n=n;
	tp = new double[n];
}
Vector::~Vector(){
	delete [] tp;
}
std::ostream &operator <<(std::ostream &out, const Vector &v){
	for (int i=0; i<v.n; i++){
		out << v.tp[i] << " ";
	}
	return out;
}
std::istream &operator >>(std::istream &in, Vector &v){
	std::cout << "Nhap so chieu: ";
	in >> v.n;
	v.tp= new double[v.n];
	for (int i=0; i<v.n; i++){
		std::cout << "v[" << i << "]=";
		in >> v.tp[i];
	}
	
	return in;
}
//Vector Vector::operator =(Vector &v){
//	std::swap(*this,v);
//	return *this;
//}
Vector Vector::operator+(const Vector &v1){
	if (v1.n>n){
		for (int i=0; i<n; i++)
			v1.tp[i]+=tp[i];
		return v1;		
	}else{
		Vector tmp(n);
		for (int i=0; i<n; i++)
			tmp.tp[i]=tp[i];
		for (int i=0; i<v1.n; i++)
			tmp.tp[i]+=v1.tp[i];
		return tmp;
	}
}
double Vector::operator *(Vector &v1){
	double res=0;
	int mi=min(v1.n,n);
	for (int i=0; i<mi;i++)
		res+=v1.tp[i]*tp[i];
	return res;
}
Vector nhan(const double k,Vector &v){
	for (int i=0; i<v.n; i++)
		v.tp[i]=k*v.tp[i];
	return v;
}
int main(){
	Vector u1,u2,u3,u4;
	double k;
	std:: cout << "Nhap k="; std::cin>>k;
	std::cin >> u1;
	std::cin >> u2;
	std::cin >> u3;
	std::cin >> u4;
	Vector res;
	res=nhan(k,u1)+nhan(k,u2)+nhan(k,u3)+nhan(k,u4);
	std::cout << "Res=" << res << std::endl;
	double res2=u1*u2+u1*u3+u1*u4;
	std::cout << "Res2=" << res2 << std::endl;
}
