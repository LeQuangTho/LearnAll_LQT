package BaiTapIf;

import java.util.Scanner;

public class baiIF_2 {

	public static void main(String[] args) {
		double a, b, c, delta;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		c = scanner.nextDouble();
		if (a != 0) {
			delta = b * b - 4 * a * c;
			if (delta < 0)
				System.out.println("\n phương trình vô nghiệm");
			else if (delta == 0)
				System.out.printf(" \nphương trình có nghiệm x1 = x2 = %.3f", (-b) / 2 * a);
			else {
				System.out.printf("\nx1 = %3f ", ((-b + Math.sqrt(delta)) / (2 * a)));
				System.out.printf("\nx1 = %3f ", ((-b - Math.sqrt(delta)) / (2 * a)));
			}

		} else
			System.out.println("không tốn tại phương trình bậc 2");
		scanner.close();
	}

}
