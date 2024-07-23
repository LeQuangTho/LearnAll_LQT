package BaiTapIf;

import java.util.Scanner;

public class baiIF_4 {
	public static final int cong = 1500000;

	public static double NCTL(double ngayCong) {
		if (ngayCong < 25)
			return ngayCong;
		else
			return (ngayCong - 25) * 2 + 25;
	}

	public static void main(String[] args) {
		double bacLuong;
		double ngayCong;
		double phuCap;
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhập bậc lương:");
		bacLuong = scanner.nextDouble();
		System.out.println("nhập ngày công :");
		ngayCong = scanner.nextDouble();
		System.out.println("nhập phụ cấp:");
		phuCap = scanner.nextDouble();
		System.out.printf("tiền thực lĩnh: %.3f", bacLuong * cong * NCTL(ngayCong) + phuCap);
		scanner.close();
	}

}
