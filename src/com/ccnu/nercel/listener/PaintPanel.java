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

import com.ccnu.nercel.ui.Menu;
import com.ccnu.nercel.file.Save;
import com.ccnu.nercel.shape.*;



public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener {

	private Point Begin = null;
	private Point End = null;
	private boolean dottedTag = true;
	private Color color;
	public static int thick = 1;
	public static int w = 0;
	public static int h = 0;
	DrawDot dot;

	public PaintPanel() {

		setPreferredSize(new Dimension(600, 600));
		Border border = new LineBorder(Color.black);
		setBorder(border);
		setBackground(Color.white);
		Begin = new ScreenPoint(0, 0);
		End = new ScreenPoint(0, 0);
		dot = new DrawDot();
		addMouseListener(this);
		addMouseMotionListener(this);

	}

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
		
		for ( Shape shape : Menu.shapes) {
			g2.setStroke(new BasicStroke());
			shape.DrawShape(g2);
		}
		if (dottedTag) {
			Stroke dash = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
					new float[] { 5, 5, }, 0f);
			g2.setStroke(dash);
			if (Menu.type== Menu.RECT) {
				g2.drawRect(min.x, min.y, w, h);
			} else if (Menu.type == Menu.LINE) {
				g2.drawLine(Begin.x, Begin.y, End.x, End.y);
			} else if (Menu.type == Menu.CIRCLE) {
				g2.drawOval(min.x, min.y, w, h);
			}
			dot.DrawShape(g2);
		}
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		End = e.getPoint();
		if (Menu.type == Menu.write) {
			dot.addpoint(Begin.x, Begin.y, End.x, End.y);
			Begin = End;
		} 
		repaint();

	}

	public void mousePressed(MouseEvent e) {
		dottedTag = true;
		Begin = e.getPoint();
		End = Begin;		
		if (Menu.type == Menu.write) {
			dot = new DrawDot();
			color = ColorPanel.color;
			dot.setcolorthick(color, thick);
		}

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		dottedTag = false;
		if (Menu.type == Menu.RECT) {
			Menu.shapes.add(new DrawRect(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (Menu.type == Menu.LINE) {
			Menu.shapes.add(new DrawLine(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (Menu.type == Menu.CIRCLE) {
			Menu.shapes.add(new DrawCircle(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (Menu.type == Menu.write) {
			Menu.shapes.add(dot);
		}
		Save.hassave = false;
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

	public Stack<Shape> getshapes() {
		return Menu.shapes;

	}

}
