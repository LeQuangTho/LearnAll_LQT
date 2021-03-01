#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <conio.h>
int n, i;
float s=0, kq=0;
int main()
{
    printf("nhap gia tri cua n:   ");
    scanf("%d", &n);
    for (i=n; i>=1; i--) {
            s=sqrt(i+kq);
            kq=s;
    }
    printf("dap so la:  %f", s);
    getch();
    return 0;
}
