package Sodoku_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Frame_2 extends JFrame {

	private static final long serialVersionUID = 1L;

	myButton3x3[][] broad = {
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() },
			{ new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3(),
					new myButton3x3(), new myButton3x3(), new myButton3x3(), new myButton3x3() } };

	JButton[] awser = { new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"), new JButton("5"),
			new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9") };

	File file = new File("F:\\JAVA\\Sodoku_HDT\\de.txt");

	Font textFont = new Font("Courrier", Font.BOLD, 32);
	Font buttonFont = new Font("Courrier", Font.PLAIN, 18);

	Border lineBorder = BorderFactory.createLineBorder(Color.black);
	Sodoku_2_IO io = new Sodoku_2_IO();
	Controller_2 cont = new Controller_2();
	Sodoku_2_MenuBar menuBar = new Sodoku_2_MenuBar(cont);
	String name = "";
	myButton3x3 button = new myButton3x3();
	Check_game check_game = new Check_game();

	public Frame_2() {
		super();
		this.setIconImage(new ImageIcon("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\sudoku.png").getImage());
		this.setLocation(200, 100);
		this.setSize(400, 500);
		this.setTitle("Sodoku 2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cont.setMainFrame(this);
		this.setResizable(false);
		init();
	}

	public void init() {
		JPanel mainJPanel = new JPanel(new BorderLayout(30, 30));
		JPanel center = new JPanel(new GridLayout(9, 9));
		JPanel button = new JPanel(new GridLayout(3, 3, 30, 0));
		int k = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				broad[i][j].setBorder(lineBorder);
				broad[i][j].setFont(buttonFont);
				if (broad[i][j].getReserved() == true) broad[i][j].setBackground(Color.RED);
				else broad[i][j].setBackground(new Color(222, 184, 184));
				broad[i][j].setName("" + k);
				broad[i][j].addActionListener(cont);
				center.add(broad[i][j].getButton());
				k++;
			}
		}
		for (JButton jButton : awser) {
			jButton.addActionListener(cont);
			jButton.setName("awser");
			jButton.setPreferredSize(new Dimension(50, 30));
			button.add(jButton);
		}

		io.readData(broad, file);
		io.readZone(broad);
		io.writeData(broad);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (broad[i][j].getReserved() == true) broad[i][j].setBackground(new Color(222, 184, 0));
				else broad[i][j].setBackground(new Color(222, 184, 184));
			}
		}
		mainJPanel.add(center, BorderLayout.CENTER);
		mainJPanel.add(button, BorderLayout.SOUTH);
		mainJPanel.add(menuBar, BorderLayout.NORTH);
		this.setContentPane(mainJPanel);
	}
}
