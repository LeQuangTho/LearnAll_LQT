package gameMemory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class my_Dialog2 {

	static JDialog over;

	public static void gameOver(frame_Memory2 frame) {
		over = new JDialog();
		String[] n = frame.numberPoint.getText().split("-");
		int a = Integer.parseInt(n[0]);
		int b = Integer.parseInt(n[1]);
		String winer;
		
		if(a>b) winer = "Player 1 Winer!";
		else if(a<b) winer = "Player 2 Winer!";
		else winer = "Hòa!";
		if (frame.checkEnd()) {
			over.setVisible(true);
			over.setSize(300, 130);
			over.setTitle("Kết Thúc");
			over.setIconImage(new ImageIcon("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png").getImage());
			over.setLocation(500, 200);
			over.setResizable(false);

			JPanel main = new JPanel(new BorderLayout());
			JPanel botton = new JPanel(new GridLayout(1, 2));
			JLabel hoi = new JLabel("<html>" + winer
					+ "<br>Bạn có muốn chơi lại không?</html>");
			JButton yes = new JButton("Yes");
			JButton no = new JButton("No");

			yes.setName("choilai");
			no.setName("khongchoi");

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
	
	public static void closeOver() {
		over.setVisible(false);
		over = null;
	}
}
