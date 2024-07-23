package baitap;

import java.util.Scanner;

public class bai4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Double Toan, Ly, Hoa;

		do {
			System.out.println("Nhập điểm Toán (Điểm <= 10 & >0)");
			Toan = scanner.nextDouble();
		} while (Toan > 10 | Toan < 0);

		do {
			System.out.println("Nhập điểm Lý (Điểm <= 10 & >0)>");
			Ly = scanner.nextDouble();
		} while (Ly > 10 | Ly < 0);
		do {
			System.out.println("Nhập điểm Hóa (Điểm <= 10 & >0)>");
			Hoa = scanner.nextDouble();
		} while (Hoa > 10 | Hoa < 0);

		System.out.printf("Điểm trung bình: %.3f", (Toan * 3 + Ly * 2 + Hoa) / 6);
		scanner.close();
	}
}
