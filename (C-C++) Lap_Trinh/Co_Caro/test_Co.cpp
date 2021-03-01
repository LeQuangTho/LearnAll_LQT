#include<stdio.h>

int main()
{ 
char quan='x';
        for(int i=1;i<15;i++)
    	for (int j=1;j<15;j++)
    	{
    		scanf("%[^\n]",a[i][j]); 
		}
    for(int i=1;i<15;i++)
    {
    	for (int j=1;j<15;j++)
    	{
    		if(a[i][j]==a[i][j+1]&&a[i][j+1]==a[i][j+2]) //hang ngang
			{
				if(a[i][j+3]='-') a[i][j+3]=quan;
				else if(a[i][j-1]='-') a[i][j-1]=quan;
			}
			else if(a[i][j]==a[i+1][j+1]&&a[i+1][j+1]==a[i+2][j+2]) //duong cheo chinh
			{
				if(a[i+3][j+3]='-') a[i+3][j+3]=quan;
				else if(a[i-1][j-1]='-') a[i-1][j-1]=quan;
			}
			else if(a[i][j]==a[i+1][j]&&a[i+1][j]==a[i+2][j]) //cot thang
			{
				if(a[i+3][j]='-') a[i+3][j]=quan;
				else if(a[i-1][j]='-') a[i-1][j]=quan;
			}
			else if(a[i][j]==a[i-1][j-1]&&a[i-1][j-1]==a[i-2][j-2]) //duong cheo phu
			{
				if(a[i+2][j-2]='-') a[i+2][j-2]=quan;
				else if(a[i-1][j+1]='-') a[i-1][j+1]=quan;
			}
		    else if(a[i][j]==a[i+1][j+1]&&a[i+3][j+3]==a[i+4][j+4])//cot cheo chinh rong
		    {
		    	a[i+2][j+2]=quan;
			}
			else if(a[i][j]==a[i-1][j-1]&&a[i-3][j-3]==a[i-4][j-4])//cot cheo phu rong
			{
				a[i-2][j-2]=quan;
			}
			}
		}
	
	for(int i=1;i<15;i++)
    	for (int j=1;j<15;j++)
    	{
    		printf("%c ",a[i][j]);
		}
}

