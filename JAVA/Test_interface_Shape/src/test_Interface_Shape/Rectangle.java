/*
 * Hình chữ nhật
 */
package test_Interface_Shape;

public class Rectangle implements Shape {
	private Point A, B, C, D;
	private double height, width;

	public Rectangle(double x, double y, double width, double height) {
		this.A = new Point(x, y);
		this.B = new Point(x, y + height);
		this.C = new Point(x + width, y + height);
		this.D = new Point(x + width, y);
		this.height = width;
		this.width = width;
		O.setLocation(A.getX() + this.getWidth()/2, A.getY() + this.getHeight()/2);
	}

	public Rectangle() {
		this.A = new Point(0, 0);
		this.B = new Point(0, 1);
		this.C = new Point(1, 1);
		this.D = new Point(1, 0);
		this.height = 1;
		this.width = 1;
		O.setLocation(A.getX() + this.getWidth()/2, A.getY() + this.getHeight()/2);
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
		C.setY(A.getY() + getHeight());
		O.setLocation(A.getX() + this.getWidth()/2, A.getY() + height/2);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
		C.setX(A.getX() + getWidth());
		D.setX(A.getX() + getWidth());
		D.setY(A.getY());
		O.setLocation(A.getX() + width/2, A.getY() + this.getHeight()/2);
	}

	// toString
	@Override
	public String toString() {
		return "Rectangle { \nA=[" + A.getX() + ", " + A.getY()+"]\n" 
				+ "B=[" + B.getX() + ", " + B.getY()+"]\n"
				+ "C=[" + C.getX() + ", " + C.getY()+"]\n"
				+ "D=[" + D.getX() + ", " + D.getY()+"]\n"
				+ "height=" + height + ", width=" + width
				+ "\n}";
	}

	@Override
	public double area() {
		return getHeight() * getWidth();
	}

	@Override
	public double circ() {
		return (getHeight() + getWidth()) * 2;
	}

	// Khoảng cách đã có trong interface
	@Override
	public void rotate(double R) {
		A.setX(A.getX() * Math.cos(R) - A.getY() * Math.sin(R));
		A.setY(A.getX() * Math.sin(R) + A.getY() * Math.cos(R));
		
		B.setX(B.getX() * Math.cos(R) - B.getY() * Math.sin(R));
		B.setY(B.getX() * Math.sin(R) + B.getY() * Math.cos(R));
		
		C.setX(C.getX() * Math.cos(R) - C.getY() * Math.sin(R));
		C.setY(C.getX() * Math.sin(R) + C.getY() * Math.cos(R));
		
		D.setX(D.getX() * Math.cos(R) - D.getY() * Math.sin(R));
		D.setY(D.getX() * Math.sin(R) + D.getY() * Math.cos(R));
		O.setLocation(O.getX() * Math.cos(R) - O.getY() * Math.sin(R),
					  O.getX() * Math.sin(R) + O.getY() * Math.cos(R));
	}

	@Override
	public void move(double dx, double dy) {
		A.setX(A.getX() + dx);
		A.setY(A.getY() + dy);
		setHeight(getHeight());
		setWidth(getWidth());
	}

	@Override
	public void zoom(double N) {
		this.setHeight(N * this.getHeight());
		this.setWidth(getWidth()* N);
	}

	@Override
	public double disc(double dx, double dy) {
		return Math.sqrt(Math.pow(O.getX() - dx, 2) + Math.pow(O.getY() - dy, 2));
	}
}
