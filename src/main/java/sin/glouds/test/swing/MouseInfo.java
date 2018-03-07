package sin.glouds.test.swing;

import java.awt.Point;

public class MouseInfo {
	public static void main(String[] args) {
		int i = 0;
		while(true) {
			if(++i==100)
				break;
			Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
			System.out.println("("+point.x+","+point.y+")");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
