package BaiTapIf;

import java.util.Scanner;

public class baiIF_7 {

	public static void main(String[] args) {
		String a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mầu bạn yêu thích: \n(xanh, đỏ, tím ,vàng, hồng, trắng");
		a = scanner.nextLine();
		switch (a) {
		case "xanh":
			System.out.println("bạn bị BĐ");
			break;
		case "đỏ":
			System.out.println("chắc là bạn bị ghét máu hồng của chú Huấn");
			break;
		case "tím":
			System.out.println("bạn bị đấm tím mắt");
			break;
		case "vàng":
			System.out.println("màu vàng của nắng chứng tở bạn rất hay ngáo nắng");
			break;
		case "hồng":
			System.out.println("bạn chắc chắn là fan cứng cửa thầy dạy DGCD Mr.Bùi Huấn");
			break;
		case "trắng":
			System.out.println("con người nhạt nhẽo");
			break;

		default:
			System.out.println("Chỉ cố 6 màu trên ko nhập được thì biến!");
			break;
		}

		scanner.close();
	}
}
