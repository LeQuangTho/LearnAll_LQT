
#include "windows.h"
#include "stdio.h"
#include "conio.h"
class DQQS{
private:
	int ary[2][2];
	bool z;
	int q;
	int n;
public:
	DQQS(){
		for(int i = 0;i < 2;i++)
			for(int j = 0;j < 2;j++)
				ary[i][j]= i*3;
		z = 1;
		q = 0;
		n = 0;
	}
	void Nhap(int &q,int &n,char	*Temp[2],int z){
		printf("--------- %s -------",Temp[z]);
		printf("\nSo quy: ");
		scanf("%d",&q);
		printf("So nguoi: ");
		scanf("%d",&n);
	}
	bool Try(int ary[2][2],int z,int q,int n){
		if(ary[z][0] - q < 0 || ary[z][1] - n < 0)
			return false;
		return true;
	}
	void DuaNguoiQuy(){
		char	*Temp[]={"Ve","Di"};
		while(ary[1][0] > 0 || ary[1][1] > 0){
			Nhap(q,n,Temp,z);
			if(Try(ary,z,q,n)){
				if( q + n <= 2 && q + n > 0){
					ary[z][0] -=q; 
					ary[z][1] -=n;
					z = !z; 
					ary[z][0] +=q;
					ary[z][1] +=n;
					if(ary[z][0] > ary[z][1] && ary[z][1] > 0){
						printf("Nguoi Bi An Thit Do Bo %d Co Quy = %d > Nguoi = %d\n",z + 1,ary[z][0],ary[z][1]);
						break;
					}
					else{
						printf("Bo 1: x1 = %d - y1 = %d\n",ary[1][0],ary[1][1]);
						printf("Bo 2: x2 = %d - y2 = %d\n",ary[0][0],ary[0][1]);
					}
				}
			}
		}
		if(ary[1][0] == 0 && ary[1][1] == 0)
			printf("Win !!!");
	}
};
void main(){
	DQQS	g;
	g.DuaNguoiQuy();
	getch();
}