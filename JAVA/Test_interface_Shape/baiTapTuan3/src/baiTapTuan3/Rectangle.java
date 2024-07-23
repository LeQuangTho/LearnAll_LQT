package baiTapTuan3;

public class Rectangle {
	private Point A, B, C, D;
	private double height, width;

	public Rectangle(double x, double y, double width, double height) {
		A.setX(x);
		A.setY(y);
		setHeight(height);
		setWidth(width);
	}

	public Rectangle() {
		this.A = new Point(0, 0);
		this.B = new Point(0, 1);
		this.C = new Point(1, 1);
		this.D = new Point(1, 0);
		this.height = 1;
		this.width = 1;
	}

	// get set

	public Point getA() {
		return A;
	}

	public void setA(double x, double y) {
		A.setX(x);
		A.setY(y);
	}

	public Point getB() {
		return B;
	}

	public Point getC() {
		return C;
	}

	public Point getD() {
		return D;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		B.setX(A.getX());
		B.setY(A.getY() + getHeight());
		C.setX(A.getX());
		C.setY(A.getY() + getHeight());
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
		C.setX(A.getX() + getWidth());
		C.setY(A.getY());
		D.setX(A.getX() + getWidth());
		D.setY(A.getY());
	}

	// toString
	@Override
	public String toString() {
		return "Rectangle [A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", height=" + height + ", width=" + width
				+ "]";
	}

	// zoom
	public void setZoom(double facter) {
		A.setX(A.getX() * facter);
		A.setY(A.getY() * facter);
		setHeight(getHeight() * facter);
		setWidth(getWidth() * facter);
	}

	// move
	public void setMove(double x, double y) {
		A.setX(A.getX() + x);
		A.setY(A.getY() + y);
		setHeight(getHeight());
		setWidth(getWidth());
	}

	// Diện tích
	public double getArea() {
		return this.getHeight() * this.getWidth();
	}

	// Chu vi
	public double getCirc() {
		return (getHeight() + getWidth()) * 2;
	}

	// Khoảng cách từ A về O
	public double getDistance() {
		return Math.sqrt(A.getX() * A.getX() + A.getY() * A.getY());
	}

	// Xoay
	public void setRotate(double a) {
		A.setX(A.getX() * Math.cos(a) - A.getY() * Math.sin(a));
		A.setY(A.getX() * Math.sin(a) + A.getY() * Math.cos(a));
		
		B.setX(B.getX() * Math.cos(a) - B.getY() * Math.sin(a));
		B.setY(B.getX() * Math.sin(a) + B.getY() * Math.cos(a));
		
		C.setX(C.getX() * Math.cos(a) - C.getY() * Math.sin(a));
		C.setY(C.getX() * Math.sin(a) + C.getY() * Math.cos(a));
		
		D.setX(D.getX() * Math.cos(a) - D.getY() * Math.sin(a));
		D.setY(D.getX() * Math.sin(a) + D.getY() * Math.cos(a));
	}

}
