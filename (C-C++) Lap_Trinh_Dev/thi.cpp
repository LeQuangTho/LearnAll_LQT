#include<bits/stdc++.h>

using namespace std;

class day{
	int n;
	float *a;
	public:
		day(const int k=1){
			n=k;
			a=new float[n+1];
		}
		~day(){
			delete[] a;
		}
		void nhap()
		{
			for(int i=0;i<n;i++)
			{
				cout<<"\nnhap phan tu"<<i+1; cin>>a[i];
			}
		}
		float max()
		{
			float k=a[0];
			for(int i=1;i<n;i++)
			{
				if(a[i]>k) k=a[i];
			}
			return k;
		}
		float operator-(const float& c)
		{
			return -c;
		}
		float operator+(const float& c){
			return +c;
		}
		float TBC(){
			float s=0;
			for(int i=0;i<n;i++)
			{
				s+=a[i];
			}
			return s/n;
		}
//		 float operator/(const float c=1){
//			return /c;
//		}
};
int main(){
	day a(3);
	nhap();
	nhap(b);
	
}

