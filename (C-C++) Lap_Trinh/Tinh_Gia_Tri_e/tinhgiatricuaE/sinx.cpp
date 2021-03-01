#include <stdio.h>
#include <conio.h>
#include<math.h>
int tinhgiaithua(int n)
/*{
	int giai_thua = 1;
	for (int i = 1; i <= n + 1; i++)
	{
		giai_thua = giai_thua * i;
	}
	return giai_thua;*/
}
void main()
{
	int n, x;
	double  s = 0;
	printf("Nhap n "); scanf_s("%d", &n);
	printf("Nhap x "); scanf_s("%d", &x);
	for (int i = 0; i <= n; i++)
	{
		s = s + pow(-1, i)*pow(x, 2 * i + 1) / (tinhgiaithua(2 * i + 1));
	}
	printf("Sin(%d)= %f", x, s);
	_getch();
}