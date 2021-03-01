package GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class sodokuMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public sodokuMenu() {
		super();
		this.init();
	}

	private void init() {
		JMenu setting = new JMenu("File");
		JMenu lever = new JMenu("Lever");
		JMenu help = new JMenu("Help");
		
		JMenuItem reStart = new JMenuItem("Restart");
		JMenuItem Save = new JMenuItem("Save");
		JMenuItem Exit = new JMenuItem("Exit");
		
		JMenuItem lv1 = new JMenuItem("Lever1");
		JMenuItem lv2 = new JMenuItem("Lever2");
		JMenuItem lv3 = new JMenuItem("Lever3");
		
		JMenuItem about = new JMenuItem("About");
		
		setting.add(reStart);
		setting.add(Save);
		setting.add(Exit);
		
		lever.add(lv1);
		lever.add(lv2);
		lever.add(lv3);
		
		help.add(about);
		
		this.add(setting);
		this.add(lever);
		this.add(help);
	}
}
