package Sodoku_2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sodoku_2_IO {

	ImageIcon icon = new ImageIcon("F:\\JAVA\\Sodoku_HDT\\src\\Sodoku_2\\images\\check.jpg");

	public void readData(myButton3x3[][] a, File file) {
		// File file = new File("F:\\JAVA\\Sodoku_HDT\\de.txt");
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);

			String data;
			try {
				int i = 0;
				while ((data = br.readLine()) != null) {
					String[] datas = data.split(",");
					int j = 0;
					for (String string : datas) {
						if ("0".equals(string) == true) {
							a[i][j].setText("");
							a[i][j].setReserved(false);
							a[i][j].setColumn(j);
							a[i][j].setRow(i);
							j++;
						} else {
							a[i][j].setText(string);
							a[i][j].setReserved(true);
							a[i][j].setColumn(j);
							a[i][j].setRow(i);
							j++;
						}
					}
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Nạp dữ liệu thành công", "Nạp dữ liệu",
					JOptionPane.INFORMATION_MESSAGE, icon);
			try {
				br.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void readZone(myButton3x3[][] a) {
		File file = new File("F:\\JAVA\\Sodoku_HDT\\zone.txt");
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);

			String data;
			try {
				int i = 0;
				while ((data = br.readLine()) != null) {
					int j = 0;
					String[] datas = data.split(",");
					for (String string : datas) {
						int zone = Integer.parseInt(string);
						a[i][j].setZone(zone);
						j++;
					}
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeData(myButton3x3[][] a) {
		File file = new File("F:\\JAVA\\Sodoku_HDT\\awser.txt");
		FileWriter fileWriter = null;
		BufferedWriter bw = null;
		try {
			try {
				fileWriter = new FileWriter(file);
				bw = new BufferedWriter(fileWriter);
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (j == 8) {
							if ("".equals(a[i][j].getText())) {
								bw.write("0");
								bw.newLine();
							} else {
								bw.write(a[i][j].getText());
								bw.newLine();
							}

						} else {
							if ("".equals(a[i][j].getText())) {
								bw.write("0");
							} else {
								bw.write(a[i][j].getText());

							}
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				bw.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void setPicture(JLabel jLabel, String nameFile) {
		try {
			BufferedImage image = ImageIO.read(new File(nameFile));
			int ix = image.getWidth();
			int iy = image.getHeight();
			int x = jLabel.getSize().width;
			int y = jLabel.getSize().height;
			int dx = 0, dy = 0;

			if (x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			} else {
				dx = x;
				dy = dx * iy / ix;
			}

			ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, Image.SCALE_SMOOTH));
			jLabel.setIcon(icon);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void readDataSaving(myButton3x3[][] a, File file) {
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);

			String data;
			try {
				int i = 0;
				while ((data = br.readLine()) != null) {
					String[] data1 = data.split(" ");
					int j = 0;
					for (String string : data1) {
						String[] string2 = string.split(",");
						if (string2[0].equals("0")) {
							a[i][j].setText("");
							if (string2[1].equals("0"))
								a[i][j].setReserved(false);
							else
								a[i][j].setReserved(true);
						} else {
							a[i][j].setText(string2[0]);
							if (string2[1].equals("0"))
								a[i][j].setReserved(false);
							else
								a[i][j].setReserved(true);
						}
						j++;
					}
					i++;

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Nạp dữ liệu thành công", "Nạp dữ liệu",
					JOptionPane.INFORMATION_MESSAGE, icon);
			try {
				br.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeDataSaving(myButton3x3[][] a, File file) {
		FileWriter fileWriter = null;
		BufferedWriter bw = null;
		try {
			try {
				fileWriter = new FileWriter(file);
				bw = new BufferedWriter(fileWriter);
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (j == 8) {
							if ("".equals(a[i][j].getText())) {
								bw.write("0,");
								if (a[i][j].getReserved() == true)
									bw.write("1");
								else
									bw.write("0");
								bw.newLine();
							} else {
								bw.write(a[i][j].getText() + ",");
								if (a[i][j].getReserved() == true)
									bw.write("1");
								else
									bw.write("0");
								bw.newLine();
							}

						} else {
							if ("".equals(a[i][j].getText())) {
								bw.write("0,");
								if (a[i][j].getReserved() == true)
									bw.write("1 ");
								else
									bw.write("0 ");
							} else {
								bw.write(a[i][j].getText() + ",");
								if (a[i][j].getReserved() == true)
									bw.write("1 ");
								else
									bw.write("0 ");
							}
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				bw.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

//private void showDialog() {
//	JFileChooser fileChooser = new JFileChooser();
//	fileChooser.setCurrentDirectory(new File(Constants.path));
//	
//	int res = fileChooser.showOpenDialog(this);
//	
//	if (res == JFileChooser.APPROVE_OPTION) {
//		File selectedFile = fileChooser.getSelectedFile();
//		gameController.readData(selectedFile.getAbsolutePath());
//	}
//}
