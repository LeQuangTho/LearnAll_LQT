#include<stdio.h>
int main()
{
    int a,b,m[100],d=0;
    scanf("%i %i",&a,&b);
    for ( int j= 1; j<=b; j++)
        scanf("%i",&m[j]);
    for (int i= 1; i<b; i++)
    {
        if (m[i+1]<=m[i]) d+=0;
        else if (m[i+1]-m[i]<=a) d+=0;
        else {
		d+=1;
		printf("%d %d\n",m[i],m[i+1]);
	}
    }
    if (d!=0) printf("GAME OVER");
    else printf("YOU WIN");
}

