package Sodoku_2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame_About extends JFrame {

	private static final long serialVersionUID = 1L;
	ImageIcon iconc = new ImageIcon("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\tho.jpg");
	public Frame_About() {
		this.setLocation(500, 100);
		this.setSize(300, 300);
		this.setTitle("About");
		this.setResizable(false);
		init();
	}

	private void init() {
		JPanel main = new JPanel();
		JLabel jLabel = new JLabel();
		JLabel jLabel2 = new JLabel();
		jLabel2.setAlignmentX(CENTER_ALIGNMENT);
		jLabel2.setText("by Lê Quang Thọ");
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\tho.jpg"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			jLabel.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		main.add(jLabel2);
		main.add(jLabel);
		this.setContentPane(main);
	}
}
