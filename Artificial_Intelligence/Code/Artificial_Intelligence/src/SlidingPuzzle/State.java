package SlidingPuzzle;

import java.util.LinkedList;
import java.util.Objects;

public class State implements Comparable<State> {
	interface IPiecesBackMove {
		public static final int LEFT = 1;
		public static final int UP = 2;
		public static final int RIGHT = 3;
		public static final int DOWN = 4;
	}

	private LinkedList<Integer> piecesList;
	private int indexBlack;

	public State(LinkedList<Integer> piecesList) {
		super();
		this.piecesList = piecesList;
		for (int i = 0; i < piecesList.size(); i++) {
			if (piecesList.get(i) == 0) {
				this.indexBlack = i;
			}
		}
	}

	public LinkedList<Integer> getPiecesList() {
		return piecesList;
	}

	public void setPiecesList(LinkedList<Integer> piecesList) {
		this.piecesList = piecesList;
	}

	public int getIndexBlack() {
		return indexBlack;
	}

	public void setIndexBlack() {
		for (int i = 0; i < piecesList.size(); i++) {
			if (piecesList.get(i) == 0) {
				this.indexBlack = i;
			}
		}
	}

	@Override
	public String toString() {
		return "[pieces=" + piecesList + ", indexBlack=" + indexBlack + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(indexBlack, piecesList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return indexBlack == other.indexBlack && Objects.equals(piecesList, other.piecesList);
	}

	public boolean isEnd() {
		LinkedList<Integer> finishPiecesList = new LinkedList<>();
		finishPiecesList.add(1);
		finishPiecesList.add(2);
		finishPiecesList.add(3);
		finishPiecesList.add(8);
		finishPiecesList.add(0);
		finishPiecesList.add(4);
		finishPiecesList.add(7);
		finishPiecesList.add(6);
		finishPiecesList.add(5);
		State stateFinish = new State(finishPiecesList);
		return this.equals(stateFinish);
	}

	public static State getStateEnd() {
		LinkedList<Integer> finishPiecesList = new LinkedList<>();
		finishPiecesList.add(1);
		finishPiecesList.add(2);
		finishPiecesList.add(3);
		finishPiecesList.add(8);
		finishPiecesList.add(0);
		finishPiecesList.add(4);
		finishPiecesList.add(7);
		finishPiecesList.add(6);
		finishPiecesList.add(5);
//		finishPiecesList.add(1);
//		finishPiecesList.add(2);
//		finishPiecesList.add(3);
//		finishPiecesList.add(4);
//		finishPiecesList.add(5);
//		finishPiecesList.add(6);
//		finishPiecesList.add(7);
//		finishPiecesList.add(8);
//		finishPiecesList.add(0);
		State stateEnd = new State(finishPiecesList);
		return stateEnd;
	}

	public boolean moveBlack(int direction) {
		LinkedList<Integer> nextPiecesList = this.getPiecesList();
		if (this.canMove(direction)) {
			if (direction == IPiecesBackMove.LEFT) {
				nextPiecesList.set(this.indexBlack, nextPiecesList.get(this.indexBlack - 1));
				nextPiecesList.set(this.indexBlack - 1, 0);
			}
			if (direction == IPiecesBackMove.RIGHT) {
				nextPiecesList.set(this.indexBlack, nextPiecesList.get(this.indexBlack + 1));
				nextPiecesList.set(this.indexBlack + 1, 0);
			}
			if (direction == IPiecesBackMove.UP) {
				nextPiecesList.set(this.indexBlack, nextPiecesList.get(this.indexBlack - 3));
				nextPiecesList.set(this.indexBlack - 3, 0);
			}
			if (direction == IPiecesBackMove.DOWN) {
				nextPiecesList.set(this.indexBlack, nextPiecesList.get(this.indexBlack + 3));
				nextPiecesList.set(this.indexBlack + 3, 0);
			}

			this.setPiecesList(nextPiecesList);
			this.setIndexBlack();
			return true;
		} else {
			return false;
		}
	}

	private boolean canMove(int direction) {
		if (direction == IPiecesBackMove.UP) {
			if (this.indexBlack >= 0 && this.indexBlack < 3) {
				return false;
			}
		}

		if (direction == IPiecesBackMove.LEFT) {
			if (this.indexBlack % 3 == 0) {
				return false;
			}
		}

		if (direction == IPiecesBackMove.RIGHT) {
			if (this.indexBlack % 3 == 2) {
				return false;
			}
		}
		if (direction == IPiecesBackMove.DOWN) {
			if (this.indexBlack >= 6 && this.indexBlack < 9) {
				return false;
			}
		}

		return true;
	}

	public int difference() {
		LinkedList<Integer> listEnd = State.getStateEnd().piecesList;
		int count = 0;
		for (int i = 0; i < piecesList.size(); i++) {
			for (int j = 0; j < listEnd.size(); j++) {
				if (this.piecesList.get(i) == listEnd.get(j)) {
					if (i != j) {
						count += (Math.abs(i - j) / 3 + Math.abs(i - j) % 3);
					}
				}
			}
		}
		return count;
	}

	@Override
	public int compareTo(State o) {
//		System.out.println(o.difference() + " " + this.difference());
		return o.difference() - this.difference();
	}
}