#include<bits/stdc++.h>

using namespace std;

class Student{
	string name;
	double point;
	public:
		void nhap();
		void xuat();
		double getDiem(){
			return point;
		}
};	

void Student::nhap(){
	cout<<"\nName: "; fflush(stdin); getline(cin,name);
	do{
		cout<<"\npoint: "; 
		cin>>point;
	}while(point<0&& point>10);
}

void Student::xuat(){
	cout<<"\nName: "<<name;
	cout<<"\npoint: "<<point; 
}

class Olympic : public Student{
	char School;
	public:
		void nhap();
		void xuat();
		char getSchool(){
			return School;
		}
};

void Olympic::nhap(){
	Student::nhap();
	cout<<"\nSchool: "; cin>>School;
}

void Olympic::xuat(){
	Student::xuat();
	cout<<"\nSchool: "<<School;
}
int main()
{
	Olympic *a;
	double A=0,B=0,C=0;
	int n;
	cout<<"Nhap so luong thi sinh: "; cin>>n;
	a= new Olympic[n+1];
	
	for(int i=0; i<n;i++){
		cout<<"\nThong tin thi sinh "<<i+1<<": ";
		a[i].nhap();
		system("cls");
	}
	
	for(int i=0;i<n;i++){
		if(a[i].getSchool()=='A') A+=a[i].getDiem();
		else if(a[i].getSchool()=='B') B+=a[i].getDiem();
		else if(a[i].getSchool()=='C') C+=a[i].getDiem();
	}
	
	double max=A;
		if(B>max) max =  B;
		else if (C>max) max = C;
		
		cout<<"\nTong diem cao nhat:"<<max;
		if (max==A) cout<<" Truong A";
		else if (max==B) cout<<" Truong B";
		else cout<<" Truong C";
		
		getchar();
		getchar();
		
	    system("cls");
	
	cout<<"\nDanh sach sinh vien tham du!\n";
	for(int i=1; i<n;i++){
		cout<<"\nThong tin thi sinh "<<i<<": ";
		a[i].xuat();
	}
	delete[] a;
}

