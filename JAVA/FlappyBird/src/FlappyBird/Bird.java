package FlappyBird;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bird extends JPanel {
	private static int y = 200;
	private static int x = 100;
	private BufferedImage flapU, flapD;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void paintU(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect(x, y, 30, 30);
		try {
			flapU = ImageIO.read(new File("F://JAVA//FlappyBird//res//bird.png"));
			g.drawImage(flapU, x, y, 35, 35, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tangY() {
		y += 3;
	}

	public void giamY() {
		y -= 50;
	}
}
