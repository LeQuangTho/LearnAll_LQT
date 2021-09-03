#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define FOR(a,b,i)    for(int i = a; i < b; i ++)
//                    Han
 
struct TrangThai{
	pair<int, int> bo;
	pair<int, int> thuyen;
	pair<int, int> dich;
	bool o_bo;
};
 
void Xuat(TrangThai A)
{
	cout << "bo:\t" << A.bo.first << " " << A.bo.second << endl;
	cout << "thuyen:\t" << A.thuyen.first << " " << A.thuyen.second << endl;
	cout << "dich:\t" << A.dich.first << " " << A.dich.second << endl << endl;
}
 
bool operator==(const TrangThai& t1, const TrangThai& t2)
{
	if(t1.bo == t2.bo && t1.dich == t2.dich && t1.thuyen == t2.thuyen)
		return true;
	return false;
}
 
vector<TrangThai> DaDuyet;
 
bool DanhDau(TrangThai A)
{
	DaDuyet.push_back(A);
}
 
bool Check(TrangThai A)
{
	for(int i = 0; i < DaDuyet.size(); i ++)
		if(A == DaDuyet[i])
			return true;
	return false;
}
 
TrangThai A;
 
int trangthai_thuyen_typhu[] = {1, 1, 0, 2, 0};
int trangthai_thuyen_cuop[]  = {1, 0, 1, 0, 2};
 
void BFS()
{
	queue<TrangThai> Save;
	Save.push(A);
	DanhDau(A);
	Xuat(A);
	int sobuoc = 0;
	while(Save.size())
	{
		int size = Save.size();
 
		while(size --)
		{
			TrangThai now = Save.front();
			Save.pop();
			if(now.o_bo == true)
			{
				now.bo.first += now.thuyen.first;
				now.bo.second += now.thuyen.second;
			}
			else
			{
				now.dich.first += now.thuyen.first;
				now.dich.second += now.thuyen.second;
			}
			now.thuyen = make_pair(0,0);
 
			for(int i = 0; i < 5; i ++)
			{
				TrangThai x = now;
				if(now.o_bo == true)
				{
					if(now.bo.first >= trangthai_thuyen_typhu[i] && now.bo.second >= trangthai_thuyen_cuop[i] && now.bo.first - trangthai_thuyen_typhu[i] >= now.bo.second - trangthai_thuyen_cuop[i])
					{
						x.o_bo = false;
						x.bo = make_pair(x.bo.first - trangthai_thuyen_typhu[i],x.bo.second - trangthai_thuyen_cuop[i]);
						x.thuyen = make_pair(trangthai_thuyen_typhu[i], trangthai_thuyen_cuop[i]);
						if(Check(x) == false)
						{
							Save.push(x);	
							DanhDau(x);
							cout << sobuoc << endl;
							Xuat(x);
						}
 
 
					}
 
				}
				else
				{
					if(now.dich.first >= trangthai_thuyen_typhu[i] && now.dich.second >= trangthai_thuyen_cuop[i] && now.dich.first - trangthai_thuyen_typhu[i] >= now.dich.second - trangthai_thuyen_cuop[i])
					{
						x.o_bo = true;
						x.dich = make_pair(x.dich.first - trangthai_thuyen_typhu[i],x.dich.second - trangthai_thuyen_cuop[i]);
						x.thuyen = make_pair(trangthai_thuyen_typhu[i], trangthai_thuyen_cuop[i]);
						if(Check(x) == false)
						{
							Save.push(x);	
							DanhDau(x);
							cout << sobuoc << endl;
							Xuat(x);
						}
					}
				}
				if(x.bo.first == 0 && x.bo.second == 0)
				{
					cout << sobuoc + 1;
					return ;
				}
			}
		}
		sobuoc ++;
	}
}
 
int main()
{
	cin.tie(0 ); ios::sync_with_stdio(0); cout.tie(0);
	int typhu, cuop;
	cin >> typhu >> cuop;
	A.bo = make_pair(typhu, cuop);
	A.o_bo = true;
	BFS();
}
