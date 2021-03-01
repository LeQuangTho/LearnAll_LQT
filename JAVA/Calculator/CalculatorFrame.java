package week_09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

	private static final long serialVersionUID = -9044652498635048082L;
	
	CalculatorListener listener = new CalculatorListener();
	CalculatorMenu myMenu = new CalculatorMenu(listener);

	JTextField firstTxt = new JTextField();
	JTextField secondTxt = new JTextField();
	JTextField resultTxt = new JTextField();
	
	public CalculatorFrame() {
		super("Calculator ...");
		this.setLocation(100, 100);
		this.setSize(400, 180);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.init();
		this.listener.setMainFrame(this);
	}

	private void init() {
		JPanel mainPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new GridLayout(3, 2));
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		JLabel firstLbl = new JLabel("First number");
		JLabel secondLbl = new JLabel("Second number");
		JLabel resultLbl = new JLabel("Result");
		
		JButton addBtn = new JButton("+");
		JButton subBtn = new JButton("-");
		JButton mulBtn = new JButton("x");
		JButton divBtn = new JButton("/");

		centerPanel.add(firstLbl);
		centerPanel.add(firstTxt);
		centerPanel.add(secondLbl);
		centerPanel.add(secondTxt);
		centerPanel.add(resultLbl);
		centerPanel.add(resultTxt);

		southPanel.add(addBtn);
		southPanel.add(subBtn);
		southPanel.add(mulBtn);
		southPanel.add(divBtn);

		resultTxt.setEditable(false);
		resultTxt.setBackground(Color.YELLOW);

		this.setContentPane(mainPanel);
		this.setJMenuBar(myMenu);

		// Listener registration
		addBtn.addActionListener(listener);
		subBtn.addActionListener(listener);
		mulBtn.addActionListener(listener);
		divBtn.addActionListener(listener);
	}

}
