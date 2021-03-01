#include<bits/stdc++.h>

using namespace std;

struct zero{
	int s,f;
	map<int,pair<int,int>> d; // d[22]= {30,3} , d[10] ={12,3}
	void induong(int f){
		if(s==f){cout<<s; retu rn;
		induong(d[f].first);
		cout<<"("<< d[f].second<<","<<d[f].first/d[f].second<<")->"<<f;
		}
	}
	
	void BFS(){
			queue<int> Q;
			Q.push(s);
		while(Q.size()){
			int u = Q.front();
			Q.pop();
			for(int a=1;a*a<=u;a++)
				if(u%a ==0 ){
				int v=(a-1)*(u/a+1);
				if (v>=f && d.find(v)==d.end()){
					d[v]={u,a};
					Q.push(v);
					if(v == f) {
						induong(f); return;
					}
				}
				}
	}
		cout<<"khong di duoc dau em";
	}
	
	void sol(){
		cout<<"Nhap s va f: "; cin>>s>>f;
		BFS();
	}
};

int main()
{
	zero Q;
	Q.sol();
}

