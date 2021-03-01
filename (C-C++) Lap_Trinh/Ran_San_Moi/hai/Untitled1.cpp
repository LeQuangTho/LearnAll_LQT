#include <bits/stdc++.h>
using namespace std;
int main()
{
	int a,b,c;
 cout<<"nhap canh vao ho cai ";cin>>a>>b>>c;
   if(a==b&&b==c)
{
	cout<<"tg can";
}
else if(a==b||b==c||a==c)
{
	cout<<"tg can";
}
else
{
	cout<<"ko phai can dau";
}

   return 0;
}


