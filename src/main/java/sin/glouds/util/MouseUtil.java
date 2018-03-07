package sin.glouds.util;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class MouseUtil extends sin.glouds.beans.Robot{
	
	/**
	 * 获取鼠标当前位置所在屏幕的X坐标
	 * 
	 * @return x
	 */
	public static int getX() {
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	
	/**
	 * 获取鼠标当前位置所在屏幕的Y坐标
	 * 
	 * @return y
	 */
	public static int getY() {
		return MouseInfo.getPointerInfo().getLocation().y;
	}
	
	/**
	 * 获取机器人
	 * 
	 * @return robot
	 */
	private static Robot getRobot() {
		if(robot == null) {
			try {
				robot = new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		return robot;
	}
	
	/**
	 * 移动鼠标至坐标(x,y)处
	 * 
	 * @param x
	 * @param y
	 */
	public static void moveTo(int x, int y) {
		getRobot().mouseMove(x, y);
	}
	
	/**
	 * 移动鼠标至点point处
	 * 
	 * @param point
	 */
	public static void moveTo(Point point) {
		moveTo(point.x, point.y);
	}
	
	/**
	 * 点击鼠标右键
	 */
	public static void clickRight() {
		click(KeyEvent.BUTTON3_MASK);
	}
	
	/**
	 * 点击鼠标
	 * 
	 * @param button
	 */
	private static void click(int button) {
		press(button);
		release(button);
	}
	
	/**
	 * 点击鼠标左键
	 */
	public static void clickLeft() {
		click(KeyEvent.BUTTON1_MASK);
	}
	
	/**
	 * 按下鼠标左键
	 */
	public static void pressLeft() {
		press(KeyEvent.BUTTON1_MASK);
	}
	
	/**
	 * 松开鼠标左键
	 */
	public static void releaseLeft() {
		press(KeyEvent.BUTTON1_MASK);
	}
	
	/**
	 * 按下鼠标右键
	 */
	public static void pressRight() {
		press(KeyEvent.BUTTON3_MASK);
	}
	
	/**
	 * 松开鼠标右键
	 */
	public static void releaseRight() {
		press(KeyEvent.BUTTON3_MASK);
	}
	
	/**
	 * 按下鼠标
	 * 
	 * @param button
	 */
	public static void press(int button) {
		getRobot().mousePress(button);
	}
	
	/**
	 * 松开鼠标
	 * 
	 * @param button
	 */
	public static void release(int button) {
		getRobot().mouseRelease(button);
	}
	
	/**
	 * 移动至点from按下鼠标拖拽至点to
	 * 
	 * @param button
	 * @param from
	 * @param to
	 */
	private static void drag(int button, Point from, Point to) {
		moveTo(from);
		press(button);
		moveTo(to);
		release(button);
	}
	
	/**
	 * 拖拽鼠标左键
	 * 
	 * @param from
	 * @param to
	 */
	public static void dragLeft(Point from, Point to) {
		drag(KeyEvent.BUTTON1_MASK, from, to);
	}
	
	/**
	 * 拖拽鼠标左键
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public static void dragLeft(int x1, int y1, int x2, int y2) {
		dragLeft(new Point(x1, y1), new Point(x2, y2));
	}
}
