package miniGame;

public class Node {
	private int row;
	private int colum;
	private int zone;
	private int value;
	private boolean reserved;

	public Node(int row, int colum, int zone, int value, boolean reserved) {
		super();
		this.row = row;
		this.colum = colum;
		this.zone = zone;
		this.value = value;
		this.reserved = reserved;
	}

	public Node() {
		super();
		this.zone = 0;
		this.value = 0;
		this.reserved = false;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColum() {
		return colum;
	}

	public void setColum(int colum) {
		this.colum = colum;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
	public boolean validateRow(Game game, int row) {
		
		for(int i = 1; i < 9 ; i++) {
			int num = game.getElement(row, i).getValue();
			if(num != 0)
			for(int j = i+1; j < 9 ; j++) {
				if(num == game.getElement(row, j).getValue()) return false;
			}
		}
		return true;
	}
	
	public boolean validateColum(Game game, int colum) {
		for(int i = 0; i < 9 ; i++) {
			int num = game.getElement(i , colum).getValue();
			if(num != 0)
			for(int j = i + 1; j < 9 ; j++) {
				if(num == game.getElement(j , colum).getValue()) return false;
			}
		}
		return true;
	}
	
	public boolean validateZone(Game game, int zone) {
		for(int i = 0; i < 9 ; i++) {
			int num = game.getElement(((zone-1)/3)*3 + i/3 , ((zone - 1)%3)*3 +i%3).getValue();
			if(num != 0)
			for(int j = i + 1; j < 9 ; j++) {
				if(num == game.getElement(((zone-1)/3)*3 + j/3 , ((zone - 1)%3)*3 +j%3).getValue()) return false;
			}
		}
		return true;
	}
}
