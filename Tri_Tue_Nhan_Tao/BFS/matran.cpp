#include <bits/stdc++.h>
using namespace std;

int main()
{

   int i, j, mat[10][10], row, col;

   printf("\nNhap so hang cua ma tran: ");
   scanf("%d", &row);
   col = row;

   //Nhap cac phan tu cua ma tran m x n
   printf("\nNhap ma tran: \n");
   for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
         printf("\nNhap phan tu a[%d][%d] : ", i, j);
         scanf("%d", &mat[i][j]);
      }
   }
	
	// tinh tong duong cheo phu
	int sumDCP= 0;
	for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
         if (i + j == row-1 )
            sumDCP = sumDCP + mat[i][j];
      }
   }
   
   printf("\nTong duong cheo phu cua ma tran la: %d", sumDCP);

	//tim max cua ma tran
	int max = mat[0][0];
	for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
         if (mat[i][j] > max )
            max = mat[i][j];
      }
   }
   printf("\nMax cua ma tran la: %d", max);
   //tim min tich cac cot
   int minCot = 9999;
   	for (i = 0; i < row; i++) {
   		int tich = 1;
      	for (j = 0; j < col; j++) {
	         tich *= mat[j][i];
      	}
      	if (tich < minCot) minCot = tich;
   }
   printf("\nMin tich cac cot la: %d", minCot);
   //Kiem tra xem co phai ma tran tam giac khong
	int checkMTTG = 1;
	for (i = 0; i < row; i++) {
      for (j = 0; j < i; j++) {
         if (mat[i][j] != 0 ) {
         	checkMTTG =0;
         	break;
		 }
      }
   }
   for (i = 0; i < row; i++) {
      for (j =  row-1; j > i; j--) {
         if (mat[i][j] != 0 ) {
         	checkMTTG =0;
         	break;
		 }
      }
   }
   if (checkMTTG) {
   		printf("\nLa ma tran tam giac");
   } else {
   		printf("\nKhong la ma tran tam giac");
   }
	// kiem tra ma phuong
	int sum1 = 0;
	int flag = 0;
	for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
         if (i==j ) {
         	sum1+=mat[i][j];
		 }
      }
   }
   
   
   	for (i = 0; i < row; i++) {
   		int sum2 = 0;
      for (j = 0; j < col; j++) {
         	sum2+=mat[i][j];
      }
      if(sum2 == sum1) flag = 1;
      else {
      	flag = 0;
      	break;
	  }
   }
   
   	for (i = 0; i < row; i++) {
   		int sum3 = 0;
      for (j = 0; j < col; j++) {
         	sum3+=mat[j][i];
      }
      if(sum3 == sum1) flag = 1;
      else {
      	flag = 0;
      	break;
	  }
   }
   if(flag == 1) {
   		printf("\nLa ma phuong!");
   } else {
   		printf("\nKhong la ma phuong!");
   }
   
   //tinh tong tren duong thang di qua u, v song song voi dcc
   	int u, v;
   	printf("\nNhap u, v: ");
   	scanf("%d%d", &u, &v);
   	int sumUV= 0;
	for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
         if (i - j == u-v )
            sumUV = sumUV + mat[i][j];
      }
   }
   printf("\nTong cac phan tu tren duong thang qua u,v // dcc la: %d", sumUV);
   return (0);
}
