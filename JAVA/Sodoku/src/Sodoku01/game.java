package Sodoku01;

import java.io.IOException;
import java.util.Scanner;

public class game {
	// in ra ma trận số
	public static void inRa(int[][] a) {
		// clear màn hình

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	// kiểm tra xem còn ô nào trống hay không (còn = True >< hết =F alse)
	public static boolean checkAll(int[][] a) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (a[i][j] != 0)
					return true;
			}
		}
		return false;
	}

	// kiểm tra xem số đó có trùng với ô đó trong ô vuông lớn (có = False >< không =
	// True)
	public static boolean checkSquare(int[][] a, int x, int y, int so) {

		x = (x * 3 + 1);
		y = (y * 3 + 1);

		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (a[i][j] == so)
					return false;
			}
		}
		return true;
	}

	// kiểm tra xem nó ở ô vuông lớn nào rồi check xem ô vuông lớn đó có số đó chưa
	// (có = False >< không = True)
	public static boolean checkPlace(int[][] a, int x, int y, int so) {
		x--;
		y--;
		x /= 3;
		y /= 3;
		if (checkSquare(a, x, y, so) == false) {
			System.out.println("Đã tồn tại số này trong ô vuông lớn!");
			return false; // 1
		} else
			return true;
	}

	// kiểm tra xem trong hàng x và cột y (trùng = False - đúng = True)
	public static boolean checkXY(int[][] a, int so, int x, int y) {
		for (int i = 1; i <= 9; i++)
			if (a[x][i] == so | a[i][y] == so) {
				System.out.println("Đã tồn tại số này trong hàng hoặc cột!");
				return false;
			}
		return true;
	}

	public static void main(String[] args) throws IOException {

		int[][] a = new int[11][11];
		int x = 0, y = 0, so = 0;

		// khởi tạo game mới
		a[1][1] = 5;
		a[1][2] = 3;
		a[1][5] = 7;
		a[2][1] = 6;
		a[2][4] = 1;
		a[2][5] = 9;
		a[2][6] = 5;
		a[3][2] = 9;
		a[3][3] = 8;
		a[3][8] = 6;
		a[4][1] = 8;
		a[4][5] = 6;
		a[4][9] = 3;
		a[5][1] = 4;
		a[5][4] = 8;
		a[5][6] = 3;
		a[5][9] = 1;
		a[6][1] = 7;
		a[6][5] = 2;
		a[6][9] = 6;
		a[7][2] = 6;
		a[7][7] = 2;
		a[7][8] = 8;
		a[8][4] = 4;
		a[8][5] = 1;
		a[8][6] = 9;
		a[8][9] = 5;
		a[9][5] = 8;
		a[9][8] = 7;
		a[9][9] = 9;

		// tạo biến nhập xuất
		Scanner S = new Scanner(System.in);

		// in ra trạng thái game
		inRa(a);

		while (checkAll(a) == true) {
			// Nhập

			do {
				System.out.println("Nhập vị trí và giá trị!");

				// Nhập x
				do {
					System.out.println("Nhập X:");
					x = S.nextInt();
				} while (x <= 0 | x > 9);

				// Nhập y
				do {
					System.out.println("Nhập Y:");
					y = S.nextInt();
				} while (y <= 0 | y > 9);

				// Nhập giá trị
				do {
					System.out.println("Nhập giá trị: ");
					so = S.nextInt();
				} while (so <= 0 | so > 9);
			} while (checkPlace(a, x, y, so) == false | checkXY(a, so, x, y) == false);
			a[x][y] = so;

			System.out.println("Cập nhật thành công!");

			inRa(a);
		}

		System.out.println("\n ---- CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG---");
		S.close();
	}
}