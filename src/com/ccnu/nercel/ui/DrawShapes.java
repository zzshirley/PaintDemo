package com.ccnu.nercel.ui;

import java.util.Stack;

import com.ccnu.nercel.shape.Shape;

public class DrawShapes {
	
	public final static int LINE = 0; 
	public final static int CIRCLE = 1;
	public final static int RECT = 2;
	public final static int write = 3;
	public static int type = write;
	public static Stack<Shape> shapes = new Stack<Shape>();
}
