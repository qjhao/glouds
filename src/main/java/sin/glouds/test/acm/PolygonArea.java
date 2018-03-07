package sin.glouds.test.acm;

import java.util.ArrayList;
import java.util.Scanner;

public class PolygonArea {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int num = Integer.parseInt(cin.nextLine());
		Polygon[] polygons = new Polygon[num];
		for(int i=0;i<polygons.length;i++)
			polygons[i] = new Polygon();
		for(int i = 0;i<num;i++) {
			int poly = Integer.parseInt(cin.nextLine());
			
			for(int j = 0;j<poly;j++) {
				double x1 = cin.nextDouble(),y1 = cin.nextDouble();
				cin.nextLine();
				addPoint(x1,y1,polygons[i].list);
			}
		}
		cin.close();
		for(int i =0;i<polygons.length;i++) {


			double center = polygons[i].center();
			double area = polygons[i].area();
			
			System.out.print(String.format("%.3f", area) + " " + String.format("%.3f", center));
		}
	}
	
	private static void addPoint(double x1, double y1, ArrayList<Point> list) {
		Point point = new Point(x1, y1);
		if(list.size() < 2)
			list.add(point);
		else if(isInLine(point, list))
			list.set(list.size() - 1, point);
		else
			list.add(point);
	}
	
	private static boolean isInLine(Point point, ArrayList<Point> list) {
		if(list.size() < 2)
			return false;
		Point p1 = list.get(list.size() - 2);
		Point p2 = list.get(list.size() - 1);
		return isInLine(p1, p2, point);
	}
	
	private static boolean isInLine(Point p1, Point p2, Point p3) {
		if(p1.y - p2.y == 0 && p1.y - p3.y != 0)
			return false;
		if(p1.y - p2.y != 0 && p1.y - p3.y == 0)
			return false;
		if(p1.y - p2.y == 0 && p1.y - p3.y == 0)
			return false;
		return (p1.x - p2.x)/(p1.y - p2.y) == (p1.x - p3.x)/(p1.y - p3.y);
	}
	
}

class Point {
	double x,y;
	
	public Point(double x1, double y1) {
		x = x1;
		y = y1;
	}
}

class Polygon {
	ArrayList<Point> list = new ArrayList<>();
	
	public double area() {
		double area = 0;
		Point p0 = list.get(0);
		for(int i=1;i<list.size() - 1;i++) {
			area += triangleArea(p0, list.get(i), list.get(i + 1));
		}
		return area;
	}
	
	public double center() {
		if(list.size() < 3)
			return 0;
		double center = 0;
		for(Point point : list) {
			center += point.x;
			center += point.y;
		}
		return center / list.size();
	}
	
	private double triangleArea(Point p1, Point p2, Point p3) {
		if(list.size() < 3)
			return 0;
		double d1 = Math.sqrt( Math.abs((p1.y - p2.y) * (p1.y - p2.y) + (p1.x - p2.x) * (p1.x - p2.x)));
		double d2 = Math.sqrt( Math.abs((p1.y - p3.y) * (p1.y - p3.y) + (p1.x - p3.x) * (p1.x - p3.x)));
		double d3 = Math.sqrt( Math.abs((p3.y - p2.y) * (p3.y - p2.y) + (p3.x - p2.x) * (p3.x - p2.x)));
		
		double p = (d1 + d2 + d3) / 2;
		return Math.sqrt(p * (p - d1) * (p - d2) * (p - d3));
	}
}
