package test_Interface_Shape;

import java.awt.Point;

public interface Shape {
	Point O = new Point();

	public double area();

	public double circ();

	public double disc(double dx, double dy); 
	
	public void rotate(double R);

	public void zoom(double N);

	public void move(double x, double y);
}
