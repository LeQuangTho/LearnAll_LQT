#include<stdio.h>
#include <limits.h>

int main()
{
	int n, m;
	scanf("%d%d", &m, &n);
	float a[100][100];
	for (int i = 0; i < m ; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			scanf("%f", &a[i][j]);
		}
	}
	
	
	int t;
	float Max = INT_MIN, s;
	for (int j = 0; j < n; ++j)
	{
		s = 1;
		for (int i = 0; i < m ; ++i)
		{
			s *= a[i][j];
		}
		printf("Tich cua cot thu %d la: %.2f\n", j, s);
		if (Max < s)
		{
			Max = s;
			t = j;
		}
	}
	printf("Cot co tich lon nhat la: %d", t);
}

