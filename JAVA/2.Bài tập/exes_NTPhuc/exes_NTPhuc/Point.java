package week_04.exes_NTPhuc;

public class Point {
	// Attributes
	private double x;
	private double y;
	
	// Constructors
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	// Getters and setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// toString
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	// methods
	public double area(){
		return 0.0;
	}
	
	public double circ(){
		return 0.0;
	}
	
	public double distance(){
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
	// methods - di chuyển
	public void move(double dx, double dy){
		this.x += dx;
		this.y += dy;
	}
	
	public void rotate(double alpha){
		setX(getX() * Math.cos(a) - getY() * Math.sin(a));
		setY(getX() * Math.sin(a) + getY() * Math.cos(a));
	}
	
	public void zoom(double r){
		// N.A
	}
	
}
