package com.ccnu.nercel.shape;

import java.awt.Point;
/*
 * 用于获取屏幕坐标
 */
public class ScreenPoint extends Point{
	public int x;
	public int y;
	public ScreenPoint() {
	}
	public ScreenPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
