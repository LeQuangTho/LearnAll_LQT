package Sodoku_2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller_2 implements ActionListener,MouseListener {
	Frame_2 Frame;

	public void setMainFrame(Frame_2 Frame) {
		this.Frame = Frame;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if ("Close".equals(cmd)) {
			System.exit(0);
		}
		if ("Lever".equals(cmd)) {
			// JPanel panel = new JPanel();
			// JLabel jLabel = new JLabel();
			JFileChooser chooser = new JFileChooser("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\Lever");
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (.txt)", "txt"));
			int n = chooser.showOpenDialog(Frame);

			if (n == JFileChooser.APPROVE_OPTION) {
				File fileTwo = chooser.getSelectedFile();
				Frame.io.readData(Frame.broad, fileTwo);
			}
			// TODO đoạn này sẽ mở ra các lever khác nhau
		}

		if ("Reset".equals(cmd)) {
			// TODO load lại file gốc
		}

		if ("3x3".equals(cmd)) {
			// TODO tùy chỉnh kích thước 3x3
		}

		if ("6x6".equals(cmd)) {
			// TODO tùy chỉnh kích thước 6x6
		}

		if ("9x9".equals(cmd)) {
			// TODO tùy chỉnh kích 9x9
		}

		
		
		if ("Continue".equals(cmd)) {
			System.out.println("mở đã lưu");
			File file = new File("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\Lever\\saving.txt");
			Frame.io.readDataSaving(Frame.broad, file);
			}
		
		if("Save".equals(cmd)) {
			System.out.println("đã lưu");
			File file = new File("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\Lever\\saving.txt");
			Frame.io.writeDataSaving(Frame.broad, file);
		}
		
		if ("About".equals(cmd)) {
			Frame_About about = new Frame_About();
			about.setVisible(true);
		}
		
		if ("Help".equals(cmd)) {
			
		}
		
		if("Open DB".equalsIgnoreCase(cmd)) {
			JOptionPane.showMessageDialog(Frame, "Nạp DataBase", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
		}
		
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (!"awser".equals(button.getName())) {
				for (int n = 0; n < 9; n++) {
					for (int m = 0; m < 9; m++) {
						Frame.broad[Frame.button.getRow()][m].setBackground(new Color(222, 184, 184));
						Frame.broad[n][Frame.button.getColumn()].setBackground(new Color(222, 184, 184));
						if (Frame.broad[n][m].getZone() == Frame.button.getZone()) {
							Frame.broad[n][m].setBackground(new Color(222, 184, 184));
						}
						if (Frame.broad[n][m].getReserved() == true) Frame.broad[n][m].setBackground(new Color(222, 184, 0));
						else Frame.broad[n][m].setBackground(new Color(222, 184, 184));
					}
				}
				Frame.name = button.getName();
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (Frame.broad[i][j].getName().equals(Frame.name) == true) {
							if (Frame.broad[i][j].getReserved() == true) {
								JPanel jPanel = new JPanel();
								JOptionPane.showMessageDialog(jPanel, "Không được điền ô này", "Thông báo",
										JOptionPane.ERROR_MESSAGE);
								Frame.name = "";
								break;
							} else {
								Frame.button = Frame.broad[i][j];
								int r = Frame.button.getRow();
								int c = Frame.button.getColumn();
								int zone = Frame.button.getZone();
								for (int n = 0; n < 9; n++) {
									for (int m = 0; m < 9; m++) {
										Frame.broad[r][m].setBackground(Color.red);
										Frame.broad[n][c].setBackground(Color.red);
										if (Frame.broad[n][m].getZone() == zone) {
											Frame.broad[n][m].setBackground(Color.red);
										}
									}
								}
								Frame.broad[r][c].setBackground(Color.yellow);
							}
						}
					}
				}
			}
		}
		

		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getName().equals("awser")) {
				try {
					int r = Frame.button.getRow();
					int c = Frame.button.getColumn();
					int zone = Frame.button.getZone();
					Frame.broad[r][c].setText(button.getText());
					if (Frame.check_game.validateColum(Frame.broad, c) == false
							|| Frame.check_game.validateRow(Frame.broad, r) == false
							|| Frame.check_game.validateZone(Frame.broad, zone) == false) {
						Frame.broad[r][c].setText("");
					} else if (Frame.check_game.validateColum(Frame.broad, c) == true
							& Frame.check_game.validateRow(Frame.broad, r) == true
							& Frame.check_game.validateZone(Frame.broad, zone) == true) {
						JPanel jPanel = new JPanel();
						Frame.broad[r][c].setText(button.getText());
						JOptionPane.showMessageDialog(jPanel, "Đúng rồi", "Thông báo", JOptionPane.ERROR_MESSAGE);
						Frame.check_game.validateGame(Frame.broad);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							if (Frame.broad[i][j].getReserved() == true) Frame.broad[i][j].setBackground(new Color(222, 184, 0));
							else Frame.broad[i][j].setBackground(new Color(222, 184, 184));
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.err.println(e.toString());
		if(e.getButton() == 3) {
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
