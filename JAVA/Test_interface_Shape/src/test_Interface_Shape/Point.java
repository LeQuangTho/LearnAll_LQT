/*
 * Điểm
 */
package test_Interface_Shape;

public class Point implements Shape {

	private double x;
	private double y;

	public Point() {
		super();
		this.x = 0;
		this.y = 0;
		O.setLocation(x, y);
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		O.setLocation(x, y);
	}

	// Getters and setters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
		O.setLocation(x, getY());
	}

	public void setY(double y) {
		this.y = y;
		O.setLocation(getX(), y);
	}

	// toString
	@Override
	public String toString() {
		return "Point [x=" + getX() + ", y=" + getY() + "]";
	}

	@Override
	public void move(double dx, double dy) {
		this.setX(dx);
		this.setX(dx);
	}
	// Zoom đã có sắn trong interface

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double circ() {
		return 0;
	}

	@Override
	public double disc(double dx, double dy) {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}

	@Override
	public void rotate(double R) {
		// NA

	}

	@Override
	public void zoom(double N) {
		// NA

	}
}
