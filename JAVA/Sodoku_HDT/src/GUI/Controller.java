package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
	myFrame mf;

	public void setMf(myFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		JButton button = new JButton();
		button.setName("3");
		if (button.getName() == this.mf.z1.getButtom().getName()) {
			this.mf.z1.txt1.setBackground(Color.YELLOW);
			this.mf.z1.txt4.setBackground(Color.YELLOW);
			this.mf.z1.txt5.setBackground(Color.YELLOW);
			this.mf.z1.txt6.setBackground(Color.YELLOW);
			this.mf.z1.txt7.setBackground(Color.YELLOW);
			this.mf.z1.txt8.setBackground(Color.YELLOW);
			this.mf.z1.txt9.setBackground(Color.YELLOW);
			
			this.mf.z2.txt1.setBackground(Color.YELLOW);
			this.mf.z3.txt1.setBackground(Color.YELLOW);
			this.mf.z4.txt1.setBackground(Color.YELLOW);
			this.mf.z7.txt1.setBackground(Color.YELLOW);

			this.mf.z1.txt2.setBackground(Color.YELLOW);
			this.mf.z2.txt2.setBackground(Color.YELLOW);
			this.mf.z3.txt2.setBackground(Color.YELLOW);
			this.mf.z4.txt4.setBackground(Color.YELLOW);
			this.mf.z7.txt4.setBackground(Color.YELLOW);
			
			this.mf.z1.txt3.setBackground(Color.YELLOW);
			this.mf.z2.txt3.setBackground(Color.YELLOW);
			this.mf.z3.txt3.setBackground(Color.YELLOW);
			this.mf.z4.txt7.setBackground(Color.YELLOW);
			this.mf.z7.txt7.setBackground(Color.YELLOW);
		}
		this.mf.z1.txt1.setText(e.getActionCommand());
	}

}
