package BaiTapIf;

import java.util.Scanner;

public class baiIF_6 {

	public static void main(String[] args) {
		int nam;
		int thang;
		int ngay30 = 30;
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhập tháng");
		thang = scanner.nextInt();
		System.out.println("nhập năm");
		nam = scanner.nextInt();
		switch (thang) {
		case 1:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 2: {
			if (nam % 4 == 0) {
				System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 - 1) + "ngày");
				break;
			} else
				System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 - 2) + "ngày");
			break;
		}
		case 3:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 4:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + ngay30 + "ngày");
			break;
		case 5:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 6:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + ngay30 + "ngày");
			break;
		case 7:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 8:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 9:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + ngay30 + "ngày");
			break;
		case 10:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;
		case 11:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + ngay30 + "ngày");
			break;
		case 12:
			System.out.println("tháng " + thang + " năm " + nam + " có : " + (ngay30 + 1) + "ngày");
			break;

		default:
			System.out.println("tháng và năm không hợp lệ");
			break;
		}

		scanner.close();
	}

}
