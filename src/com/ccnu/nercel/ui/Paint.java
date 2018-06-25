package com.ccnu.nercel.ui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.ccnu.nercel.listener.ColorPanel;
import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.listener.ShapeButton;
import com.ccnu.nercel.listener.ThicknessPanel;
import com.ccnu.nercel.shape.Shape;

public class Paint {
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();
	private ColorPanel gcolor =new ColorPanel();
	public static ArrayList<Shape> shapes = new ArrayList<Shape>();
	public static ThicknessPanel thickpanel = new ThicknessPanel();
	
	public final static int LINE = 0; 
	public final static int CIRCLE = 1;
	public final static int RECT = 2;
	public final static int write = 3;
	public static int type = LINE;
	
	public Paint() {
		pnlCommandArea.setLayout(new FlowLayout());
		ShapeButton sbtn = new ShapeButton();	
	}
}
