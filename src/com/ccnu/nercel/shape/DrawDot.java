package com.ccnu.nercel.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.ccnu.nercel.listener.ColorPanel;
import com.ccnu.nercel.listener.ThicknessPanel;


public class DrawDot extends Shape{
	//private int num;
	public DrawDot() {
		// TODO Auto-generated constructor stub
	}
	public DrawDot(Color color, int Thickness, int x1, int y1, int x2, int y2) {
		super(color, Thickness, x1, y1, x2, y2);
	}



	public void DrawShape(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(Thickness));
		int i=0,j=1;
		while(points.size()>i)
		{
		g.drawLine(points.elementAt(i).x, points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
			i=i+2;
			j=j+2;
		}
		
		g.setColor(ColorPanel.color);
		g.setStroke(new BasicStroke(ThicknessPanel.thick));

	}
	public void print(PrintWriter pWriter) {
		super.print(pWriter);
	}
	public void addpoint(int x1,int y1,int x2,int y2) {
		// TODO Auto-generated method stub
		points.add(new ScreenPoint(x1, y1));
		points.add(new ScreenPoint(x2, y2));		
	}
	public void setcolorthick(Color color0,int thick) {
		Thickness=thick;
		color=color0;
	}
}
