#include <windows.h>
#include <iostream>
//setColor zFull.net
using namespace std;
int main() {
    HANDLE abc;
    abc = GetStdHandle(STD_OUTPUT_HANDLE);
    //for(int k=0;k<=255;k++) {
        SetConsoleTextAttribute(abc, 100);
        cout << 0 << " - Change color!  ";
       // if (3%3==0) cout << endl;
    //}
    return 0;
}
