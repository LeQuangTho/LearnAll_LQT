package gameMemory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class memory_Controller implements ActionListener, KeyListener {

	frame_Memory Frame;
	frame_Memory2 Frame2;
	memory_Home Home;
	memory_Home2 Home2;

	public void setMainFrame(frame_Memory Frame) {
		this.Frame = Frame;
	}
	
	public void setMainFrame(frame_Memory2 frame_Memory2) {
		this.Frame2 = frame_Memory2;
	}

	public void setMainFrame(memory_Home memory_Home) {
		this.Home = memory_Home;
	}

	public void setMainFrame(memory_Home2 memory_Home2) {
		this.Home2 = memory_Home2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		// Nguồn source
		if ("About".equals(cmd)) {
			memory_About about = new memory_About();
			about.setVisible(true);
		}

		// Close = CloseDefau
		if ("Close".equals(cmd)) {
			JDialog question = new JDialog();
			question.setVisible(true);
			question.setSize(300, 130);
			question.setLocation(500, 200);
			question.setResizable(false);

			JPanel main = new JPanel(new BorderLayout());
			JPanel botton = new JPanel(new GridLayout(1, 2));
			JLabel hoi = new JLabel("Bạn có muốn lưu và thoát không?");
			JButton yes = new JButton("Yes");
			JButton dontSave = new JButton("Don't Save");

			yes.setName("Saveout");
			dontSave.setName("noSave");

			hoi.setHorizontalAlignment(JLabel.CENTER);
			botton.add(yes);
			botton.add(dontSave);
			main.add(botton, BorderLayout.SOUTH);
			main.add(hoi, BorderLayout.CENTER);
			question.setContentPane(main);

			yes.addActionListener(this);
			dontSave.addActionListener(this);
		}

		if ("Reset".equals(cmd)) {
			JOptionPane.showMessageDialog(null, "Reset Game", "Message", JOptionPane.INFORMATION_MESSAGE);
			Frame.numberCoint.setText("0");
			Frame.numberHeart.setText("0");
			Frame.IO.writetStatus(Frame);
			Frame.resetGame();
		}

		if ("Save".equals(cmd)) {
			JOptionPane.showMessageDialog(null, "Đã Lưu", "Message", JOptionPane.INFORMATION_MESSAGE);
			Frame.IO.writetStatus(Frame);
		}

		if ("Help".equals(cmd)) {
			myDialog.help();
		}

		if (e.getSource() instanceof JButton) {
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
							if (Frame.first.getBt().getName().equals(Frame.bt[i].getBt().getName())
									|| Frame.last.getBt().getName().equals(Frame.bt[i].getBt().getName())) {
								Frame.bt[i].getBt().setVisible(false);
//								Frame.bt[i].getBt().setIcon(null);
								Frame.bt[i].setEat(true);
							}
						}
						int point = Integer.parseInt(Frame.point.getText()) + 1;
						Frame.point.setText("" + point);

						if (memory_Button.valiDateGame(Frame.bt))
							Frame.next(true);

						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
						myDialog.downMoves(Frame);
						myDialog.diemCao(Frame);
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
						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
						myDialog.downMoves(Frame);
						myDialog.diemCao(Frame);
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
						Frame.first = null;
						Frame.last = null;
						Frame.conti = false;
						myDialog.downMoves(Frame);
						myDialog.diemCao(Frame);
					}
				}
		}
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if ("Shop".equals(bt.getName())) {
				myDialog.Shop(Frame);
			}
		}

		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if ("Next".equals(bt.getName())) {
				Frame.IO.writetStatus(Frame);
				frame_Memory.lever++;
				Frame.refreshGame();
				Frame.loadGame();

				Frame.next(false);
			}
		}

		// Dialog trong game
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if ("Saveout".equals(bt.getName())) {
				Frame.IO.saveGame();
				System.exit(0);
			}
			if ("noSave".equals(bt.getName())) {
				System.exit(0);
			}
			if ("ok".equals(bt.getName())) {
				myDialog.closeOK();
				myDialog.gameOver(Frame);
				Frame.resetGame();
			}
			if ("regame".equals(bt.getName())) {
				myDialog.closeOver();
			}
		}

		// Check shop
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if ("buyClick".equals(bt.getName())) {
				myDialog.Check_Buy_Click(Frame);
			}
			if ("buyHeart".equals(bt.getName())) {
				myDialog.Check_Buy_Heart(Frame);
			}
		}

		// CheckModel
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if ("choimoi".equals(bt.getName())) {
				Home.setVisible(false);
				Home2 = new memory_Home2();
				Home2.setVisible(true);
			}
			if ("choitiep".equals(bt.getName())) {
				Home.setVisible(false);
				try {
					Frame = new frame_Memory();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Frame.setVisible(true);
			}
			if ("1player".equals(bt.getName())) {
				Home2.setVisible(false);
				try {
					Frame = new frame_Memory();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Frame.setVisible(true);
				Frame.resetGame();
			}
			if ("2player".equals(bt.getName())) {
				Home2.setVisible(false);
				try {
					Frame2 = new frame_Memory2();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Frame2.setVisible(true);
			}
		}
		
		if("Trick".equals(cmd)) {
			for (int i = 0; i < Frame.bt.length; i++) {
					try {
						String name_File = "F:\\JAVA\\Memory\\src\\gameMemory\\images\\";
						BufferedImage bi = ImageIO.read(new File(name_File + Frame.bt[i].getValue() + ".png"));
						ImageIcon icon = new ImageIcon(bi.getScaledInstance(Frame.bt[i].getBt().getWidth(),
								Frame.bt[i].getBt().getHeight(), Image.SCALE_SMOOTH));
						Frame.bt[i].getBt().setIcon(icon);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		}
		if("bien".equals(cmd)) {
			for (int i = 0; i < Frame.bt.length; i++) {
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
	}

	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
