package CrossTheRiver;

public class State {
	public interface AMOUNT_PEOPLE_WOLF{
		public static final int MAX_PEOPLE = 3;
		public static final int MAX_WOLF = 3;
	}
	
	private int People;
	private int Wolf;
	private boolean Boat;

	public State(int people, int wolf, boolean boat) {
		super();
		People = people;
		Wolf = wolf;
		Boat = boat;
	}

	public int getPeople() {
		return People;
	}

	public void setPeople(int people) {
		People = people;
	}

	public int getWolf() {
		return Wolf;
	}

	public void setWolf(int wolf) {
		Wolf = wolf;
	}

	public boolean isBoat() {
		return Boat;
	}

	public void setBoat(boolean boat) {
		Boat = boat;
	}

	public boolean isEnd() {
		if (this.People == 0 && !this.Boat && this.Wolf == 0) {
			return true;
		}
		return false;
	}

	public boolean equal(State other) {
		if(this.Boat == other.isBoat() && this.Wolf == other.getWolf() && this.People == other.getPeople()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "State [People=" + People + ", Wolf=" + Wolf + ", Boat=" + Boat + "]";
	}
}
