package gameMemory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class myDialog {
	static JDialog over = null;
	static JDialog diemCao = null;
	static JDialog shop = null;

	public static void downMoves(frame_Memory frame) {
		int n = Integer.parseInt(frame.numberMoves.getText());
		frame.numberMoves.setText("" + (n - 1));
	}

	public static void gameOver(frame_Memory frame) {
		
		int n = Integer.parseInt(frame.numberMoves.getText());
		if (n - 1 < 0) {
			over = new JDialog();
			over.setVisible(true);
			over.setSize(300, 130);
			over.setLocation(500, 200);
			over.setResizable(false);

			JPanel main = new JPanel(new BorderLayout());
			JPanel botton = new JPanel(new GridLayout(1, 2));
			JLabel hoi = new JLabel("Bạn có muốn chơi lại không?");
			JButton yes = new JButton("Yes");
			JButton no = new JButton("No");

			yes.setName("regame");
			no.setName("noSave");

			hoi.setHorizontalAlignment(JLabel.CENTER);
			botton.add(yes);
			botton.add(no);
			main.add(botton, BorderLayout.SOUTH);
			main.add(hoi, BorderLayout.CENTER);
			over.setContentPane(main);

			yes.addActionListener(frame.cont);
			no.addActionListener(frame.cont);
		}
	}

	public static void diemCao(frame_Memory frame) {

		int n = Integer.parseInt(frame.numberMoves.getText());
		if (n - 1 < 0) {
			diemCao = new JDialog();
			diemCao.setVisible(true);
			diemCao.setSize(300, 130);
			diemCao.setLocation(500, 200);
			diemCao.setResizable(false);

			JPanel main = new JPanel(new BorderLayout());
			JPanel center = new JPanel(new BorderLayout());
			JPanel botton = new JPanel();
			JPanel botton2 = new JPanel();
			JLabel hoi = new JLabel("Điểm cao: " + frame.point.getText());
			JButton ok = new JButton("ok");

			ok.setName("ok");
			hoi.setHorizontalAlignment(JLabel.CENTER);
			botton2.add(ok);
			center.add(hoi, BorderLayout.CENTER);
			center.add(botton2, BorderLayout.SOUTH);
			botton.setPreferredSize(new Dimension(100, 10));
			main.add(botton, BorderLayout.SOUTH);
			main.add(center, BorderLayout.CENTER);
			diemCao.setContentPane(main);

			ok.addActionListener(frame.cont);
		}
	}

	public static void Shop(frame_Memory frame) {
		shop = new JDialog();
		shop.setVisible(true);
		shop.setSize(300, 300);
		shop.setLocation(500, 200);
		shop.setResizable(false);
		shop.setTitle("Mại vô! Mại Vô");
		shop.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\shop.png").getImage());
		JPanel main = new JPanel(new GridLayout(1, 2, 20, 20));
		JPanel shop1 = new JPanel(new BorderLayout());
		JPanel bottom1 = new JPanel();
		JPanel bottom2 = new JPanel();
		JPanel shop2 = new JPanel(new BorderLayout());
		JButton click = new JButton();
		JButton heart = new JButton();

		JLabel LBClick = new JLabel();
		JLabel LBClick2 = new JLabel();
		JLabel LBheart = new JLabel();
		JLabel LBheart2 = new JLabel();

		click.setName("buyClick");
		heart.setName("buyHeart");

		// Setting shop 1
		shop1.setBackground(Color.ORANGE);
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\click.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
			click.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		shop1.setBorder(BorderFactory.createLineBorder(null, 10, true));
		click.setBackground(Color.ORANGE);
		click.setBorder(null);
		LBClick.setText("10 coins =");
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\click.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			LBClick2.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		bottom1.setBackground(Color.ORANGE);
		bottom1.add(LBClick);
		bottom1.add(LBClick2);
		shop1.add(click, BorderLayout.CENTER);
		shop1.add(bottom1, BorderLayout.SOUTH);

		// Setting shop 2
		shop2.setBackground(Color.GREEN);
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\heart.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(80, 80, Image.SCALE_SMOOTH));
			heart.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		shop2.setBorder(BorderFactory.createLineBorder(null, 10, true));
		heart.setBackground(Color.GREEN);
		heart.setBorder(null);
		LBheart.setText("150 coins =");
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\heart.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			LBheart2.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LBheart.setForeground(Color.WHITE);
		bottom2.setBackground(Color.GREEN);
		bottom2.add(LBheart);
		bottom2.add(LBheart2);
		shop2.add(heart, BorderLayout.CENTER);
		shop2.add(bottom2, BorderLayout.SOUTH);

		main.setBackground(Color.DARK_GRAY);

		main.add(shop1);
		main.add(shop2);

		click.addActionListener(frame.cont);
		heart.addActionListener(frame.cont);
		shop.setContentPane(main);
	}

	public static boolean Check_Buy_Click(frame_Memory frame) {
		int n = Integer.parseInt(frame.numberCoint.getText());
		if (n - 10 >= 0) {
			frame.numberCoint.setText("" + (n - 10));
			frame.numberMoves.setText((Integer.parseInt(frame.numberMoves.getText()) + 1) + "");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Hết tiền rồi", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	public static boolean Check_Buy_Heart(frame_Memory frame) {
		int n = Integer.parseInt(frame.numberCoint.getText());
		if (n - 150 >= 0) {
			frame.numberCoint.setText("" + (n - 150));
			frame.numberHeart.setText((Integer.parseInt(frame.numberHeart.getText()) + 1) + "");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Hết tiền rồi", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}

	public static void help() {
		JDialog help = new JDialog();
		help = new JDialog();
		help.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\question.png").getImage());
		help.setTitle("Luật chơi");
		help.setVisible(true);
		help.setSize(300, 200);
		help.setLocation(500, 200);
		help.setResizable(false);

		JPanel main = new JPanel(new BorderLayout());
		main.setBackground(Color.DARK_GRAY);
		
		String a = "<html>bạn hãy tìm cố gắng tìm các"
				+ "<br>ô có hình giống nhau nhé,"
				+ "<br> quan trọng là ở cái đầu"
				+ "<br> Haha"
				+ "<br>bạn có thể mua tym cho đẹp :))"
				+ "<br>Phải lật hết các ô trong bàn"
				+ "<br> thì nút Next mới hiện nha"
				+ "<br> <br>@byLeQuangTho</html>";
		
		JLabel continer = new JLabel(a);
		continer.setHorizontalAlignment(SwingConstants.CENTER);
		continer.setForeground(Color.WHITE);
		main.add(continer, BorderLayout.CENTER);
		help.setContentPane(main);
	}

	public static void closeOK() {
		diemCao.setVisible(false);
		diemCao = null;
	}

	public static void closeOver() {
		over.setVisible(false);
		over = null;
	}

}
