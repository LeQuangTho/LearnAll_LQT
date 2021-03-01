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
		JMenu about1 = new JMenu("About");
		JMenu help1 = new JMenu("Help");
		JMenu trick = new JMenu("Trick");

		JMenuItem save = new JMenuItem("Save");
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem close = new JMenuItem("Close");

		JMenuItem mot = new JMenuItem("Chế độ 1 người");
		JMenuItem hai = new JMenuItem("Chế độ 2 người");

		JMenuItem about = new JMenuItem("About");
		
		JMenuItem help = new JMenuItem("Help");
		
		JMenuItem Trick = new JMenuItem("Trick");
		JMenuItem up = new JMenuItem("bien");

		setting.add(save);
		setting.add(reset);
		setting.add(close);

		about1.add(about);
		
		help1.add(help);
		
		trick.add(Trick);
		trick.add(up);
		this.add(setting);
		this.add(help1);
		this.add(about1);
		this.add(trick);
		
		reset.addActionListener(cont);
		save.addActionListener(cont);
		close.addActionListener(cont);
		mot.addActionListener(cont);
		hai.addActionListener(cont);
		about.addActionListener(cont);
		help.addActionListener(cont);
		Trick.addActionListener(cont);
		up.addActionListener(cont);
	}
}
