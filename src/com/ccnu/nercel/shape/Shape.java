package com.ccnu.nercel.shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;



public class Shape {
	protected Vector<ScreenPoint> points = new Vector<ScreenPoint>();
	protected Color color;
	protected int Thickness;
	protected Point min;
	protected int w;
	protected int h;
	
	public Shape(Color color,int Thickness,int x1,int y1,int x2,int y2) {
		min = new Point(Math.min(x1, x2), Math.min(y1, y2));
		this.color=color;
		this.Thickness=Thickness;
		points.add(new ScreenPoint(x1, y1));
		points.add(new ScreenPoint(x2, y2));
		w = Math.abs(x2 - x1);
		h = Math.abs(y2 - y1);
	}
	public Shape() {
		
	}
	public void print(PrintWriter pWriter) {
		pWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(),Thickness,points.elementAt(0).x,
				points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);
	}
	public void DrawShape(Graphics2D g) {
		
	}
}