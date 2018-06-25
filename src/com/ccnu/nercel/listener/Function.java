package com.ccnu.nercel.listener;

import javax.swing.JOptionPane;

import com.ccnu.nercel.file.Save;
import com.ccnu.nercel.ui.Menu;


public class Function {
	
	Save s= new Save();
	
	private static int save=0;
	private static int open=1;
	private static int clear=3;
	private static int redo=3;
	private static int undo=3;
	public int type=5;
	
	
	
	public static void save() {
		Save s= new Save();
	}
	public void open() {
		
	}
	public static void undo() {
		if (!Menu.shapes.isEmpty()) {
			Menu.shapes.remove(Menu.shapes.size() - 1);
			Menu.pnlDisplayArea.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	public static void redo() {
		if(!Menu.shapes.isEmpty()) {
			Menu.shapes.clear();
			Menu.pnlDisplayArea.repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
}
