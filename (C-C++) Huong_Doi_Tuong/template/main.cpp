#include <bits/stdc++.h>

using namespace std;

template <class T>
class Vector
{
    private:
        int N;
        T *V;
        int n;
    public:
        Vector();
        ~Vector();
        int getAtRank(int r,T &o);
        int replaceAtRank(int r,T &o);
        int insertAtRank(int r,T o);
        int removeAtRank(int r,T &o);
        int size();
        int isEmpty();
};
int Vector::getAtRank(int r,T &o)
{
    return o[r];
}
int Vector::replaceAtRank(int r,T& o)
{
    int n;
    cin>>n;
    o[r]=n;
    return n;
}
int Vector::insertAtRank(int r, T o)
{

}
int main()
{

}
