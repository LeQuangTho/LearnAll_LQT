#include <bits/stdc++.h>
using namespace std;
int const k = 1e4;
//long long fibo (int n)
//{
//	 return n<2?1:(fibo(n-1)+fibo(n-2));
//}


//dùng map nhu tu diem luu cac so fibonaci
//map<int, long long> F;
//long long fibo(int n) {
//	if (F.find(n) != F.end()) return F[n];
//	if(n<2) return F[n] = 1;
//	return F[n] = fibo(n-1)+fibo(n-2);
//}



//void fibo(int n, long long &a, long long &b) {
//	if(n==1) a = b  =1;
//	else {
//		fibo(n-1, a, b);
//		b = a+b;
//		a = b-a;
//	}
//}
pair<long long, long long> fibo(int n) {
	if(n==1) return {1, 1};
	pair<long long, long long> t= fibo(n-1);
	return {t.second, t.first+t.second};
}
int main()
{	
	pair<long long, long long> p=fibo(40);
	cout<<p.second;

//	long long a, b;
//	fibo(40, a, b);
//	cout<<b;

//	map<int, string> M {{243, "Ha noi"},  {12, "Thai Binh"}, {-12, "Ha Tay"}};
//	int ma;
//	cin>>ma;
//	if(M.find(ma)==M.end()) cout<<"Khong thay";
//	else cout<<M[ma];


//	map<char, int> F;
//	string x;
//	getline(cin, x);
//	for(char t:x) F[t]++;
//	for(auto f:F) cout<<"\n Ky tu "<<f.first<< " co tan suat"<< f.second;
}
