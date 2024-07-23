package BaiTapIf;

import java.util.Scanner;

public class baiIF_1 {
	public static void main(String[] args) {
		double a, b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Với ax + b =0\nnhập vào 2 số a,b:");
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		if (a == 0 & b != 0)
			System.out.println(" Vô nghiệm");
		else if (a == 0 & b == 0)
			System.out.println(" vô số nghiệm");
		else
			System.out.printf("x = %2f", (-b) / a);
		scanner.close();

	}
}
