#include <bits/stdc++.h>
using namespace std;
std::vector<std::string> countChar(std::string s)
{
    map<char, int> mp;
    vector<string> v;
    //dung 
    for (auto x : s)
    {
    	//duyet qua tung ki tu trong chuoi, map co kieu key-value, nen o dong duoi, mp[x] co nghia la so luong chu cai do (x) trong chuoi
        mp[x]++;
        //vd: s = "abccbac" thi mp[a] = 2, mp[b]=2, map[c]=3
    }
    for (auto x : mp)
    {
    	//doan nay co nghia la duyet qua mp, doi các cap key value trong map thanh string roi push vao v
        string ans = " ";
        ans =  x.first + ans + to_string(x.second);
        v.push_back(ans);
    }
    return v;
}
int main()
{
	vector<string> v = countChar("abccbac");
	for(auto c : v) {
		cout<<c<<"\n";
	}
}

