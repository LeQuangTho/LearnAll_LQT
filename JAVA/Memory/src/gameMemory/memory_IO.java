package gameMemory;

import static gameMemory.frame_Memory.COLUMN;
import static gameMemory.frame_Memory.ROW;
import static gameMemory.frame_Memory.lever;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class memory_IO {
	public void readData(memory_Button[] game,String lever) {
		File file = new File("F:\\JAVA\\Memory\\src\\gameMemory\\lever\\lever" + lever + ".txt");
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			String data;
			try {
				while ((data = br.readLine()) != null) {	
					String[] datas = data.split(",");
					for(int i = 0; i < datas.length; i++) {
						game[i] = new memory_Button();
						game[i].getBt().setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
						game[i].getBt().setBackground(new Color(184, 230, 34));
						game[i].setValue(datas[i]);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
//			JOptionPane.showMessageDialog(null, "Nạp dữ liệu thành công", "Nạp dữ liệu",
//					JOptionPane.INFORMATION_MESSAGE);
			try {
				br.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void writeDataSaving(memory_Button[] a, File file) {
		FileWriter fileWriter = null;
		BufferedWriter bw = null;
		try {
			try {
				fileWriter = new FileWriter(file);
				bw = new BufferedWriter(fileWriter);
				
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

	public void saveGame() {
		
		
	}
	
	public void readtStatus(frame_Memory frame) {
//		int coint = Integer.parseInt(frame.numberCoint.getText());
//		int heart = Integer.parseInt(frame.numberHeart.getText());
		File file = new File("F:\\JAVA\\Memory\\src\\gameMemory\\lever\\continue.txt");
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			String data;
			try {
				while ((data = br.readLine()) != null) {	
					String[] datas = data.split(",");
					frame.numberCoint.setText(datas[0]);
					frame.numberHeart.setText(datas[1]);
					frame.numberMax.setText(datas[2]);
					frame_Memory.ROW = Integer.parseInt(datas[3]);
					frame_Memory.COLUMN = Integer.parseInt(datas[4]);
					frame_Memory.lever = Integer.parseInt(datas[5]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
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
	public void writetStatus(frame_Memory frame) {
		String coint = frame.numberCoint.getText();
		String heart = frame.numberHeart.getText();
		int max = Integer.parseInt(frame.numberMax.getText());
		int max2 = Integer.parseInt(frame.point.getText());
		int row = ROW;
		int col = COLUMN;
		int lv = lever;
		
		
		if(max2 > max) max = max2;
		File file = new File("F:\\JAVA\\Memory\\src\\gameMemory\\lever\\continue.txt");
		FileWriter fileWriter = null;
		BufferedWriter bw = null;
		try {
			fileWriter = new FileWriter(file);
			bw = new BufferedWriter(fileWriter);
			
			bw.write(coint+","+heart+","+max+","+row+","+col+","+lv);
			
		} catch (IOException e) {
			JPanel jPanel = new JPanel();
			JOptionPane.showMessageDialog(jPanel, "Number format exception ...", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
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
