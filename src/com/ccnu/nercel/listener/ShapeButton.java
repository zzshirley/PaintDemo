package com.ccnu.nercel.listener;

import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ShapeButton extends JPanel{
	
	BtnLinstener btns = new BtnLinstener();
	
	private JButton
		btn1 = new JButton( "Rectangle"),
		btn2 = new JButton("Circle"),
		btn3 = new JButton("Line"),
		btn4 = new JButton("Write");
	
	public ShapeButton() {
		super(new GridLayout(2, 2));
		btn1.addActionListener(btns);
		btn2.addActionListener(btns);
		btn3.addActionListener(btns);
		btn4.addActionListener(btns);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}
}
