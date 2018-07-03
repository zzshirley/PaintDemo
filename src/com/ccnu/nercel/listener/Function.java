package com.ccnu.nercel.listener;

import java.util.Stack;

import javax.swing.JOptionPane;

import com.ccnu.nercel.file.Save;
import com.ccnu.nercel.shape.Shape;
import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;

/*
 * Function工具类
 * 
 */
public class Function {
	/*
	 * redo栈
	 */
	public static Stack<Shape> rshape = new Stack<Shape>();
	/*
	 * save 方法 用于将画布保存成图片
	 */		
	public static void save() {
		Save s= new Save();
	}
	/*
	 * undo 撤销上一步画图动作
	 * Menu中的shapes图形出栈
	 * 出栈的图形进入rshape栈
	 */
	public static void undo() {
		if (!DrawShapes.shapes.isEmpty()) {
			Shape s=DrawShapes.shapes.pop();	
			rshape.push(s);
			Paint.pnlDisplayArea.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	/*
	 * redo恢复撤销动作
	 * rshape栈出栈
	 */
	public static void redo() {
		if(rshape.isEmpty()) {
			JOptionPane.showMessageDialog(null, "操作错误！无法redo");
		}
		else if(!DrawShapes.shapes.isEmpty()) {
			Shape r=rshape.pop();
			DrawShapes.shapes.add(r);
			Paint.pnlDisplayArea.repaint();
		}
		else if (DrawShapes.shapes.isEmpty()&&rshape.isEmpty()){
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
	/*
	 * clear 清空画布
	 * 清空shapes
	 */
	public static void clear() {
		if(!DrawShapes.shapes.isEmpty()) {
			DrawShapes.shapes.clear();
			rshape.clear();
			Paint.pnlDisplayArea.repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Null Shapes");
		}
	}
}
