package com.ccnu.nercel.listener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ccnu.nercel.ui.Menu;


public class ColorPanel extends JPanel{
	private JButton
		btn1 = new JButton( "Red"),
		btn2 = new JButton("Green"),
		btn3 = new JButton("Blue"),
		btn4 = new JButton("More");
	JPanel panel;
	JColorChooser chooser;
	Color color0;
	public static Color color = new Color(0, 0, 0);
	public ColorPanel() {
		super(new GridLayout(2,2));
		color=new Color(0,0,0);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.RED;  
                	btn1.setForeground(color);
                	btn1.repaint();
                	Menu.thickpanel.repaint();
			}});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.GREEN;  
                	btn2.setForeground(color);
                	btn2.repaint();
                	Menu.thickpanel.repaint();
			}});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.BLUE;  
                	btn3.setForeground(color);
                	btn3.repaint();
                	Menu.thickpanel.repaint();
			}});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser=new JColorChooser();
				color0=chooser.showDialog(new JFrame(), "ColorChooser",Color.lightGray );  
                if (color0 != null)  
                   color=color0;  
                	   btn4.setForeground(color);
                	   Menu.thickpanel.repaint();
			}});
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}
}
