package Sodoku_2;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Check_game {
	ImageIcon iconb = new ImageIcon("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\smiley-1635454_6402.png");
	ImageIcon iconc = new ImageIcon("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\cuoi1.jpg");
	public boolean validateRow(myButton3x3[][] broad, int row) {
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if("".equals(broad[row][i].getText())==false) {
					if(broad[row][i].getText().equals(broad[row][j].getText())) {
						JPanel m = new JPanel();
						JOptionPane.showMessageDialog(m, "Sai Hàng Rồi", "Alo", JOptionPane.ERROR_MESSAGE,iconb);
						return false;
					}
				}
			}
		}
		return true;			
	}

	public boolean validateColum(myButton3x3[][] broad, int colum) {
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if("".equals(broad[i][colum].getText())==false) {
					if(broad[i][colum].getText().equals(broad[j][colum].getText())) {
						JPanel m = new JPanel();
						JOptionPane.showMessageDialog(m, "Sai Cột Rồi", "Alo", JOptionPane.ERROR_MESSAGE,iconb);
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean validateZone(myButton3x3[][] broad, int zone) {
		String[] n = new String[10];
		int k = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (broad[i][j].getZone() == zone) {
					if ("".equals(broad[i][j].getText()) == false) {
						n[k] = broad[i][j].getText();
						k++;
					}else {
						n[k] = "";
						k++;
					}
					 
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if("".equals(n[i]) == false)
			for (int j = i + 1; j < 9; j++) {
				if (n[i].equals(n[j])) {
					JPanel m = new JPanel();
					JOptionPane.showMessageDialog(m, "Sai Zone Rồi", "Alo", JOptionPane.ERROR_MESSAGE,iconb);
					return false;
				}
			}
		}
		return true;
	}

	public boolean validateGame(myButton3x3[][] a) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (a[i][j].getText().equals(""))
					return false;
				}
			}
		JPanel m = new JPanel();
		JOptionPane.showMessageDialog(m, "Win", "xong", JOptionPane.ERROR_MESSAGE,iconc);
		return true;
	}
}
