#include<bits/stdc++.h>

using namespace std;

class QLH{
	string ID,name,made;
	int Species,Amount;   //1,2,3    Species: loai   Amount: So luong
	public:
		void nhap();
		void xuat();
		string getName(){
			return name;
		}
		
		int getSpecies(){
			return Species;
		}
};

void QLH::nhap(){
	cout<<"\nID: "; fflush(stdin); getline(cin,ID);
	cout<<"\nname: "; fflush(stdin); getline(cin,name);
	cout<<"\nmade: "; fflush(stdin); getline(cin,made);
	cout<<"\nSpecies: "; cin>>Species;
	cout<<"\nAmount: "; cin>>Amount;
}

void QLH::xuat(){
	cout<<"\nID: "; cout<<ID;
	cout<<"\nname: "; cout<<name;
	cout<<"\nmade: "; cout<<made;
	cout<<"\nSpecies: "; cout<<Species;
	cout<<"\nAmount: "; cout<<Amount;
}

class DT: public QLH{  // DT : Dien tu
	int time;
	public:
		void nhap();
		void xuat();
		int getTime(){
			return time;
		}
};

void DT::nhap(){
	QLH::nhap();
	cout<<"\nNhap thoi gian bao hanh: ";
	cin>>time;	
}

void DT::xuat(){
	QLH::xuat();
	cout<<"\nThoi gian BH: "<<time;
}
int main()
{
	DT *a;
	int n;
	string Find;
	cout<<"\nNhap so luong hang: "; cin>> n;
	a= new DT[n+1];
	
	for(int i=0;i<n;i++){
		a[i].nhap();
		system("cls");
	}
	
	for(int i = 1; i<=3; i++){
		cout<<"\nHang loai "<<i<<"co thoi gian BH>12thang la:\n";
		for (int j=0; j<n;j++)
		if(a[j].getSpecies()== i && a[j].getTime() >= 12){
			a[j].xuat();
		}
	}
	
	cout<<"\nNhap ten can tiem kiem: "; fflush(stdin); getline(cin,Find);
	int k=0;
	for(int i=0;i<n;i++){
		if (Find==a[i].getName()) a[i].xuat(); 
		else k++;
	}
	
	if(k==n) cout<<"khong tim thay!";
	delete[] a;
}

