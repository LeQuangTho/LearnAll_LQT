#include <iostream>

using namespace std;

typedef struct{
	int bac;
	int *hs;
}DT;
istream &operator>>(istream &inp, DT &P)
{
    do
    {
        cout<<"nhap bac cua da thu: "; inp>>P.bac;
    }while(P.bac<0);
    P.hs=new int(P.bac);
    for (int i=1;i<=P.bac; i++)
    {
        cout<<"nhap he so thu"<<i;
        cin>>P.hs[i];
    }
    return inp;
}
ostream &operator<<(ostream &out, DT &P)
{
    out<<"Bac cua da thuc"<<P.bac;
    out<<"\n Cac he so";
    for(int i=1;i<=P.bac;i++)
    {
        out<<P.hs[i]<<"  ";
    }
    return out;
}
DT operator +(DT &P, DT &Q)
{
    DT R;
    R.bac =(P.bac> Q.bac)?P.bac:Q.bac;
    int min =(P.bac< Q.bac)?P.bac:Q.bac;
    R.hs =new int [R.bac];
    if (P.bac==Q.bac)
    for(int i=1;i<=R.bac;i++)
    {
        R.hs[i]=P.hs[i]+Q.hs[i];
	}
	  else  for(int i=min;i<=R.bac;i++)
	    {
	        R.hs[i]=P.hs[i]+Q.hs[i];
	        if (R.bac==min) R.hs[i]=P.hs[i];
	        else R.hs[i]=Q.hs[i];
	    }
    return R;

}
int main()
{
    DT a,b,c;
    int S1,S2;
    cout<<"nhap da thuc thu nhat";
    cin>>a>>b;
    cout<<a;
    c=a+b;
    cout<<c;
    return 0;
}

