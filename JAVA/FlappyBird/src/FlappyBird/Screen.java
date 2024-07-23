package FlappyBird;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Screen extends JFrame { // lớp Screen thừa kế lớp JFrame

	private Backgroud backgroud = new Backgroud();
	private Bird bird = new Bird();

	// phương thức tạo
	public Screen() {
		setSize(500, 500); // kích thước
		setVisible(true); // cho phép nhìn thấy
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hoạt động đóng mặc định
		setLocation(400, 100); // vị trí mặc định
		add(backgroud);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				bird.giamY();
			}

		});
	}

	// phương thức main

	public static void main(String[] args) {
		Screen mh = new Screen();
	}

}
