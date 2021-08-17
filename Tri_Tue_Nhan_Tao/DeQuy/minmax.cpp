#include <bits/stdc++.h>
using namespace std;

void minmax(int a, int b, int c, int &max, int &min) {
	max = a>b?a:b;
	max = max>c?max:c;
	min = a<b?a:b;
	min = min<c?min:c;
} 
int MaxMin(int a, int b, int c, bool ismax = true) {
	int max = a>b?a:b;
	max = max>c?max:c;
	int min = a<b?a:b;
	min = min<c?min:c;
	return ismax?max:min;	
}
int main()
{
	int min, max;
	minmax(8, 5, 6, max, min);
	cout<<"Max: "<<max<<"\nMin: "<<min;	
	cout<<"\nSo khong phai max min:"<<(8+6+7)-MaxMin(8,6,7)-MaxMin(8,6,7, false);
}
