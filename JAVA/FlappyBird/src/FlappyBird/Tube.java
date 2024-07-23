package FlappyBird;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Tube extends JPanel {

	private static int x1 = 500, x2 = x1 + 140, x3 = x2 + 140, x4 = x3 + 140;

	private static int h1, h2, h3, h4;

	private BufferedImage tubeU, tubeD;

	private static boolean b1 = false;
	private static boolean b2 = false;
	private static boolean b3 = false;
	private static boolean b4 = false;

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX3() {
		return x3;
	}

	public int getX4() {
		return x4;
	}

	public int getH1() {
		return h1;
	}

	public int getH2() {
		return h2;
	}

	public int getH3() {
		return h3;
	}

	public int getH4() {
		return h4;
	}

	public void ranDom_H() {
		Random rd = new Random();

		if (b1 == false) {
			h1 = rd.nextInt(200);
			b1 = true;
		}

		if (b2 == false) {
			h2 = rd.nextInt(200);
			b2 = true;
		}
		if (b3 == false) {
			h3 = rd.nextInt(200);
			b3 = true;
		}
		if (b4 == false) {
			h4 = rd.nextInt(200);
			b4 = true;
		}
	}

	public void paint(Graphics g) {

		ranDom_H();

		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeU.png"));
			g.drawImage(tubeU, x1, 0, 50, h1, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * g.setColor(Color.green); g.fillRect(x1, 0, 50, h1);
		 */
		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeD.png"));
			g.drawImage(tubeU, x1, h1 + 150, 50, 500, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * g.setColor(Color.green); g.fillRect(x1, h1+150, 50, 500);
		 */

		/*
		 * g.setColor(Color.green); g.fillRect(x2, 0, 50, h2);
		 */
		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeU.png"));
			g.drawImage(tubeU, x2, 0, 50, h2, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * g.setColor(Color.green); g.fillRect(x2, h2+150, 50, 500);
		 */
		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeD.png"));
			g.drawImage(tubeU, x2, h2 + 150, 50, 500, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * g.setColor(Color.green); g.fillRect(x3, 0, 50, h3);
		 */

		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeU.png"));
			g.drawImage(tubeU, x3, 0, 50, h3, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * g.setColor(Color.green); g.fillRect(x3, h3+150, 50, 500);
		 */

		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeD.png"));
			g.drawImage(tubeU, x3, h3 + 150, 50, 500, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * g.setColor(Color.green); g.fillRect(x4, 0, 50, h4);
		 */

		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeU.png"));
			g.drawImage(tubeU, x4, 0, 50, h4, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * g.setColor(Color.green); g.fillRect(x4, h4+150, 50, 500);
		 */
		try {
			tubeU = ImageIO.read(new File("F:/JAVA/FlappyBird/res/tubeD.png"));
			g.drawImage(tubeU, x4, h4 + 150, 50, 500, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void giamX() {
		x1--;
		x2--;
		x3--;
		x4--;
	}

	public void tangX() {
		x1++;
		x2++;
		x3++;
		x4++;
	}

	public void laplai() {
		if (x1 == -50) {
			x1 = 500;
			b1 = false;
		}
		if (x2 == -50) {
			x2 = 500;
			b2 = false;
		}
		if (x3 == -50) {
			x3 = 500;
			b3 = false;
		}
		if (x4 == -50) {
			x4 = 500;
			b4 = false;
		}
	}
}
