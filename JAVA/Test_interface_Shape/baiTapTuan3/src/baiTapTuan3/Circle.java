package baiTapTuan3;

// Lớp hình tròn
public class Circle {
	private Point Center; // Center là tọa độ tâm của hình tròn
	private double Radius; // Radius là bán kính của hình tròn

	public Circle() {
		this.Center = new Point();
		this.Radius = 1;
	}

	public Circle(int x, int y, double radius) {
		Center.setX(x);
		Center.setY(y);
		Radius = radius;
	}

	public Point getCenter() {
		return Center;
	}

	public void setCenter(double d, double e) {
		Center.setX(d);
		Center.setY(e);
	}

	public double getRadius() {
		return Radius;
	}

	public void setRadius(double radius) {
		Radius = radius;
	}
	
	// di chuyển
	public void setMove(double x, double y) {
		setCenter(Center.getX() + x, Center.getY() + y);
	}

	// zoom
	public void setZoom(double facter) {
		setRadius(getRadius() * facter);
	}

	// chu vi
	public double getPerimeter() {
		return 2 * Math.PI * Radius;
	}
	/*
	 * khoảng cách về O phương thức này trả về khoảng cách từ đường tròn tới góc tọa
	 * độ O
	 */

	public double getDistance() {
		return Center.getDistanceOrigin() - getRadius();
	}

	/*
	 * public static void main(String[] args) { Circle circle = new Circle();
	 * circle.setCenter(3, 3); circle.setMove(3, 3); System.out.println(" " +
	 * circle.getCenter().getX() + " , " + circle.getCenter().getY()); }
	 */
}
