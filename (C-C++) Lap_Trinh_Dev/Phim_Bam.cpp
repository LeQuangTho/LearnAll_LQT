#include <stdio.h>
#include <conio.h>
int main(){
    while(true){
        char c = getch();
        if(c == -32){
            c = getch();
            if(c == 72){
                printf("len\n");
            }
            if(c == 80){
                printf("xuong\n");
            }
            if(c == 75){
                printf("trai\n");
            }
            if(c == 77){
                printf("phai\n");
            }
            if(c == 27) break;
        }
    }
}
