package baitap;

import java.util.Scanner;

public class Bai2 {
	public static final double thue = 0.15;

	public static void main(String[] args) {
		String ten;
		int gia;
		int soluong;
		double thuenhap;
		Scanner a = new Scanner(System.in);
		System.out.println("Nhập tên sản phẩm: ");
		ten = a.nextLine();
		System.out.println("Nhập đơn giá: ");
		gia = a.nextInt();
		System.out.println("Nhập số lượng: ");
		soluong = a.nextInt();

		thuenhap = thue * gia;
		System.out.println("Tên sản phẩm: " + ten);
		System.out.println("Đơn giá: " + gia);
		System.out.println("Số lượng: " + soluong);
		System.out.println("Thuế nhập 1 sản phẩm: " + thuenhap);
		a.close();
	}
}
