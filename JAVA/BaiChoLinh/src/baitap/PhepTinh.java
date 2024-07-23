package baitap;

import java.util.Scanner;

public class PhepTinh {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		String dau;
		System.out.print("Nhập dấu  phép toán:");
		dau = scanner.nextLine();

		System.out.print("Nhập vào 2 số a,b");
		a = scanner.nextInt();
		b = scanner.nextInt();
				switch (dau) {
		case "+": System.out.printf("Tổng: %.2f",+a+b);break;
		case "-": System.out.printf("Hiệu: %.2f",a-b);break;	
		case "*": System.out.printf("Tích: %.2f",a*b);break;	
		case "/": System.out.printf("Thương: %.2f",(float)a/b);break;
		default: System.out.println("Phép tính bạn nhập chưa đúng");
		}
		scanner.close();
	}

}
