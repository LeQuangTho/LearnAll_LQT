package gameMemory;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class memory_Menu extends JMenuBar{
	private static final long serialVersionUID = 1L;

	public memory_Menu(memory_Controller cont) {
		super();
		this.init(cont);
	}

	private void init(memory_Controller cont) {
		JMenu setting = new JMenu("Setting");
		JMenu option = new JMenu("Option");
		JMenu about1 = new JMenu("About");
		JMenu help1 = new JMenu("Help");

		JMenuItem save = new JMenuItem("Save");
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem close = new JMenuItem("Close");

		JMenuItem mot = new JMenuItem("Chế độ 1 người");
		JMenuItem hai = new JMenuItem("Chế độ 2 người");

		JMenuItem about = new JMenuItem("About");
		
		JMenuItem help = new JMenuItem("Help");

		setting.add(save);
		setting.add(reset);
		setting.add(close);

		option.add(mot);
		option.add(hai);
		about1.add(about);
		
		help1.add(help);
		
		this.add(setting);
		this.add(option);
		this.add(help1);
		this.add(about1);

		reset.addActionListener(cont);
		save.addActionListener(cont);
		close.addActionListener(cont);
		mot.addActionListener(cont);
		hai.addActionListener(cont);
		about.addActionListener(cont);
		help.addActionListener(cont);
	}
}
