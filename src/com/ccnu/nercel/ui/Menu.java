package com.ccnu.nercel.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.*;

import com.ccnu.nercel.listener.ShapeButton;
import com.ccnu.nercel.listener.BtnLinstener;
import com.ccnu.nercel.listener.ColorPanel;
import com.ccnu.nercel.listener.ThicknessPanel;
import com.ccnu.nercel.shape.Shape;

import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.listener.MenuLinstener;

public class Menu extends JFrame{
	
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();
	private JTextField t = new JTextField("hello",30);
	private JMenuBar mb1 =new JMenuBar();
	private ColorPanel gcolor =new ColorPanel();
	public static Stack<Shape> shapes = new Stack<Shape>();
	public static ThicknessPanel thickpanel = new ThicknessPanel();
	
	public final static int LINE = 0; 
	public final static int CIRCLE = 1;
	public final static int RECT = 2;
	public final static int write = 3;
	public static int type = LINE;
	
	private String[] choices={
		"redo","undo"
	};
	private JMenu
		f=new JMenu("File");
	    
		
	private JMenuItem[] shape= {
		new JMenuItem("save",KeyEvent.VK_S),
		new JMenuItem("redo",KeyEvent.VK_C),
		new JMenuItem("undo",KeyEvent.VK_Z),
		new JMenuItem("clear",KeyEvent.VK_C),
		};
	public Menu() {
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT,20,100);
		pnlCommandArea.setLayout(new FlowLayout());
		ShapeButton sbtn = new ShapeButton();
		MenuLinstener mul = new MenuLinstener();
		BtnLinstener btns = new BtnLinstener();
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		for (JMenuItem sh:shape) {
			f.add(sh);
			sh.addActionListener(mul);
		}
		mb1.add(f);
		jf.setJMenuBar(mb1);
		jp.setBackground(Color.WHITE);
		jp.add(thickpanel,FlowLayout.LEFT);
		jp.add(gcolor,FlowLayout.LEFT);
		jp.add(sbtn);
		jf.add(jp,BorderLayout.NORTH);
		jf.add(pnlDisplayArea);
		jf.setSize(500, 500);	
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
