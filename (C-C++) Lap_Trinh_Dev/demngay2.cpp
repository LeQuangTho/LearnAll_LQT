#include <stdio.h>

int main()
{
	int d,d1,m,m1,y,y1, dem = 0;
	int A[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	int B[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	scanf("%d%d%d", &d,&m,&y);
	scanf("%d%d%d", &d1, &m1, &y1);
	if(y%400 == 0 || (y%4 == 0) && (y%100))
		A[2]++;
	if(y1%400 == 0 || (y1%4 == 0) && (y1%100))
		B[2]++;
	if(y1 - y == 0)
	{
		if(m != m1)
			{
				for(int i = m + 1; i < m1; i++)
				{
					dem += A[i];
				}
			dem += A[m] - d + d1;
			}
		else{
			dem += d1 - d;
		}
	}
	else 
	{
			 for(int i = m + 1; i <= 12; i ++)
			{
				dem += A[i];
			}
			for(int i = 1; i < m1; i++)
			{
				dem += B[i];
			} 
			dem += A[m] - d - d1;
			for(int i = y + 1; i < y1 ; i ++)
			{
				dem += 365;
				if(i%400 == 0 || (i%4 == 0) && (i%100))
					dem ++;
			}
	}
	printf("%d", dem);
	
}
