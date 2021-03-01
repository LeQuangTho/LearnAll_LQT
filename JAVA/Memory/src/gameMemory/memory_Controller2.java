package gameMemory;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class memory_Controller2 implements ActionListener{
	frame_Memory2 Frame;
	
	public void setMainFrame(frame_Memory2 frame_Memory2) {
		this.Frame = frame_Memory2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton bt = (JButton) e.getSource();
			if (memory_Button.checkButtum(bt))
				if (Frame.conti == false) {
					Frame.first = new memory_Button();
					Frame.first.setBt(bt);
					for (int i = 0; i < Frame.bt.length; i++) {
						if (bt.getName().equals(Frame.bt[i].getBt().getName())) {
							try {
								String name_File = "F:\\JAVA\\Memory\\src\\gameMemory\\images\\";
								BufferedImage bi = ImageIO.read(new File(name_File + Frame.bt[i].getValue() + ".png"));
								ImageIcon icon = new ImageIcon(bi.getScaledInstance(Frame.bt[i].getBt().getWidth(),
										Frame.bt[i].getBt().getHeight(), Image.SCALE_SMOOTH));
								Frame.bt[i].getBt().setIcon(icon);
								Frame.first.setValue(Frame.bt[i].getValue());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							break;
						}
					}
					Frame.conti = true;
				} else {
					Frame.last = new memory_Button();
					Frame.last.setBt(bt);

					for (int i = 0; i < Frame.bt.length; i++) {
						if (bt.getName().equals(Frame.bt[i].getBt().getName())) {
							try {
								String name_File = "F:\\JAVA\\Memory\\src\\gameMemory\\images\\";
								BufferedImage bi = ImageIO.read(new File(name_File + Frame.bt[i].getValue() + ".png"));
								ImageIcon icon = new ImageIcon(bi.getScaledInstance(Frame.bt[i].getBt().getWidth(),
										Frame.bt[i].getBt().getHeight(), Image.SCALE_SMOOTH));
								Frame.bt[i].getBt().setIcon(icon);
								Frame.last.setValue(Frame.bt[i].getValue());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							break;
						}
					}

					// check ảnh giống nhau
					if (memory_Button.valiDateImage(Frame.first, Frame.last) == 2) {
						JOptionPane.showMessageDialog(Frame, "Đúng Rồi", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);

						for (int i = 0; i < Frame.bt.length; i++) {
							if (memory_Button.valiDateImage(Frame.last, Frame.bt[i]) == 1
									|| memory_Button.valiDateImage(Frame.first, Frame.bt[i]) == 1) {
								Frame.bt[i].setEat(true);
								Frame.bt[i].getBt().setVisible(false);
							}
						}
						Frame.upPoint();
						my_Dialog2.gameOver(Frame);
						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
						Frame.swap();
						
					}

					// Check hai ảnh khác nhau
					else if (memory_Button.valiDateImage(Frame.first, Frame.last) == 3) {
						JOptionPane.showMessageDialog(Frame, "Sai Rồi", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
						for (int i = 0; i < Frame.bt.length; i++) {
							if (Frame.first.getBt().getName().equals(Frame.bt[i].getBt().getName())
									|| Frame.last.getBt().getName().equals(Frame.bt[i].getBt().getName())) {
								try {
									BufferedImage bi = ImageIO
											.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png"));
									ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
									Frame.bt[i].getBt().setIcon(icon);
								} catch (IOException e2) {
									e2.printStackTrace();
								}
							}
						}
						Frame.swap();
						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
					}
					// Check DoubleClick
					else if (memory_Button.valiDateImage(Frame.first, Frame.last) == 1) {
						for (int i = 0; i < Frame.bt.length; i++) {
							if (Frame.first.getBt().getName().equals(Frame.bt[i].getBt().getName())) {
								try {
									BufferedImage bi = ImageIO
											.read(new File("F:\\JAVA\\Memory\\src\\gameMemory\\images\\tom.png"));
									ImageIcon icon = new ImageIcon(bi.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
									Frame.bt[i].getBt().setIcon(icon);
								} catch (IOException e2) {
									e2.printStackTrace();
								}
							}
						}
						Frame.swap();
						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
					}
				}
		}
		
		if(e.getSource() instanceof JButton){
			JButton bt = (JButton) e.getSource();
			if("khongchoi".equals(bt.getName())) System.exit(0);
			else if("choilai".equals(bt.getName())) 
				{
					my_Dialog2.closeOver();
					Frame.resetGame();
				}
		}
	}
}
