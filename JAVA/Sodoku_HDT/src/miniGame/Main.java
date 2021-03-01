package miniGame;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row;
		int column;
		int num;
//		int [][]a={
//				{5, 0, 4, 6, 7, 8, 9, 1, 2},
//				{6, 7, 2, 1, 9, 5, 3, 4, 8},
//				{1, 9, 8, 3, 4, 2, 5, 6, 7},
//				{8, 5, 9, 7, 6, 1, 4, 2, 3},
//				{4, 2, 6, 8, 5, 3, 7, 9, 1},
//				{7, 1, 3, 9, 2, 4, 8, 5, 6},
//				{9, 6, 1, 5, 3, 7, 2, 8, 4},
//				{2, 8, 7, 4, 1, 9, 6, 3, 5},
//				{3, 4, 5, 2, 8, 6, 1, 0, 9}};
		int a[][] ={
				{5, 3, 0, 0, 7, 0, 0, 0, 0},
				{6, 0, 0, 1, 9, 5, 0, 0, 0},
				{0, 9, 8, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 0, 6, 0, 0, 0, 3},
				{4, 0, 0, 8, 0, 3, 0, 0, 1},
				{7, 0, 0, 0, 2, 0, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 2, 8, 0},
				{0, 0, 0, 4, 1, 9, 0, 0, 5},
				{0, 0, 0, 0, 8, 0, 0, 7, 9}};

		Game game = new Game();
		game.readData(a);

		do {
			game.showGame();
			do {
				System.out.println("Nhập row, column muốn điền!");
				row = scanner.nextInt();
				column = scanner.nextInt();
				if (game.getElement(row, column).isReserved() == true) {
					System.out.println("Ô này không được nhập mời nhập lại");
				} else {
					do {
						System.out.println("Nhập giá trị: ");
						num = scanner.nextInt();
						game.getElement(row, column).setValue(num);

						if (game.getElement(row, column).validateColum(game, column) == false
								| game.getElement(row, column).validateRow(game, row) == false
								| game.getElement(row, column).validateZone(game,
										(column / 3) + 1 + (row / 3) * 3) == false) {
							System.out.println("Sai rồi nhập lại đi!");
							game.getElement(row, column).setValue(0);
						} else {
							System.out.println("Good job !");
							break;
						}

					} while (game.getElement(row, column).validateColum(game, column) == true
							| game.getElement(row, column).validateRow(game, row) == true 
							| game.getElement(row, column).validateZone(game, (column / 3) + 1 + (row / 3) * 3) == true);
				}
			} while (game.getElement(row, column).isReserved() == true);

		} while (game.validateGame() == true);
		System.out.println("Thật tuyệt Win rồi nè!!");
		System.out.println("  。☆01-01☆ 。\r\n" + 
				"   ★。＼｜／。★\r\n" + 
				"   。 HAPPY 。\r\n" + 
				"   ★。／｜＼。★\r\n" + 
				"   。☆ 2020 ☆。\r\n" + 
				"   happy new year\r\n" + 
				"   。 .. __::_____ ★ 。\r\n" + 
				"   ☆ /_______/ \\ 。。\r\n" + 
				"   。 |_画_画 _|_| ☆ 。");
		scanner.close();
	}
}
