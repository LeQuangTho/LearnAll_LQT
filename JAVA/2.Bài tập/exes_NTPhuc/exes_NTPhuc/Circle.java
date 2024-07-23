package week_04.exes_NTPhuc;

public class Circle {
	// Attributes
	private double x;
	private double y;
	private double r;

	// Constructors
	public Circle(double x, double y, double r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
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

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	// toString
	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}

	// methods
	public double area() {
		return Utils.PI * this.r * this.r;
	}

	public double circ() {
		return 2.0 * Utils.PI * this.r;
	}

	public double distance() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	// methods - h√¨nh h·ª?c
	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void rotate(double a) {
		setX(getX() * Math.cos(a) - getY() * Math.sin(a));
		setY(getX() * Math.sin(a) + getY() * Math.cos(a));
	}

	public void zoom(double r) {
		this.r *= r;
	}
}
