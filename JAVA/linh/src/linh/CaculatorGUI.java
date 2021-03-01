package linh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CaculatorGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double firstNumber = 0.0;
	private Double secondNumber = 0.0;
	private String valString = "0";
	private int operation = 0;
//	
	private boolean isSelecter1 = false;// check số âm
	private boolean isSelecter2 = false;// check số thập phân
	private boolean isContinue = false;
	JTextField textField1 = new JTextField("0");
	JButton[] button = { new JButton("CE"), new JButton("C"), new JButton("back"), new JButton("/"), new JButton("7"),
			new JButton("8"), new JButton("9"), new JButton("x"), new JButton("4"), new JButton("5"), new JButton("6"),
			new JButton("-"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
			new JButton("( - )"), new JButton("0"), new JButton("."), new JButton("=") };

	Border lineBorder = new LineBorder(new Color(0xC2C2C2), 1);
	Font buttonFont1 = new Font("Calibri (Body)", Font.BOLD, 30);
	Font buttonFont2 = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Calibri (Body)", Font.BOLD, 60);

	public CaculatorGUI() {
		super("Caculator");
		this.setLocation(800, 300);
		this.setSize(420, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.init();
	}

	private void init() {
		JPanel mainPanel = new JPanel();
		JPanel centerPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new GridLayout(5, 4, 1, 1));

		textField1.setBackground(mainPanel.getBackground());
		textField1.setHorizontalAlignment(JTextField.RIGHT);
		textField1.setFont(textFont);
		textField1.setBorder(new EmptyBorder(5, 5, 5, 5));
		textField1.setEditable(true);

		for (JButton jButton : button) {
			jButton.setBorder(lineBorder);
			centerPanel.add(jButton);
			this.setBgAndFont(jButton);
			jButton.addActionListener(this);
		}

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(textField1, BorderLayout.NORTH);

		this.setContentPane(mainPanel);

	}

	public void setBgAndFont(JButton bt) {

		if (bt.getText().equals("CE") || bt.getText().equals("C") || bt.getText().equals("back")
				|| bt.getText().equals("/") || bt.getText().equals("-") || bt.getText().equals("+")
				|| bt.getText().equals("x") || bt.getText().equals("=")) {
			bt.setBackground(new Color(0xCAE5E8));
			bt.setFont(buttonFont2);
		} else {
			bt.setBackground(new Color(0xECECEC));
			bt.setFont(buttonFont1);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();

		if ("C".equals(cmd) || "CE".equals(cmd)) {
			textField1.setText("0");
			valString = "0";
			operation = 0;
			isContinue = false;
			isSelecter1 = false;
			isSelecter2 = false;
		}
		if ("( - )".equals(cmd)) {
			if (!isSelecter1) {
				valString = valString.substring(1, valString.length());
				valString = "-" + valString;
				isSelecter1 = true;
				if (isSelecter2) {
					textField1.setText("" + Double.parseDouble(valString));
				}else {
					textField1.setText("" + Integer.parseInt(valString));
				}
			} else {
				valString = valString.substring(1, valString.length());
				valString = "0" + valString;
				isSelecter1 = false;
				textField1.setText("" + Double.parseDouble(valString));
			}
		}
		if (".".equals(cmd)) {
			if (!isSelecter2) {
//				valString = valString.substring(1, valString.length());
//				textField1.setText("" + Double.parseDouble(valString));
				if (isSelecter2) {
					textField1.setText("" + Double.parseDouble(valString));
				}else {
					textField1.setText("" + Integer.parseInt(valString));
				}
				valString = valString + ".";
//				System.out.println("ok");
				isSelecter2 = true;
				
			} //else {
//				valString = valString.substring(1, valString.length());
//				valString = "0" + valString;
//				isSelecter2 = false;
//				textField1.setText("" + Integer.parseInt(valString));
//			}
		}
		if ("0".equals(cmd) || "1".equals(cmd) || "2".equals(cmd) || "3".equals(cmd) || "4".equals(cmd)
				|| "5".equals(cmd) || "6".equals(cmd) || "7".equals(cmd) || "8".equals(cmd) || "9".equals(cmd)) {
			valString += cmd;
			if (isSelecter2) {
				textField1.setText("" + Double.parseDouble(valString));
			}else {
				textField1.setText("" + Integer.parseInt(valString));
			}
//			textField1.setText("" + Double.parseDouble(valString));
		} else {
			if ("back".equals(cmd)) {
				if (valString.length() == 1) {
					textField1.setText("0");
				} else {
					valString = valString.substring(0, valString.length() - 1);
//					textField1.setText("" + Double.parseDouble(valString));
					if (isSelecter2) {
						textField1.setText("" + Double.parseDouble(valString));
					}else {
						textField1.setText("" + Integer.parseInt(valString));
					}
				}
			}
			if (("+".equals(cmd) || "-".equals(cmd) || "x".equals(cmd) || "/".equals(cmd) && operation == 0)) {
				if ("+".equals(cmd)) {
					operation = 1;
				} else {
					if ("-".equals(cmd)) {
						operation = 2;
					} else {
						if ("x".equals(cmd)) {
							operation = 3;
						} else {
							operation = 4;
						}
					}
				}
				
				if (!isContinue) {
					firstNumber = Double.parseDouble(valString);
					isContinue = true;
					isSelecter2 = false;
				} else {
					secondNumber = Double.parseDouble(valString);
					Double result = 0.0;
					isSelecter2 = false;
					switch (operation) {
					case 1:
						result = firstNumber + secondNumber;
						break;
					case 2:
						result = firstNumber - secondNumber;
						break;
					case 3:
						result = firstNumber * secondNumber;
						break;
					case 4:
						result = firstNumber / secondNumber;
						break;
					}
					firstNumber = result;
//					textField1.setText("" + result);
					if (isSelecter2) {
						textField1.setText("" + result);
					}else {
						int a = (int)(result*1);
						textField1.setText("" + a);
					}

//							
				}

				valString = "0";
//				System.out.println(firstNumber);
			}
			if ("=".equals(cmd)) {
				if (operation == 0) {
//					textField1.setText("" + Double.parseDouble(valString));
					if (isSelecter2) {
						textField1.setText("" + Double.parseDouble(valString));
					}else {
						textField1.setText("" + Integer.parseInt(valString));
					}
					valString = "0";
					
				} else {
					secondNumber = Double.parseDouble(valString);
					isSelecter2 = false;
					Double result = 0.0;
					switch (operation) {
					case 1:
						result = firstNumber + secondNumber;
						break;
					case 2:
						result = firstNumber - secondNumber;
						break;
					case 3:
						result = firstNumber * secondNumber;
						break;
					case 4:
						result = firstNumber / secondNumber;
						break;
					}
					firstNumber = result;
					textField1.setText("" + result);
					if (isSelecter2) {
						textField1.setText("" + result);
					}else {
						int a = (int)(result*1);
						textField1.setText("" + a);
					}
					valString = "0";
//					firstNumber = result;
					operation = 0;
					isContinue = false;
				}
			}

		}
	}
}
