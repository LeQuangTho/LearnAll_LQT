#include <bits/stdc++.h>
using namespace std;

string removeKdigits(string num, int k) {
	   vector<char> stack;
	   for (int i = 0; i < num.size(); i++) {
		   while (stack.size() && k && num[i] > stack.back()) {
			   stack.pop_back();
			   k--;
		   }
		   stack.push_back(num[i]);
	   }

	   while (stack.size() && k) {
		   k--;
		   stack.pop_back();
	   }

	   string s(stack.begin(), stack.end());
	   int i = 0;
	   while (s[i] == '0') i++;
	   return i == s.size() ? "0" : s.substr(i);
   }

int main(){
	string s;
	cin >> s;
	int t;
	cin >>t;
	while (t--){
		string restore = s;
		int k;	
		cin >> k;	
		cout << removeKdigits(s, k) << "\n";
	}
}
