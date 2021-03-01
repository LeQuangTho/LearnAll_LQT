package week_09;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CalculatorMenu extends JMenuBar{
	private static final long serialVersionUID = 3603048953485635279L;

	public CalculatorMenu(CalculatorListener listener) {
		super();
		this.init(listener);
	}
	
	private void init(CalculatorListener listener){
		JMenu fileMenu = new JMenu("File");
		JMenu actionMenu = new JMenu("Action");
		JMenu helpMenu = new JMenu("About");
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenuItem add = new JMenuItem("+");
		JMenuItem sub = new JMenuItem("-");
		JMenuItem mul = new JMenuItem("x");
		JMenuItem div = new JMenuItem("/");
		
		JMenuItem about = new JMenuItem("About me...");
		
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		actionMenu.add(add);
		actionMenu.add(sub);
		actionMenu.add(mul);
		actionMenu.add(div);
		
		helpMenu.add(about);
		
		this.add(fileMenu);
		this.add(actionMenu);
		this.add(helpMenu);
		
		add.addActionListener(listener);
		sub.addActionListener(listener);
		mul.addActionListener(listener);
		div.addActionListener(listener);
	}
}
