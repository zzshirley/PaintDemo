package com.ccnu.nercel.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.*;

import com.ccnu.nercel.listener.BtnLinstener;
import com.ccnu.nercel.listener.ColorPanel;
import com.ccnu.nercel.listener.ThicknessPanel;
import com.ccnu.nercel.shape.Shape;

import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.listener.MenuLinstener;

public class Paint extends JFrame{
	/*
	 * 画图板，包含ColorPanel颜色选择panel、ThicknessPanel粗细选择panel、ShapeButton图形选择panel、File 菜单栏
	 * PaintPanel 画板
	 */
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();//画板
	private JMenuBar mb1 =new JMenuBar();
	private ColorPanel gcolor =new ColorPanel();//颜色panel
	public static ThicknessPanel thickpanel = new ThicknessPanel();//粗细panel
	ShapeButton sbtn = new ShapeButton();//图形选择panel
	
	private JMenu
		f=new JMenu("File");
	    
		
	private JMenuItem[] shape= {
		new JMenuItem("save",KeyEvent.VK_S),
		new JMenuItem("redo",KeyEvent.VK_C),
		new JMenuItem("undo",KeyEvent.VK_Z),
		new JMenuItem("clear",KeyEvent.VK_Z),
		};
	/************/
	JButton undobtn = new JButton(new ImageIcon("./icons/undo.png"));
	JButton redobtn = new JButton(new ImageIcon("./icons/redo.png"));
	JButton clearbtn = new JButton(new ImageIcon("./icons/clear.png"));
	JButton savebtn = new JButton(new ImageIcon("./icons/save.png"));
	
    private JButton[] buttonArray = new JButton[]{undobtn,redobtn,clearbtn,savebtn};
    private JToolBar toolbar = new JToolBar();
    /*****************/
	public Paint() {
		pnlCommandArea.setLayout(new FlowLayout());		
		MenuLinstener mul = new MenuLinstener();
		BtnLinstener btns = new BtnLinstener();
		JFrame jf = new JFrame("IPaint");
		JPanel jp = new JPanel();
		
		/******/
		JPanel jp1 = new JPanel();
		for(int i=0;i<buttonArray.length;i++)
		{
			toolbar.add(buttonArray[i]);
			
			buttonArray[i].addActionListener(btns);
			
		}
		buttonArray[0].setActionCommand("undo");
		//为按钮设置工具提示信息，当把鼠标放在其上时显示提示信息
		buttonArray[0].setToolTipText("undo");
		buttonArray[1].setActionCommand("redo");
		buttonArray[1].setToolTipText("redo");
		buttonArray[2].setActionCommand("clear");
		buttonArray[2].setToolTipText("clear");
		buttonArray[3].setActionCommand("save");
		buttonArray[3].setToolTipText("save");
		/******/
		for (JMenuItem sh:shape) {
			f.add(sh);
			sh.addActionListener(mul);
		}
		mb1.add(f);
		jf.setJMenuBar(mb1);
		jp.setBackground(Color.WHITE);//白色背景
		/******/
		jp.setLayout(new BorderLayout());
		jp.add(toolbar,BorderLayout.NORTH);
		jp1.add(gcolor);
		jp1.add(thickpanel);
		jp1.add(sbtn);
		jp.add(jp1);
		/******/
//		jp.add(thickpanel,FlowLayout.LEFT);
//		jp.add(gcolor,FlowLayout.LEFT);
//		jp.add(sbtn);
		jf.add(jp,BorderLayout.NORTH);
		jf.add(pnlDisplayArea);
		jf.setSize(800, 700);//画图板大小800*800
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
