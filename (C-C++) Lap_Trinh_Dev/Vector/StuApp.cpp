#include"conio.h"
#include"stdio.h"
#include"iostream"
#include"VItr.cpp"
#include"Student.cpp"

using namespace std;

class VectorApp
{
	private:
		 Vector<Student> v;
	public:
		int menu();
		void run();
		void GetElement();
		void InsertElement();
		void RemoveElement();
		void ReplaceElement();
		void ListElement();
};

int VectorApp::menu()
{
	cout<<"1.Them sinh vien moi.";
	cout<<"\n2.Xoa sinh vien.";
	cout<<"\n3.Thay the sinh vien.";
	cout<<"\n4.Thong tin sinh vien.";
	cout<<"\n5.Danh sach tat ca cac sinh vien.";
	cout<<"\n6.Ket thuc chuong trinh";
	cout<<"\nChon chuc nang tu 1..6: ";
	int n;
	cin>>n; 
	return n;
}

void VectorApp::run()
{
	int ch;
	do{
		system("cls"); // xoa man hinh
		ch = menu();
		system("cls");
		switch(ch){
			case 1:
				InsertElement();
				break;
			case 2:
				RemoveElement();
				break;
			case 3:
				ReplaceElement();
				break;
			case 4:
				GetElement();
				break;
			case 5:
				ListElement();
				break;
		}
		getch();
	}while(ch!=6);
}

void VectorApp::InsertElement(){
	Student x;
	int r;
	cout<<"Enter student infomation: ";
	cin>>x;
	cout <<"Insert position: ";
	cin>>r;
	if (v.insertAtRank(r,x)==1)
		cout<<"Ok!";
		else 
			cout<<"Erro! \nCan't Insert !";
}

void VectorApp::RemoveElement(){
	Student x;
	int r;
	cout<<"Remove position: "; cin>>r;
	if(	v.removeAtRank(r,x) == 1) cout<<"Ok !";
	else cout<<"erro! Can't remove";
}

void VectorApp::ReplaceElement(){
	Student x;
	int r;
	cout<<"Replacement position: "; cin>>r;
	cout<<"Enter student infomation: "; cin>>x;
	if(v.replaceAtRank(r,x)==1) cout<<"Ok !";
	else cout<<"Can't replace";
}

void VectorApp::GetElement(){
	int r;
	Student x;
	cout<<"Search position: "; cin>>r;
	if(v.getAtRank(r,x)==1) cout<<x;
	else cout<<"erro! Can't search!";
}

void VectorApp::ListElement(){
	VectorItr<Student> Itr(&v);
	cout<<"List students:\n";
	while(Itr.hasNext()) cout<<Itr.next()<<"\n";
}
