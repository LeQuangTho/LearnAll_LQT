package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	
	JPanel zone1 = new JPanel();
	JPanel zone2 = new JPanel();
	JPanel zone3 = new JPanel();
	JPanel zone4 = new JPanel();
	JPanel zone5 = new JPanel();
	JPanel zone6 = new JPanel();
	JPanel zone7 = new JPanel();
	JPanel zone8 = new JPanel();
	JPanel zone9 = new JPanel();
	Zone z1 = new Zone();
	Zone z2 = new Zone();
	Zone z3 = new Zone();
	Zone z4 = new Zone();
	Zone z5 = new Zone();
	Zone z6 = new Zone();
	Zone z7 = new Zone();
	Zone z8 = new Zone();
	Zone z9 = new Zone();
	
	sodokuMenu menu = new sodokuMenu();
	
	public Controller controller = new Controller();
	
	public myFrame() {
		super("Sudoku");
		this.init();
	}

	private void init() {
		this.setLocation(400, 100);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//Khởi tạo các vùng
		JPanel mainPanel = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		//Xét layout cho main và center
		mainPanel.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
		
		//Xác định vị trí cho Center và South
		mainPanel.add(center, BorderLayout.CENTER);
		mainPanel.add(south, BorderLayout.SOUTH);
		
		//Khởi tạo buttom
		
		
		//Khởi tạo zone
		JPanel zone1 = new JPanel();
		JPanel zone2 = new JPanel();
		JPanel zone3 = new JPanel();
		JPanel zone4 = new JPanel();
		JPanel zone5 = new JPanel();
		JPanel zone6 = new JPanel();
		JPanel zone7 = new JPanel();
		JPanel zone8 = new JPanel();
		JPanel zone9 = new JPanel();
		
		//Xét layout cho zone
		zone1.setLayout(new GridLayout(3, 3));
		zone2.setLayout(new GridLayout(3, 3));
		zone3.setLayout(new GridLayout(3, 3));
		zone4.setLayout(new GridLayout(3, 3));
		zone5.setLayout(new GridLayout(3, 3));
		zone6.setLayout(new GridLayout(3, 3));
		zone7.setLayout(new GridLayout(3, 3));
		zone8.setLayout(new GridLayout(3, 3));
		zone9.setLayout(new GridLayout(3, 3));
		
		//Xét backgroud cho từng vùng
		zone1.setBackground(Color.gray);
		zone3.setBackground(Color.gray);
		zone5.setBackground(Color.gray);
		zone7.setBackground(Color.gray);
		zone9.setBackground(Color.gray);
		zone2.setBackground(Color.white);
		zone4.setBackground(Color.white);
		zone6.setBackground(Color.white);
		
		//Đẩy zone vào center
		center.add(zone1);
		center.add(zone2);
		center.add(zone3);
		center.add(zone4);
		center.add(zone5);
		center.add(zone6);
		center.add(zone7);
		center.add(zone8);
		center.add(zone9);
		
		//Tạo các TextField
		
		
		//Tạo hộp
		z1.creatZone(zone1,1,controller);
		z2.creatZone(zone2,2,controller);
		z3.creatZone(zone3,3,controller);
		z4.creatZone(zone4,4,controller);
		z5.creatZone(zone5,5,controller);
		z6.creatZone(zone6,6,controller);
		z7.creatZone(zone7,7,controller);
		z8.creatZone(zone8,8,controller);
		z9.creatZone(zone9,9,controller);
		
		//Đẩy buttom vào south
		south.add(btn1);
		south.add(btn2);
		south.add(btn3);
		south.add(btn4);
		south.add(btn5);
		south.add(btn6);
		south.add(btn7);
		south.add(btn8);
		south.add(btn9);
		
		//đẩy main vào phần Content của cửa sổ 
		this.setJMenuBar(menu);
		this.setContentPane(mainPanel);
		
		//Sự kiện
		
		controller.setMf(this);
		
		z1.txt1.addActionListener(controller);
		
		btn1.addActionListener(controller);
		btn2.addActionListener(controller);
		btn3.addActionListener(controller);
		btn4.addActionListener(controller);
		btn5.addActionListener(controller);
		btn6.addActionListener(controller);
		btn7.addActionListener(controller);
		btn8.addActionListener(controller);
		btn9.addActionListener(controller);
	}
}
