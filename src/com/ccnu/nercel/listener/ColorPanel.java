package com.ccnu.nercel.listener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ccnu.nercel.ui.Paint;

/*
 * 颜色板
 * 可选择三种button颜色
 * 也可以使用颜色选择器选择颜色
 */
public class ColorPanel extends JPanel{
	private JButton
		btn1 = new JButton( "Red"),
		btn2 = new JButton("Green"),
		btn3 = new JButton("Blue"),
		btn4 = new JButton("More");//颜色选择器
	JColorChooser chooser;
	Color color0;
	public static Color color = new Color(0, 0, 0);
	public ColorPanel() {
		super(new GridLayout(2,2));//2行2列网格布局
		setPreferredSize(new Dimension(120, 60));
		color=new Color(0,0,0);//初始颜色为黑
		btn1.addActionListener(new ActionListener() {/*选择红色*/
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.RED;  
                	btn1.setForeground(color);
                	btn1.repaint();
                	btn2.setForeground(Color.BLACK);
                	btn3.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.GREEN;  
                	btn2.setForeground(color);
                	btn2.repaint();
                	btn1.setForeground(Color.BLACK);
                	btn3.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.BLUE;  
                	btn3.setForeground(color);
                	btn3.repaint();
                	btn2.setForeground(Color.BLACK);
                	btn1.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn4.addActionListener(new ActionListener() {/*颜色选择器*/
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser=new JColorChooser(); 
				color0=chooser.showDialog(new JFrame(), "ColorChooser",Color.lightGray );//获取用户选择的颜色
                if (color0 != null)  
                   color=color0;  
                	   btn4.setForeground(color);
                	   btn2.setForeground(Color.BLACK);
                	   btn3.setForeground(Color.BLACK);
                	   btn1.setForeground(Color.BLACK);
                	   Paint.thickpanel.repaint();
			}});
		/*panel中加入四个button*/
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}
}
