package baitap;

import java.util.Scanner;

public class bai3 {
	public static final double pi = 3.14;

	public static void main(String[] args) {
		double radian;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhập bán kính:( radian > 0) ");
			radian = scanner.nextDouble();
			
		} while (radian < 0);
		
		System.out.printf("Chu vi = %.3f", (2 * radian * pi));
		System.out.printf("\nDiện tích = %.5f", (pi * Math.pow(radian, 2)));
		scanner.close();
	}

}
