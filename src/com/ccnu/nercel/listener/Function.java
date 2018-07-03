package com.ccnu.nercel.listener;

import java.util.Stack;

import javax.swing.JOptionPane;

import com.ccnu.nercel.file.Save;
import com.ccnu.nercel.shape.Shape;
import com.ccnu.nercel.ui.Menu;


public class Function {
	
	Save s= new Save();
	
	public static Stack<Shape> rshape = new Stack<Shape>();
			
	public static void save() {
		Save s= new Save();
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
		else if (Menu.shapes.isEmpty()&&rshape.isEmpty()){
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	public static void clear() {
		if(!Menu.shapes.isEmpty()) {
			Menu.shapes.clear();
			rshape.clear();
			Menu.pnlDisplayArea.repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
}
