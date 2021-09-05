package SlidingPuzzle;

public class Node {
	private State stateChild;
	private State stateParents;
	private int direction;

	public Node(State stateChild, State stateParents, int direction) {
		super();
		this.stateChild = stateChild;
		this.stateParents = stateParents;
		this.direction = direction;
	}

	public State getStateChild() {
		return stateChild;
	}

	public void setStateChild(State stateChild) {
		this.stateChild = stateChild;
	}

	public State getStateParents() {
		return stateParents;
	}

	public void setStateParents(State stateParents) {
		this.stateParents = stateParents;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Node [stateChild=" + stateChild + ", stateParents=" + stateParents + ", direction=" + direction + "]";
	}

	
}
