/*
 * Hình Tròn
 */
package test_Interface_Shape;

public class Circle implements Shape {
	private double R;

	public Circle() {
		super();
		O.setLocation(0, 0);
		this.R = 1;
	}

	public Circle(int x, int y, double r) {
		O.setLocation(x, y);
		this.R = r;
	}

	public void setO(double d, double e) {
		O.setLocation(d, e);
	}

	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}

	public String toString() {
		return "\nCircle [O(" + O.getX() + ", " + O.getY() + ")  R = " + getR() + "]";
	}

	// di chuyển
	public void setMove(double x, double y) {
		setO(O.getX() + x, O.getY() + y);
	}

	// zoom
	public void setZoom(double facter) {
		setR(getR() * facter);
	}

	// Diện tích
	@Override
	public double area() {
		return Math.PI * R * R;

	}

	@Override
	public double circ() {
		return 2 * Math.PI * R;

	}

	@Override
	public void zoom(double N) {
		setR(getR() * N);
	}

	@Override
	public double disc(double dx, double dy) {
		return Math.sqrt(Math.pow(O.getX() - dx, 2) + Math.pow(O.getY() - dy, 2));
	}

	@Override
	public void rotate(double R) {
		// NA

	}

	@Override
	public void move(double x, double y) {
		O.setLocation(O.getX() + x, O.getY() + y);
	}
}
