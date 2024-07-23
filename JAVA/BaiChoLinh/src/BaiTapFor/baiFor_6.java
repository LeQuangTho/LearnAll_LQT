package BaiTapFor;

import java.util.Scanner;

public class baiFor_6 {

	public static void main(String[] args) {
		int num;
		int sum = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập n: ");
		num = scanner.nextInt();
		for (int i = num; i >= 1; i--) {
			sum *= i;
		}

		System.out.println("n! = " + sum);
		scanner.close();
	}

}
