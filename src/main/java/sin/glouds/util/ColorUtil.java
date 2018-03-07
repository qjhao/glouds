package sin.glouds.util;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

public class ColorUtil extends sin.glouds.beans.Robot {
	
	private static Color color;
	
	public static Color getColor() {
		return getColor(MouseUtil.getX(), MouseUtil.getY());
	}
	
	public static Color getColor(int x, int y) {
		color = getRobot().getPixelColor(x, y);
		return color;
	}
	
	public static Color getColor(Point point) {
		return getColor(point.x, point.y);
	}
	
	public static Robot getRobot() {
		if(robot == null) {
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		
		return robot;
	}
	
	public static Boolean isSameColor(List<Point> points) {
		Color c = getColor(points.get(0).x, points.get(0).y);
		int rgb = c.getRGB();
		
		for(Point point : points) {
			if(getColor(point).getRGB() != rgb)
				return false;
		}
		
		return true;
	}
	
	public static Boolean isSameColor(int x1, int y1, int x2, int y2) {
		List<Point> points = new ArrayList<Point>();
		for(;x1 <= x2;x1++) {
			for(;y1 <= y2;y1++) {
				points.add(new Point(x1, y1));
			}
		}
		
		if(points.size() == 0)
			return false;
		return isSameColor(points);
	}
}
