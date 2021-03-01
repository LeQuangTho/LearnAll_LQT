package gameMemory;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.Constants;

public class frame_Memory extends JFrame {

	private static final long serialVersionUID = 1L;

	// Layout
	public GridLayout layout = new GridLayout();

	// Các Comp và Panel
	JPanel board = new JPanel();
	JLabel point = new JLabel("0");
	JTextField numberCoint = new JTextField("1000");
	JTextField numberMoves = new JTextField();
	JTextField numberMax = new JTextField();
	JLabel numberHeart = new JLabel("0");
	JButton next = new JButton();
	
	// Các biến
	int[] game = null;
	memory_Button[] bt = null;
	memory_IO IO = new memory_IO();
	memory_Controller cont = new memory_Controller();
	memory_Menu menu = new memory_Menu(cont);
	memory_Button first = null;
	memory_Button last = null;
	public static int COLUMN = 4;
	public static int ROW = 4;
	boolean conti = false;
	public static int lever = 1;
	public static int dem = 0;

	public frame_Memory() throws MalformedURLException {
		super();
		this.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png").getImage());
		this.setLocation(400, 50);
		this.setSize(470, 550);
		this.setTitle("Memory");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cont.setMainFrame(this);
		this.setResizable(false);
		IO.readtStatus(this);
		init();
	}
	
	private void init() throws MalformedURLException {
		File file = new File("F:\\JAVA\\Memory\\src\\gameMemory\\sound\\1.wav");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
		JPanel main = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel right = new JPanel();
		JPanel bottom = new JPanel();
		JLabel heart = new JLabel("Trợ giúp");
		JButton Shop = new JButton();
		JLabel banner = new JLabel();
		JLabel diem = new JLabel("Điểm");
		JLabel moves = new JLabel("  MOVES  ");
		JLabel coint = new JLabel("  COINT  ");
		JLabel max = new JLabel("  MAX  ");
		JLabel maxImage = new JLabel();
		JLabel cointImage = new JLabel();
		
		
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\banner.jpg"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(385, 70, Image.SCALE_SMOOTH));
			banner.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set Border
		banner.setBorder(BorderFactory.createTitledBorder("MEMORY"));

		bottom.setBorder(BorderFactory.createTitledBorder("Thành tích"));

		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\shop.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			Shop.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setting and add Shop
		Shop.setName("Shop");
		Shop.setPreferredSize(new Dimension(40, 40));
		Shop.setToolTipText("Đi chợ nào");
		bottom.add(Shop);

		// setting and add trợ giúp
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\heart.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			heart.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bottom.add(heart);

		numberHeart.setFont(new Font("Số Trợ Giúp", Font.BOLD, 15));
		numberHeart.setPreferredSize(new Dimension(70, 40));
		numberHeart.setEnabled(false);
		numberHeart.setBackground(bottom.getBackground());
		numberHeart.setBorder(null);
		bottom.add(numberHeart);

		// setting and add Điểm
		diem.setPreferredSize(new Dimension(50, 50));
		diem.setFont(new Font("Điểm", Font.LAYOUT_NO_START_CONTEXT, 15));
		bottom.add(diem, BorderLayout.WEST);

		point.setFont(new Font("Point", Font.BOLD, 15));
		point.setForeground(Color.RED);
		point.setPreferredSize(new Dimension(40, 40));
		bottom.add(point, BorderLayout.CENTER);

		// setting and add phần bên phải
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\cup.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			maxImage.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		numberMax.setPreferredSize(new Dimension(50, 30));
		numberMax.setHorizontalAlignment(SwingConstants.CENTER);
		numberMax.setBackground(Color.PINK);
		numberMax.setBorder(BorderFactory.createLineBorder(right.getBackground(), 2, true));
		numberMax.setEditable(false);
		right.add(maxImage);
		right.add(max);
		right.add(numberMax);
		
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\coint.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			cointImage.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		right.setPreferredSize(new Dimension(70, 600));
		right.setBorder(BorderFactory.createTitledBorder("Status"));
		numberCoint.setPreferredSize(new Dimension(30, 30));
		numberCoint.setHorizontalAlignment(SwingConstants.CENTER);
		numberCoint.setBackground(Color.WHITE);
		numberCoint.setBorder(BorderFactory.createLineBorder(right.getBackground(), 2, true));
		numberCoint.setEditable(false);
		right.add(cointImage);
		right.add(coint);
		right.add(numberCoint);
		
		numberMoves.setPreferredSize(new Dimension(30, 30));
		numberMoves.setHorizontalAlignment(SwingConstants.CENTER);
		numberMoves.setBackground(Color.WHITE);
		numberMoves.setBorder(BorderFactory.createLineBorder(right.getBackground(), 2, true));
		numberMoves.setEditable(false);
		right.add(moves);
		right.add(numberMoves);
		
		// Tạo Game
		loadGame();

		// setting and add Next
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\next.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			next.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		next.setEnabled(false);
		next.setName("Next");
		next.setPreferredSize(new Dimension(40, 40));
		next.addActionListener(cont);

		//setting add Các Panel
		 
		center.add(banner, BorderLayout.NORTH);

		bottom.add(next, BorderLayout.EAST);

		Shop.addActionListener(cont);
		center.add(board, BorderLayout.CENTER);
		center.add(right, BorderLayout.EAST);
		main.add(bottom, BorderLayout.SOUTH);
		main.add(center, BorderLayout.CENTER);

		this.setContentPane(main);
		this.setJMenuBar(menu);
	}

	// Set game
	public void loadGame() {
		layout.setColumns(COLUMN);
		layout.setRows(ROW);
		layout.setHgap(5);
		layout.setVgap(5);
		board.setLayout(layout);
		bt = new memory_Button[COLUMN * ROW];
		IO.readData(bt, "" + lever);
		for (int i = 0; i < bt.length; i++) {
			bt[i].getBt().setName("" + i);
			board.add(bt[i].getBt());
			bt[i].getBt().addActionListener(cont);
		}
		numberCoint.setText(""+(Integer.parseInt(numberCoint.getText()) + Integer.parseInt(point.getText())));
		numberMoves.setText(""+(ROW*COLUMN + Constants.MOVES));
		board.setBorder(BorderFactory.createTitledBorder("Lever " + lever));
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
		if (lever % 2 == 0)
			COLUMN++;
		else
			ROW++;
		if (COLUMN * ROW % 2 == 1) {
				ROW++;
		}
		bt = null;
		dem = 0;
	}

	public void next(boolean a) {
		this.next.setEnabled(a);
	}

	public void resetGame() {
		refreshGame();
		bt = null;
		ROW = 2;
		COLUMN = 2;
		conti = false;
		lever = 1;
		dem = 0;
		IO.writetStatus(this);
		point.setText("0");
		loadGame();
	}
}
