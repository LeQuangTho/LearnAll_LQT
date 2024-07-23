package BaiTapTrenLop;

import java.util.Scanner;

public class sumNnguyento {
	public static boolean checkNT(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so nguyen N: ");
		n = sc.nextInt();

		for (int i = 2; i <= n; i++) {
			if (checkNT(i) == true)
				sum += i;
		}

		System.out.println("tong N cac so nguyen to tu 1 -> N: " + sum);
		sc.close();
	}

}
