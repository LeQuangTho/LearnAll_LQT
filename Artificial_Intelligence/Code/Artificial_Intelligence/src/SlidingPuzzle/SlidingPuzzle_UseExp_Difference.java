package SlidingPuzzle;

import java.util.LinkedList;
import java.util.PriorityQueue;

import SlidingPuzzle.State.IPiecesBackMove;

public class SlidingPuzzle_UseExp_Difference {

	public static final LinkedList<Integer> firstPiecesList = new LinkedList<>();

	public static PriorityQueue<State> states = new PriorityQueue<State>();
	public static LinkedList<State> stateWasSet = new LinkedList<State>();
	public static LinkedList<Node> step = new LinkedList<>();

	public static void main(String[] args) {

		initFirst();
		System.out.println("Trạng thái đầu\n" + states.peek().toString() + "\n---------");

		while (true) {

			State state = states.peek();

			if (state == null) {
				System.out.println("empty");
				break;
			}

			if (state.isEnd()) {
				System.out.println(state.toString());
				endGame();
				break;
			}

			changeState(state, IPiecesBackMove.LEFT);
			changeState(state, IPiecesBackMove.UP);
			changeState(state, IPiecesBackMove.RIGHT);
			changeState(state, IPiecesBackMove.DOWN);
			System.out.println("------------");
			;
//			System.out.println("first" + state.toString());
			states.remove();
		}

	}

	private static void endGame() {
		System.out.println("end game");
		State stateEnd = State.getStateEnd();
		System.out.println("Bắt đầu chạy game \n" + stateEnd.toString());
		for (int i = step.size() - 1; i >= 0; i--) {
			if (step.get(i).getStateChild().equals(stateEnd)) {
				stateEnd = step.get(i).getStateParents();
				System.out.println(stateEnd.toString() + stateEnd.difference());
			}
		}
	}

	private static void changeState(State state, int direction) {
		LinkedList<Integer> nextList = new LinkedList<>();
		for (Integer integer : state.getPiecesList()) {
			nextList.add(integer);
		}
		State nextState = new State(nextList);
		if (nextState.moveBlack(direction) == false) {
			return;
		}

		if (!isDuplicate(nextState)) {
			states.add(nextState);
			stateWasSet.add(nextState);
			step.add(new Node(nextState, state, direction));
			System.out.println(nextState.toString() + nextState.difference());
		}
	}

	private static boolean isDuplicate(State state) {
		for (int i = 0; i < stateWasSet.size(); i++) {
			if (stateWasSet.get(i).equals(state)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * step 1 add firstPiecesList step 2 create and add first State
	 */
	private static void initFirst() {
		firstPiecesList.add(2);
		firstPiecesList.add(8);
		firstPiecesList.add(3);
		firstPiecesList.add(1);
		firstPiecesList.add(6);
		firstPiecesList.add(4);
		firstPiecesList.add(7);
		firstPiecesList.add(0);
		firstPiecesList.add(5);
		states.add(new State(firstPiecesList));
		stateWasSet.add(new State(firstPiecesList));
	}
}
