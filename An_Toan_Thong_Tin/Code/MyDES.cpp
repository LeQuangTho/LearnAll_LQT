#include<bits/stdc++.h>

using namespace std;

unsigned int getBit(unsigned K1, int i){
	for(int i = 1; i<=32; i++){
		unsigned int b = K1 >>(32 - i);
		unsigned bit = b& 0x01;
	}
}

int main()
{
	unsigned int K1 = 0x17FFCC5A;
	unsigned int K2 = 0xDBF3EA87;
	int pc1[] = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4};  
	printf("K1 = %#x\n", K1);
	printf("K2 = %#x\n", K2);
	
	unsigned int pc1k1 = 0;
	unsigned int bit;
	for(int i = 0; i<32; i++){
		int vitri;
		unsigned int bit;
		if(pc1[i] >32){
			vitri = pc1[i]-32;
			bit = getBit(K2, vitri);
		}else{
			vitri = pc1[i];
			bit = getBit(K1, vitri);
		}
		unsigned b = bit & 0x01;
		pc1k1 = (pc1k1 << 1) | b;
	}
	printf("pc1k1 = %#x", pc1k1);
}

