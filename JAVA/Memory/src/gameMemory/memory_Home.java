package gameMemory;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class memory_Home extends JFrame {

	private static final long serialVersionUID = 1L;
	memory_Controller cont = new memory_Controller();

	public memory_Home() {
		super();
		this.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png").getImage());
		this.setLocation(400, 50);
		this.setSize(470, 550);
		this.setTitle("Memory");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cont.setMainFrame(this);
		this.setResizable(false);
		init();
	}

	private void init() {
		JPanel main = new JPanel();
		JButton choi1 = new JButton("Chơi 1");
		JButton choi2 = new JButton("Chơi 2");
		JLabel a = null;
		
		main.setLayout(null);
		
		try {
			a = new JLabel(new ImageIcon(ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\Home.jpg"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		main.add(a);
		a.setSize(470, 550);
		choi1.setOpaque(true);
		choi1.setSize(222, 50);
		choi1.setLocation(20, 20);
		choi2.setOpaque(true);
		choi2.setSize(222, 50);
		choi2.setLocation(20, 90);
		
		choi1.setName("choitiep");
		choi2.setName("choimoi");
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\choitiep.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(300, 60, Image.SCALE_SMOOTH));
			choi1.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\choimoi.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(300, 70, Image.SCALE_SMOOTH));
			choi2.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		main.add(choi1);
		main.add(choi2);
		
		choi1.addActionListener(cont);
		choi2.addActionListener(cont);
		this.setContentPane(main);
		
	}
}
