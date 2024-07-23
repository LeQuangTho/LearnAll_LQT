package baiTapTuan3;

//lớp điểm
public class Point {
	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this.x = 0;
		this.y = 0;
	}

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

	/*
	 * khoảng cách về O; phương thức này trả về khoảng cách từ điểm đó về gốc tọa độ
	 */
	public double getDistanceOrigin() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}

	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(this.getX() - x, 2) + Math.pow(this.getX() - x, 2));
	}

	// phép rời hình của một điểm
	public void setMove(double x, double y) {
		setX(getX() + x);
		setY(getY() + y);
	}

	// TEST
	/*
	 * public static void main(String[] args) { Point point = new Point();
	 * point.setX(3); point.setY(0); point.setMove(1, 1); System.out.println(" " +
	 * point.getX() + " , " + point.getY()); }
	 */
}
