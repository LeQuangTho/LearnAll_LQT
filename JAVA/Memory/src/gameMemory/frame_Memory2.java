package gameMemory;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class frame_Memory2 extends JFrame {

	private static final long serialVersionUID = 1L;

	// Các Comp và Panel
	JPanel board = new JPanel(new GridLayout(6, 6, 5, 5));
	JLabel numberPoint = new JLabel("0-0");
	JLabel player = new JLabel("Turn Player 1");
	
	// Các biến
	int[] game = new int[36];
	memory_Button[] bt = new memory_Button[36];
	memory_IO IO = new memory_IO();
	memory_Controller2 cont = new memory_Controller2();
	memory_Button first = null;
	memory_Button last = null;
	boolean conti = false;
	boolean turn = false;

	
	public frame_Memory2() throws MalformedURLException {
		super();
		this.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png").getImage());
		this.setLocation(400, 50);
		this.setSize(500, 650);
		this.setTitle("Memory");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cont.setMainFrame(this);
		this.setResizable(false);
		init();
	}

	private void init() throws MalformedURLException {
		File file = new File("F:\\JAVA\\Memory\\src\\gameMemory\\sound\\2.wav");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        clip.loop();
		JPanel main = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel Top = new JPanel(new GridLayout(1, 3));
		JPanel point = new JPanel(new BorderLayout());
		JLabel player1 = new JLabel();
		JLabel player2 = new JLabel();
		
		// Set Border
		Top.setBorder(BorderFactory.createTitledBorder("MEMORY"));
		Top.setPreferredSize(new Dimension(480, 100));
		
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\bangdemso1.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(150, 70, Image.SCALE_SMOOTH));
			player1.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\bangdemso2.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(180, 70, Image.SCALE_SMOOTH));
			player2.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		numberPoint.setFont(new Font("điểm", Font.BOLD, 30));
		numberPoint.setHorizontalAlignment(SwingConstants.CENTER);
		
		player.setHorizontalAlignment(SwingConstants.CENTER);
		point.add(numberPoint,BorderLayout.CENTER);
		point.add(player,BorderLayout.SOUTH);
		
		Top.add(player1);
		Top.add(point);
		Top.add(player2);
		
		// Tạo Game
		loadGame();

		// setting add Các Panel
		center.add(Top, BorderLayout.NORTH);
		center.add(board, BorderLayout.CENTER);
		main.add(center, BorderLayout.CENTER);

		this.setContentPane(main);
	}

	// Set game
	public void loadGame() {
		IO.readData(bt,"2player");
		for (int i = 0; i < bt.length; i++) {
			bt[i].getBt().setName("" + i);
			board.add(bt[i].getBt());
			bt[i].getBt().addActionListener(cont);
		}
		board.setBorder(BorderFactory.createTitledBorder("Game zui ze"));
		board.revalidate();
		board.repaint();
	}

	// Làm mới game
	public void refreshGame() {
		for (int i = 0; i < bt.length; i++) {
			bt[i].getBt().removeActionListener(cont);
			board.remove(bt[i].getBt());
		}
		board.revalidate();
		board.repaint();
	}

	public void resetGame() {
		refreshGame();
		conti = false;
		numberPoint.setText("0-0");
		turn = false;
		player.setText("Turn Player 1");
		loadGame();
	}
	
	public void upPoint() {
		String[] data = this.numberPoint.getText().split("-");
		int a = Integer.parseInt(data[0]);
		int b = Integer.parseInt(data[1]);
		if(turn) {
			this.numberPoint.setText(a + "-" +(b+1));
		} else {
			this.numberPoint.setText((a+1) + "-" + b);
		}
	}
	
	public void swap() {
		if(turn) {
			turn = false;
			player.setText("Turn Player 1");
		} else {
			turn = true;
			player.setText("Turn Player 2");
		}
	}
	
	public boolean checkEnd() {
		for (int i = 0; i < bt.length; i++) {
			if(bt[i].isEat() == false) return false;
		}
		return true;
	}
}
