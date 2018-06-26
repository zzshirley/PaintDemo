package com.ccnu.nercel.listener;

import java.util.Stack;

import javax.swing.JOptionPane;

import com.ccnu.nercel.file.Save;
import com.ccnu.nercel.shape.Shape;
import com.ccnu.nercel.ui.Menu;


public class Function {
	
	Save s= new Save();
	
	public static Stack<Shape> rshape = new Stack<Shape>();
	
	/*private static int save=0;
	private static int open=1;
	private static int clear=3;
	private static int redo=3;
	private static int undo=3;
	public int type=5;*/
	
	
	
	public static void save() {
		Save s= new Save();
	}
	public void open() {
		
	}
	public static void undo() {
		if (!Menu.shapes.isEmpty()) {
			Shape s=Menu.shapes.pop();	
			rshape.push(s);
			Menu.pnlDisplayArea.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	public static void redo() {
		if(rshape.isEmpty()) {
			JOptionPane.showMessageDialog(null, "操作错误！无法redo");
		}
		else if(!Menu.shapes.isEmpty()) {
			Shape r=rshape.pop();
			Menu.shapes.add(r);
			Menu.pnlDisplayArea.repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	public static void clear() {
		if(!Menu.shapes.isEmpty()) {
			Menu.shapes.clear();
			Menu.pnlDisplayArea.repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
}
