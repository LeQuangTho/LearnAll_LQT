package Sodoku_2;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Sodoku_2_MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public Sodoku_2_MenuBar(Controller_2 cont) {
		super();
		this.init(cont);
	}

	private void init(Controller_2 cont) {
		JMenu setting = new JMenu("Setting");
		JMenu option = new JMenu("Option");
		JMenu about1 = new JMenu("About");
		JMenu help1 = new JMenu("Help");

		JMenuItem conting = new JMenuItem("Continue");
		JMenuItem lever = new JMenuItem("Lever");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem close = new JMenuItem("Close");
		JMenuItem db = new JMenuItem("Open DB");

		JMenuItem ba = new JMenuItem("3X3");
		JMenuItem sau = new JMenuItem("6x6");
		JMenuItem chin = new JMenuItem("9x9");

		JMenuItem about = new JMenuItem("About");
		JMenuItem help = new JMenuItem("Help");

		setting.add(lever);
		setting.add(conting);
		setting.add(save);
		setting.add(reset);
		setting.add(close);
		setting.add(db);

		option.add(ba);
		option.add(sau);
		option.add(chin);
		about1.add(about);
		
		help1.add(help);
		
		this.add(setting);
		this.add(option);
		this.add(help1);
		this.add(about1);

		lever.addActionListener(cont);
		reset.addActionListener(cont);
		save.addActionListener(cont);
		conting.addActionListener(cont);
		close.addActionListener(cont);
		ba.addActionListener(cont);
		sau.addActionListener(cont);
		chin.addActionListener(cont);
		about.addActionListener(cont);
		help.addActionListener(cont);
		db.addActionListener(cont);
	}
}
