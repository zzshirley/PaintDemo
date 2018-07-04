package com.ccnu.nercel.listener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;
import com.ccnu.nercel.shape.*;

/*
 * 画板panel
 */

public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener {

	private Point Begin = null;//起始点
	private Point End = null;//终止点
	private boolean dottedTag = true;
	private Color color;//颜色
	public static int thick = 1;//默认画笔粗细为1
	public static int w = 0;//宽度
	public static int h = 0;//高度
	DrawDot dot;

	public PaintPanel() {

		setPreferredSize(new Dimension(600, 600));//画板大小
		Border border = new LineBorder(Color.BLACK);//画板边框为黑色
		setBorder(border);
		setBackground(Color.white);//白色背景
		Begin = new ScreenPoint(0, 0);
		End = new ScreenPoint(0, 0);
		dot = new DrawDot();
		addMouseListener(this);
		addMouseMotionListener(this);

	}
/*
 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
 * 画图方法
 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		color = ColorPanel.color;
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		w = Math.abs(End.x - Begin.x);
		h = Math.abs(End.y - Begin.y);
		Point min = new Point(0, 0);
		min.x = Math.min(End.x, Begin.x);
		min.y = Math.min(End.y, Begin.y);
		
		for ( Shape shape : DrawShapes.shapes) {
			g2.setStroke(new BasicStroke());
			shape.DrawShape(g2);
		}
		if (dottedTag) {
			Stroke dash = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
					new float[] { 5, 5, }, 0f);
			g2.setStroke(dash);
			if (DrawShapes.type== DrawShapes.RECT) {
				g2.drawRect(min.x, min.y, w, h);
			} else if (DrawShapes.type == DrawShapes.LINE) {
				g2.drawLine(Begin.x, Begin.y, End.x, End.y);
			} else if (DrawShapes.type == DrawShapes.CIRCLE) {
				g2.drawOval(min.x, min.y, w, h);
			}else {
				dot.DrawShape(g2);
				}
			}	
	}
/*
 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
 * 随手写时，显示连续动作
 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		End = e.getPoint();
		if (DrawShapes.type == DrawShapes.write) {
			dot.addpoint(Begin.x, Begin.y, End.x, End.y);
			Begin = End;
		} 
		repaint();

	}
/*
 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
 * 更新图形起始位置，以鼠标点击处为起点，此时起点和终点一致
 * 当随手写的时候，更新画笔颜色和粗细
 */
	public void mousePressed(MouseEvent e) {
		dottedTag = true;
		Begin = e.getPoint();
		End = Begin;		
		if (DrawShapes.type == DrawShapes.write) {
			dot = new DrawDot();
			color = ColorPanel.color;
			dot.setcolorthick(color, thick);
		}

	}
/*
 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
 * 鼠标释放后，将所画图形入栈
 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		dottedTag = false;
		if (DrawShapes.type == DrawShapes.RECT) {
			DrawShapes.shapes.add(new DrawRect(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.LINE) {
			DrawShapes.shapes.add(new DrawLine(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.CIRCLE) {
			DrawShapes.shapes.add(new DrawCircle(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.write) {
			DrawShapes.shapes.add(dot);
		}
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}
}
