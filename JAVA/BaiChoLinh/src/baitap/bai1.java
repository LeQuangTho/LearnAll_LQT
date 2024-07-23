package baitap;

import java.util.Scanner;

public class bai1 {

	public static void main(String[] args) {
		String hoTen;
		double diem;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		hoTen = scanner.nextLine();

		do {
			System.out.println("Nhap diem tring binh: (điểm<=10 && >0)");
			diem = scanner.nextDouble();
		} while (diem > 10 | diem < 0);
		System.out.printf("%s %.3f diem", hoTen, diem);
		scanner.close();
	}
}
