//xet xem 4 so nhap vao co la mot cap so cong hay ko
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int a,b,c,d;
int main()
{
    printf("nhap lan luot cac 4 so ngau nhien theo thu be--> lon\n");
    scanf("%d%d%d%d", &a ,&b , &c , &d);
    if ( c==2*b-a && d=2*c-b) printf("4 so tren tạo thanh 1 cap so cong");
    else  printf("4 so tren ko tao thanh cap so cong");
    getch();
    return 0;
}
