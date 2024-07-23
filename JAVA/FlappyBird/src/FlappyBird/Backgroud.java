package FlappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Backgroud extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bird bird = new Bird();
	private Tube tube = new Tube();
	private Check check = new Check();
	private addPoint Point = new addPoint();
	private BufferedImage bg, dat;

	Thread thread = new Thread(this);

	public Backgroud() {

		thread.start();
	}

	public void paint(Graphics g) {
//		g.setColor(Color.cyan);
//		g.fillRect(0, 0, getWidth(), getHeight());
		try {
			bg = ImageIO.read(new File("F:\\JAVA\\FlappyBird\\res\\BG.png"));
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		tube.paint(g);

		/*
		 * g.setColor(Color.green); g.fillRect(0, 400, getWidth(), getHeight());
		 * 
		 * g.setColor(Color.orange); g.fillRect(0, 410, getWidth(), getHeight());
		 */

		try {
			dat = ImageIO.read(new File("F:\\JAVA\\FlappyBird\\res\\dat.png"));
			g.drawImage(dat, 0, 400, null);
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

		g.setColor(Color.yellow);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(" " + Point.getPoint(), 10, 100);

		bird.paintU(g);

		bird.tangY();
	}

	public void run() {
		while (true) {
			repaint();
			tube.giamX();
			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (check.died() == true)
				thread.stop();

			Point.congdiem();

			tube.laplai();
		}
	}
}
