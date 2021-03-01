package Sodoku_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class myButton3x3 {
	private JButton button = new JButton();
	private boolean reserved = false;
	private int column;
	private int row;
	private int zone;
	Font textFont = new Font("Courrier", Font.BOLD, 32);
	Font buttonFont = new Font("Courrier", Font.PLAIN, 18);
	Border lineBorder = BorderFactory.createLineBorder(Color.black);
	
	public myButton3x3(JButton button, boolean reserved) {
		super();
		this.button = button;
		this.reserved = reserved;
	}
	public myButton3x3() {
		super();
	}

	public String getText() {
		return button.getText();
	}
	public void setText(String a) {
		button.setText(a);
	}
	public JButton getButton() {
		return button;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public void addActionListener(Controller_2 cont){
		button.addActionListener(cont);
	}
	public void add(Component cont){
		button.add(cont);
	}
	public void setBackground(Color color) {
		button.setBackground(color);
	}
	public void setBorder(Border border) {
		button.setBorder(border);;
	}
	public void setFont(Font font) {
		button.setFont(font);
	}
	public void setName(String s) {
		button.setName(s);
	}
	public String getName() {
		return button.getName();
	}
	
	public void setZone(int zone) {
		this.zone = zone;
	}
	public int getZone() {
		return this.zone;
	}
	public boolean getReserved() {
		return this.reserved;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
}
