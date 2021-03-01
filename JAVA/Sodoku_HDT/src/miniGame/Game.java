package miniGame;

import java.util.ArrayList;

public class Game {
	ArrayList<Node> Table = new ArrayList<Node>();

	public Game(ArrayList<Node> table) {
		super();
		Table = table;
	}

	public Game() {
		super();

	}

	public void readData(int a[][]) {
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 8; j++) {
				int zone = (j / 3) + 1 + (i / 3) * 3;
				boolean reserved = (a[i][j] == 0 ? false : true);
				Table.add(new Node(i, j, zone, a[i][j], reserved));
			}
		}
	}

	public void showGame() {
		System.out.println("SODOKU\n");
		System.out.println("     0  1  2  3  4  5  6  7  8");
		System.out.print("================================");
		for (Node node : Table) {
			if (node.getColum() == 0) {
				System.out.print("\n" + node.getRow() + " || " + node.getValue() + " |");
			} else
				System.out.print(node.getValue() + " |");
		}
		System.out.println("\n================================");
	}

	public boolean validateGame() {
		for (Node node : Table) {
			if (node.getValue() == 0)
				return true;
		}
		// System.out.println("Bạn chưa điền " + Validate + " ô!");
		return false;
	}

	public Node getElement(int r, int c) {
		return Table.get(r * 9 + c);
	}

}
