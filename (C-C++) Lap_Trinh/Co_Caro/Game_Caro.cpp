#include <bits/stdc++.h>
#include <windows.h>
#include <iostream>
#include<conio.h>
using namespace std;
void chon_luot(char *p,char *q)
{
	printf("Moi ban chon quan x/o !!\n Nguoi choi so 1:");//chon luot 
	gets(p);
	if(*p=='x') *q='o';
	else *q='x'; 
}
void tro_toi(int x, int y) {
	COORD con_tro;
	con_tro.X = x;
	con_tro.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), con_tro);
}
void khung()
{
	for(int i=1;i<=15;i++)
	{
		tro_toi(i+5,5);
		HANDLE abc;
        abc = GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(abc, 20);
		printf("%c",char(178));
		tro_toi(6,i+5);
		printf("%c%c",char(178),char(178));
		
	}
	//for(int j=1;i<=15;j++)
}
int main()
{
     char luot1, luot2;
//   FILE *f,*p;
//   f=fopen("map.txt","rt");
//   p=fopen("map.txt","wt");
   khung();
   chon_luot(&luot1,&luot2);
   getch();
}


