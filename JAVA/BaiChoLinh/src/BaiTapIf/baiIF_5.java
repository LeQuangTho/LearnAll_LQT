package BaiTapIf;

import java.util.Scanner;

public class baiIF_5 {
	public static boolean check(double a, double b, double c) {
		if (a >= b + c)
			return false;
		else if (b >= a + c)
			return false;
		else if (c >= a + b)
			return false;
		else
			return true;
	}

	public static double S(double a, double b, double c) {
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static void main(String[] args) {
		double a, b, c;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("nhập 3 cạnh của tam giác a,b,c:");
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			c = scanner.nextDouble();
			if (check(a, b, c) == true) {
				System.out.printf(" \nchu vi = %.3f", a + b + c);
				System.out.printf("\nDiện tích: %.3f", S(a, b, c));
			} else
				System.out.println("a,b,c : không tạo thành tam giác");
		} while (check(a, b, c) == false);
		scanner.close();
	}
}
