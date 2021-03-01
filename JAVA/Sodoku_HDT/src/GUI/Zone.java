package GUI;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Zone extends JPanel{
	private static final long serialVersionUID = 1L;
			JButton txt1 = new JButton();
			JButton txt2 = new JButton();
			JButton txt3 = new JButton();
			
			JButton txt4 = new JButton();
			JButton txt5 = new JButton();
			JButton txt6 = new JButton();
			
			JButton txt7 = new JButton();
			JButton txt8 = new JButton();
			JButton txt9 = new JButton();
	public void creatZone(JPanel zone1,int n,Controller controller) {
		
		//txt1.set
		
		txt1.setText("1");
		txt2.setText("2");
		txt3.setText("3");
		txt4.setText("4");
		txt5.setText("5");
		txt6.setText("6");
		txt7.setText("7");
		txt8.setText("8");
		txt9.setText("9");
		
		txt2.addActionListener(controller);
		txt3.addActionListener(controller);
		txt4.addActionListener(controller);
		txt5.addActionListener(controller);
		txt6.addActionListener(controller);
		txt7.addActionListener(controller);
		txt8.addActionListener(controller);
		txt9.addActionListener(controller);
		
		if(n%2 == 1) {
			txt1.setBackground(new Color(177, 195, 234));
			txt2.setBackground(new Color(177, 195, 234));
			txt3.setBackground(new Color(177, 195, 234));
			txt4.setBackground(new Color(177, 195, 234));
			txt5.setBackground(new Color(177, 195, 234));
			txt6.setBackground(new Color(177, 195, 234));
			txt7.setBackground(new Color(177, 195, 234));
			txt8.setBackground(new Color(177, 195, 234));
			txt9.setBackground(new Color(177, 195, 234));
		}
		
		if(n%2 == 0) {
			txt1.setBackground(Color.WHITE);
			txt2.setBackground(Color.WHITE);
			txt3.setBackground(Color.WHITE);
			txt4.setBackground(Color.WHITE);
			txt5.setBackground(Color.WHITE);
			txt6.setBackground(Color.WHITE);
			txt7.setBackground(Color.WHITE);
			txt8.setBackground(Color.WHITE);
			txt9.setBackground(Color.WHITE);
		}
		txt1.setName("3");
		
		zone1.add(txt1);
		zone1.add(txt2);
		zone1.add(txt3);
		zone1.add(txt4);
		zone1.add(txt5);
		zone1.add(txt6);
		zone1.add(txt7);
		zone1.add(txt8);
		zone1.add(txt9);
		
	}
	
	public JButton getButtom() {
		
		return txt1;
	}
}
