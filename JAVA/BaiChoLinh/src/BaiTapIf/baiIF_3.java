package BaiTapIf;

import java.util.Scanner;

public class baiIF_3 {

	public static void main(String[] args) {
		double a, b, c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào 3 số a,b,c");
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		c = scanner.nextDouble();
		if ((a > b & a > c) | (a > b & b == c))
			System.out.println("a lớn nhất Max =" + a);
		else if ((b > a & b > c) | (b > a & a == c))
			System.out.println("b lớn nhất Max =" + b);
		else if ((c > b & c > a) | (c > a & a == b))
			System.out.println("c lớn nhất Max =" + c);
		else
			System.out.println(" 3 số bằng nhau.");
		scanner.close();
	}

}
