#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define FOR(a,b,i)    for(int i = a; i < b; i ++)
//                    Han

struct TrangThai{
    int ty_phu;
    int cuop;
    bool trang_thai;
};

void Xuat(TrangThai A)
{
	cout << "[" << A.ty_phu << ", " << A.cuop<< ", " << A.trang_thai<<"]"<<endl;
	
}

bool operator==(const TrangThai& t1, const TrangThai& t2)
{
	if(t1.ty_phu == t2.ty_phu && t1.cuop == t2.cuop && t1.trang_thai == t2.trang_thai)
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
int trangthai_thuyen_typhu[] = {0, 1, 1, 2, 0};
int trangthai_thuyen_cuop[]  = {1, 0, 1, 0, 2};
void BFS()
{
	stack<TrangThai> Save;
	Save.push(A);
	DanhDau(A);
	Xuat(A);
	int sobuoc = 1;
	int sobuocve = 1;
	while(Save.size())
	{
		int size = Save.size();
		
		while(size --)
		{
			TrangThai now = Save.top();
			Save.pop();
			for(int i = 0; i < 5; i ++)
			{
				TrangThai x = now;
				if(now.trang_thai == true)
				{
				    if( x.ty_phu>=trangthai_thuyen_typhu[i] && x.cuop>=trangthai_thuyen_cuop[i]) {
    				    x.trang_thai = false;        				    
    				    x.ty_phu = x.ty_phu-trangthai_thuyen_typhu[i];
    				    x.cuop = x.cuop-trangthai_thuyen_cuop[i];
    				    if(x.ty_phu >= x.cuop &&Check(x) == false) {
        				    Save.push(x);	
            				DanhDau(x);
            				Xuat(x);
            				cout<< sobuoc << endl;
            				cout << "\n-----------------------------\n";
    				    }
				    }

				}
				else
				{
				    if(x.ty_phu+trangthai_thuyen_typhu[i] <=3 && x.cuop+trangthai_thuyen_cuop[i]<=3) {
    				    x.trang_thai = true;        				    
    				    x.ty_phu = x.ty_phu+trangthai_thuyen_typhu[i];
    				    x.cuop = x.cuop+trangthai_thuyen_cuop[i];
    				    if(x.ty_phu >= x.cuop &&Check(x) == false) {
        				    Save.push(x);	
            				DanhDau(x);
            				Xuat(x);
            				cout<< sobuoc << endl;
            				cout << "\n-----------------------------\n";
    				    }
				    }
				}
				if(x.ty_phu == 0 && x.cuop == 0)
				{
					cout << sobuoc;
					return ;
				}
			}
		}
		sobuoc ++;
	}
}

int main()
{
	cin.tie(0); ios::sync_with_stdio(0); cout.tie(0);
	int typhu, cuop;
	cin >> typhu >> cuop;
	A.ty_phu = typhu;
	A.cuop = cuop;
	A.trang_thai = true;
	BFS();
}
