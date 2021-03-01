package week_09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CalculatorListener implements ActionListener{
	CalculatorFrame mainFrame;
	
	public void setMainFrame(CalculatorFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double fValue = 0.0;
		double sValue = 0.0;
		try{
			fValue = Double.parseDouble(this.mainFrame.firstTxt.getText());
			sValue = Double.parseDouble(this.mainFrame.secondTxt.getText());
		}catch (NumberFormatException ne){
			JOptionPane.showMessageDialog(this.mainFrame, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		String cmd = e.getActionCommand();
		if ("+".equals(cmd)) {
			double result = fValue + sValue;
			this.mainFrame.resultTxt.setText("" + result);
		}
		if ("-".equals(cmd)) {
			double result = fValue - sValue;
			this.mainFrame.resultTxt.setText("" + result);
		}
		if ("x".equals(cmd)) {
			double result = fValue * sValue;
			this.mainFrame.resultTxt.setText("" + result);
		}
		if ("/".equals(cmd)) {
			double result = fValue / sValue;
			this.mainFrame.resultTxt.setText("" + result);
		}
		
	}

}
