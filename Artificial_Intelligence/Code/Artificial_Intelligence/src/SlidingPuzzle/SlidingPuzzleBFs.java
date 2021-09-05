package SlidingPuzzle;

import java.util.LinkedList;
import java.util.Queue;

import SlidingPuzzle.State.IPiecesBackMove;

public class SlidingPuzzleBFs {

	public static final LinkedList<Integer> firstPiecesList = new LinkedList<>();

	public static Queue<State> states = new LinkedList<State>();
	public static LinkedList<State> stateWasSet = new LinkedList<State>();
	public static LinkedList<Node> step = new LinkedList<>();

	public static void main(String[] args) {

		initFirst();
		System.out.println(states.peek().toString());

		while (true) {
			State state = states.peek();

			if (state == null) {
				System.out.println("empty");
				break;
			}

			if (state.isEnd()) {
				System.out.println(state.toString());
				System.out.println("end game");
				break;
			}

			changeState(state, IPiecesBackMove.LEFT);
			changeState(state, IPiecesBackMove.UP);
			changeState(state, IPiecesBackMove.RIGHT);
			changeState(state, IPiecesBackMove.DOWN);

//			System.out.println("first"+state.toString());
			states.remove();
		}

		State stateEnd = State.getStateEnd();
		System.out.println("Trạng thái ban đầu \n " + stateEnd.toString() + "\n bắt đầu chạy game");
		for (int i = step.size() - 1; i >= 0; i--) {
			if (step.get(i).getStateChild().equals(stateEnd)) {
				stateEnd = step.get(i).getStateParents();
				System.out.println(stateEnd.toString() + step.get(i).getDirection());
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
			System.out.println(nextState.toString() + direction);
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
