package baiTapTuan3;

public class Traiangle {
	private Point A, B, C, O;
	private double Hight;
	private double dBottom;

	// Contractor
	public Traiangle(double x, double y, double hight, double dBottom) {
		super();
		A.setX(x);
		A.setY(y);

		B.setX(A.getX() + x / 2);
		B.setY(A.getY() + y);

		C.setX(A.getX() + x);
		C.setY(y);

		O.setX(B.getX());
		O.setY(B.getY() - y * 2 / 3);
		Hight = hight;
		this.dBottom = dBottom;
	}

	// set get
	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

	public double getHight() {
		return Hight;
	}

	public void setHight(double hight) {
		Hight = hight;
	}

	public double getdBottom() {
		return dBottom;
	}

	public void setdBottom(double dBottom) {
		this.dBottom = dBottom;
	}

	@Override
	public String toString() {
		return "Traiangle [A=" + A + ", B=" + B + ", C=" + C + ", Hight=" + Hight + ", dBottom=" + dBottom + "]";
	}

	// dien tich
	public double area() {
		return (dBottom / 2) * Hight;
	}

	// chu vi
	public double circ() {
		double a, b, c;
		a = A.distance(B.getX(), B.getY());
		b = B.distance(C.getX(), C.getY());
		c = C.distance(A.getX(), A.getY());
		return a + b + c;
	}

	// Khoảng cách
	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(x - O.getX(), 2) + Math.pow(y - O.getY(), 2));
	}

	public void move(double x, double y) {
		A.setX(x + A.getX());
		A.setY(y + A.getY());
		B.setX(x + B.getX());
		B.setY(y + B.getY());
		C.setX(x + C.getX());
		C.setY(y + C.getY());
		O.setX(x + O.getX());
		O.setY(y + O.getY());
	}
	
	public void rotate(double a) {
		A.setX(A.getX() * Math.cos(a) - A.getY() * Math.sin(a));
		A.setY(A.getX() * Math.sin(a) + A.getY() * Math.cos(a));
		
		B.setX(B.getX() * Math.cos(a) - B.getY() * Math.sin(a));
		B.setY(B.getX() * Math.sin(a) + B.getY() * Math.cos(a));
		
		C.setX(C.getX() * Math.cos(a) - C.getY() * Math.sin(a));
		C.setY(C.getX() * Math.sin(a) + C.getY() * Math.cos(a));
		
		O.setX(O.getX() * Math.cos(a) - O.getY() * Math.sin(a));
		O.setY(A.getX() * Math.sin(a) + O.getY() * Math.cos(a));
	}
	
	public void zoom( double n) {
		
		// sẽ cài đặt khi tưởng minh thuật toán
		/*
		 * A.setX(x + A.getX()); A.setY(y + A.getY()); B.setX(x + B.getX()); B.setY(y +
		 * B.getY()); C.setX(x + C.getX()); C.setY(y + C.getY());
		 */
	}
}
