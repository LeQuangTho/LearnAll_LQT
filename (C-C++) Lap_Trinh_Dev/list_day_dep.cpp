#include <bits/stdc++.h>
using namespace std;
class GIAYDEPNU{
private:
	string ma;
	string hsx;
	string cl;
	double dc;
	int ms;
public:
	GIAYDEPNU();
	friend istream &operator >>(istream &, GIAYDEPNU &);
	friend ostream &operator <<(ostream &, const GIAYDEPNU &);
	double getDc();
	friend int getMs(const GIAYDEPNU&);
	bool search(const double&, const int&);
};
GIAYDEPNU::GIAYDEPNU(){
	ma="";
	hsx="";
	cl="";
	dc=0;
	ms=0;
}
istream &operator >>(istream &in, GIAYDEPNU &gdn){
	cout << "Nhap ma giay: ";
	fflush(stdin);
	getline(in,gdn.ma);
	cout <<"\nNhap hang san xuat: ";
	fflush(stdin);
	getline(in,gdn.hsx);
	cout << "\nNhap chat lieu: ";
	fflush(stdin);
	getline(in,gdn.cl);
	cout << "\nNhap do cao";
	in >> gdn.dc;
	cout << "\nNhap loai mau sac";
	in >> gdn.ms;
	return in;
}
ostream &operator <<(ostream &out, const GIAYDEPNU &gdn){
	out << "Ma giay: " << gdn.ma << ", hang san xuat: " << gdn.hsx << ",chat lieu: "<< gdn.cl << ",do cao: " << gdn.dc << ",mau sac: " << gdn.ms << endl;
	return out;
}
double GIAYDEPNU::getDc(){
	return dc;
}
int getMs(const GIAYDEPNU &gdn){
	return gdn.ms;
}
bool GIAYDEPNU::search(const double &d, const int &m){
	return (d==dc&&m==ms);
}
class LISTGIAYDEPNU{
private:
	GIAYDEPNU *list;
	int numb;
public:
	LISTGIAYDEPNU();
	LISTGIAYDEPNU(int n);
	~LISTGIAYDEPNU();
	friend istream &operator >>(istream &, LISTGIAYDEPNU &);
	friend ostream &operator <<(ostream &, const LISTGIAYDEPNU &);
	void searchList(const double &, const int &);
};
LISTGIAYDEPNU::LISTGIAYDEPNU(){
	list=NULL;
	numb=0;
}
LISTGIAYDEPNU::LISTGIAYDEPNU(int n){
	numb=n;
	list = new GIAYDEPNU[numb];
}
LISTGIAYDEPNU::~LISTGIAYDEPNU(){
	delete [] list;
	numb=0;
}
istream &operator >>(istream &in, LISTGIAYDEPNU &lgdn){
	cout << "Nhap so giay dep nu: ";
	in >> lgdn.numb;
	lgdn.list = new GIAYDEPNU[lgdn.numb];
	for (int i=0; i<lgdn.numb; i++){
		cout << "Nhap giay thu " << i+1 << endl;
		in >> lgdn.list[i];
	}
	return in;
}
void LISTGIAYDEPNU::searchList(const double &dc, const int &ms){
	for (int i=0; i<numb; i++)
		if (list[i].search(dc,ms)){
			cout << "Tim thay: " << list[i] << endl;
		}
}
int main(){
	LISTGIAYDEPNU list;
	cin >> list;
	list.searchList(1,2);
}
