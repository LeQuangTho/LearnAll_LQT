package CrossTheRiver;

public class Node {
	private int peopleOnBoat;
	private int wolfOnBoat;
	private State stateParent;
	private State stateChild;

	public Node(int peopleOnBoat, int wolfOnBoat, State stateParent, State stateChild) {
		super();
		this.peopleOnBoat = peopleOnBoat;
		this.wolfOnBoat = wolfOnBoat;
		this.stateParent = stateParent;
		this.stateChild = stateChild;
	}

	public int getPeopleOnBoat() {
		return peopleOnBoat;
	}

	public void setPeopleOnBoat(int peopleOnBoat) {
		this.peopleOnBoat = peopleOnBoat;
	}

	public int getWolfOnBoat() {
		return wolfOnBoat;
	}

	public void setWolfOnBoat(int wolfOnBoat) {
		this.wolfOnBoat = wolfOnBoat;
	}

	public State getStateParent() {
		return stateParent;
	}

	public void setStateParent(State stateParent) {
		this.stateParent = stateParent;
	}

	public State getStateChild() {
		return stateChild;
	}

	public void setStateChild(State stateChild) {
		this.stateChild = stateChild;
	}

	@Override
	public String toString() {
		return "[" + peopleOnBoat + ", " + wolfOnBoat + "]";
	}

	
}
