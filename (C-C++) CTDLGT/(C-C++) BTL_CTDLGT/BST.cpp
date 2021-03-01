#include <iostream>
#include <fstream>

using namespace std;
int main ()
{
    int a, c;
    string b;
    ifstream doc;
    doc.open("nhap.txt");
    doc >> a;
    doc >> c;
    getline (doc,b) ;
    doc.close();
    cout << a <<endl<< b << endl<< c << endl; 
    // ghi vào file a.txt
    ofstream ghi;
    ghi.open("xuat.txt");
    ghi << a+1<< endl;
    ghi << b << endl;
    ghi << c +1<< endl;
    ghi.close();
}
