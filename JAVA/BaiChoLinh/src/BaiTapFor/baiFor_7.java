package BaiTapFor;

import java.util.Scanner;

public class baiFor_7 {
	public static boolean check(int num) {
		if(num == 1) return false;
		for (int i = 2; i*i <= num; i ++) {
//			với i thì không nên dùng Math.sqrt() 
//			vì nó phải nhẩy vào thư viện.
//			sẽ không tối ưu hóa được thời gian chạy
//			có thể gán biến sqrt ở bên ngoài
			if(num%i == 0 ) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int num;
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Nháº­p n: ");
				num = scanner.nextInt();
				String a = (check(num)?" lÃ ": " khÃ´ng lÃ ");
				System.out.println(num + a + " sá»‘ nguyÃªn tá»‘");
			}
		}	
	
	}

}
