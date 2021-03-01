package gameMemory;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class memory_Button {
	private JButton bt = new JButton();
	private String value;
	private boolean eat = false;
	public memory_Button() {
		super();
		try {
			BufferedImage bi = ImageIO.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png"));
			ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
			this.bt.setIcon(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setBt(JButton bt) {
		this.bt = bt;
	}

	public JButton getBt() {
		return bt;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean equals(memory_Button button) {
		if(//!this.getBt().getName().equals(button.getBt().getName()) || 
				!(this.getValue().equals(button.getValue()))) {
			return false;
		}else {
			return true;
		}
	}
	public boolean equalsImages(memory_Button button) {
		if(!this.getValue().equals(button.getValue())) {
			return false;
		}else {
			return true;
		}
	}

	public boolean isEat() {
		return eat;
	}

	public void setEat(boolean eat) {
		this.eat = eat;
	}
	
	public static boolean valiDateGame(memory_Button[] game) {
		for (memory_Button memory_Button : game) {
			if (memory_Button.isEat() == false) return false;
		}
		return true;
	}
	
	public static int valiDateImage(memory_Button game, memory_Button game2) {
		if (game.getBt().getName().equals(game2.getBt().getName())
				&& game.getValue().equals(game2.getValue())) return 1;
		if (!game.getBt().getName().equals(game2.getBt().getName())
				&& game.getValue().equals(game2.getValue())) return 2;
		else if (!game.getBt().getName().equals(game2.getBt().getName())
				&& !game.getValue().equals(game2.getValue())) return 3;
		return 0;
	}
	
	public static boolean checkButtum(JButton bt) {
		if ("Shop".equals(bt.getName())) return false;
		if("Next".equals(bt.getName())) return false;
		if("Saveout".equals(bt.getName())) return false;
		if("noSave".equals(bt.getName())) return false;
		if("regame".equals(bt.getName())) return false;
		if("ok".equals(bt.getName())) return false;
		if("buyClick".equals(bt.getName())) return false;
		if("buyHeart".equals(bt.getName())) return false;
		if("choimoi".equals(bt.getName())) return false;
		if("choitiep".equals(bt.getName())) return false;
		if("1player".equals(bt.getName())) return false;
		if("2player".equals(bt.getName())) return false;
		if("choilai".equals(bt.getName())) return false;
		if("khongchoi".equals(bt.getName())) return false;
			return true;
	}
}
