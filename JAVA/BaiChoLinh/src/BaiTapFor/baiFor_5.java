package BaiTapFor;

import java.util.Scanner;

public class baiFor_5 {

	public static void main(String[] args) {
		int num;
		double sum1 = 0;
		double sum2 = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập n: ");
		num = scanner.nextInt();
		for (int i = 1; i <= num; i += 2) {
			sum1 += (1.0 / i);
		}

		for (int i = 1; i <= num; i += 4) {
			sum2 += (1.0 / i);
		}

		System.out.printf("\nsum1 = %.3f", sum1);
		System.out.printf("\nsum2 = %.3f", sum2);

		scanner.close();
	}

}
