package com.ccnu.nercel.Tools;

import java.util.Stack;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "内容为空，无法执行撤回操作");
		}
	}
	/*
	 * redo恢复撤销动作
	 * rshape栈出栈
	 */
	public static void redo() {
		if(rshape.isEmpty()) {
			JOptionPane.showMessageDialog(null, "已恢复所有撤回操作");
		}
		else {
			Shape r=rshape.pop();
			DrawShapes.shapes.add(r);
			Paint.pnlDisplayArea.repaint();
		}
	}
	/*
	 * clear 清空画布
	 * 清空shapes
	 */
	public static void clear() {
		
		if(!DrawShapes.shapes.isEmpty()) {
			int res = JOptionPane.showConfirmDialog(null, "是否清空画板","",JOptionPane.YES_NO_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				DrawShapes.shapes.clear();
				rshape.clear();
				Paint.pnlDisplayArea.repaint();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "画板为空");
		}
	}
}
