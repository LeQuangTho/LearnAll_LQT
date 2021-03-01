//BFS Dong nuoc

#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> TT;   // trang thai;
struct Water{
	int m,n,k;  // n: V can 1, m : V can 2 , k: V can can dong	
	map<TT,TT> d;  //d[{0,5}] = {0,0}   mang cha
	void BFS(){
		queue<TT> Q;
		Q.push({0,0});
		d[{0,0}] = {0,0};
		while(Q.size()){
			TT u= Q.front(); Q.pop();
			int z=u.first+ u.second;
			TT Next[] =
			{
				{0, u.second}, {u.first , 0} ,{n , u.second} , {u.first,m},
				{z<m?0:z-m , z<=m?z:m},   //1->2
				{z<n?z:n, z<n?0:z-n}  // 2->1
			};
			
			for(TT v:Next){
				if(d.find(v)== d.end())  //chua co
				{
					d[v]=u;
					Q.push(v);
					if(v.first == k || v.second == k){
						inkq(v);
						return;
					}
				}
			}
			
		}
		cout<<"khong dong duoc nuoc";
	}
	
	void sol(){
		cout<<"Nhap n,m,k: "; cin>>n>>m>>k;
		BFS();
	}
	
	void inkq(TT f){
		if( f==make_pair(0,0)) cout<<"{0,0}";
		else{
			inkq(d[f]); cout<<"->{"<<f.first<<","<<f.second<<"}";
		}
		
	
	}
};

int main()
{
	Water Q;
	Q.sol();
}

