package BaiTapFor;

import java.util.Scanner;

public class baiFor_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		int i=0;
		int sum = 0;
		do {
			System.out.println("nhập: ");
			num = scanner.nextInt();
			sum += num;
			i++;
		} while (num != 0);
		System.out.println(" tổng các số nhập vào:  " + sum/i);
		scanner.close();
	}

}
