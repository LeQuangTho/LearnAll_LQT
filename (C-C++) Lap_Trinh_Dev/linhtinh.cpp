#include<bits/stdc++.h>
using namespace std;
class Computer{
	string code,brand,material;
	double time,price;
	public:
		Computer();
		void input();
		void output();
		double getPrice();
		friend double getTime(Computer& c);
};
Computer::Computer(){
	code = "";
	brand = "";
	material = "";
}
void Computer::input(){
	cout<<"\nEnter code: ";getline(cin,code);
	cout<<"\nEnter brand: "; getline(cin,brand);
	cout<<"\nEnter material: ";getline(cin,material);
	cout<<"\nEnter time: "; cin>>time;
	cout<<"\nEnter price: "; cin>>price;
	fflush(stdin);
}
void Computer::output(){
	cout<<"\nCode: "<<code;
	cout<<"\nBrand: "<<brand;
	cout<<"\nMaterial: "<<material;
	cout<<"\nTime: "<<time;
	cout<<"\nPrice: "<<price;
}
double Computer::getPrice(){
	return price;
}
double getTime(Computer& c){
	return c.time;
}
class ListComputer{
	int n;
	Computer *c;
	public:
		ListComputer(){
			n = 0;
			c = NULL;
		}
		void inputListComputer();
		void findComputer(double price,double time);
};
void ListComputer::inputListComputer(){
	cout<<"\nEnter amout of computer: ";cin>>n;
	fflush(stdin);
	this->c = new Computer[n];
	for (int i = 0 ;i<n;i++){
		cout<<"\nEnter the information of the "<<i+1<<"th computer: ";
		this->c[i].input();
	}
}
void ListComputer::findComputer(double price,double time){
	for (int i = 0 ;i<n;i++){
		if (c[i].getPrice()==price&&getTime(c[i])==time){
			cout<<"\nFound!!";
			c[i].output();
		}
	}
}
int main(){
	ListComputer LC;
	LC.inputListComputer();
	double pr,ti;
	cout<<"Nhap di: ";
	cin>>pr>>ti;
	LC.findComputer(pr,ti);
}
