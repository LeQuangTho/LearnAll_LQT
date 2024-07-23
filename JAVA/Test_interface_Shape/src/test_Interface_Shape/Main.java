package test_Interface_Shape;

public class Main {

	public static void main(String[] args) {
		// Test lớp điểm
		Point a = new Point(1, 1);
		System.out.println("Test điểm: ");
		System.out.println(a.toString());
		System.out.println("Diện tích:  " + a.area());
		System.out.println("Chu vi: " + a.circ());
		a.move(3, 5);
		System.out.println("Tọa độ sau khi di chuyển: " + a.toString());
		a.rotate(40);
		System.out.println("Tọa độ sau khi Xoay: " + a.toString());
		a.zoom(4);
		System.out.println("Tọa độ sau khi Zoo: " + a.toString());
		System.out.printf("Khoảng cách tới gốc %.4f \n", a.disc(0, 0));

		// Test lớp Hình trong
		Circle circle = new Circle(1, 1, 5);
		System.out.println("\n\n\nTest hình tròn");
		System.out.println(circle.toString());
		System.out.printf("Diện tích:  %.4f\n", circle.area());
		System.out.printf("Chu vi: %.4f\n", circle.circ());
		circle.move(3, 5);
		System.out.println("Tọa độ sau khi di chuyển: " + circle.toString());
		circle.rotate(40);
		System.out.println("Tọa độ sau khi Xoay: " + circle.toString());
		circle.zoom(4);
		System.out.println("Tọa độ sau khi Zoo: " + circle.toString());
		System.out.printf("Khoảng cách tới gốc %.4f \n", circle.disc(0, 0));
		
		
		//Test lớp hình chữ nhật
		Rectangle rectangle = new Rectangle(1,1,1,1); 
		System.out.println("\n\n\nTest hình chữ nhật");
		System.out.println(rectangle.toString());
		System.out.printf("Diện tích:  %.4f\n", rectangle.area());
		System.out.printf("Chu vi: %.4f\n", rectangle.circ());
		rectangle.move(3, 5);
		System.out.println("Tọa độ sau khi di chuyển: " + rectangle.toString());
		rectangle.rotate(90);
		System.out.println("Tọa độ sau khi Xoay: " + rectangle.toString());
		rectangle.zoom(2);
		System.out.println("Tọa độ sau khi Zoo: " + rectangle.toString());
		System.out.printf("Khoảng cách tới gốc %.4f \n", rectangle.disc(0, 0));
		
	}
}
