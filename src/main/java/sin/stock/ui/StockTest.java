package sin.stock.ui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;

import sin.glouds.util.ColorUtil;
import sin.glouds.util.MouseUtil;

public class StockTest {

	public static void main(String[] args) throws AWTException, IOException {
		test10();
	}
	
	public static void test1() {
		for(Object key : System.getProperties().keySet()) {
			System.out.println(key.toString() + " : " + System.getProperty(key.toString()));
		}
	}
	
	public static void test2() {
		long start = System.currentTimeMillis();
		ColorUtil.getColor(0,0);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void test3() throws AWTException {
		Robot robot = new Robot();
		System.out.println(robot.getAutoDelay());
	}
	
	public static void test4() {
		System.out.println(Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		System.out.println(KeyEvent.VK_CONTROL);
	}
	
	public static void test5() throws AWTException {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
		Robot robot = new Robot();
		BufferedImage bi = robot.createScreenCapture(rectangle);
		System.out.println(bi.getWidth() + "," + bi.getHeight());
		long start = System.currentTimeMillis();
		for(int i=0;i<bi.getWidth();i++) {
			System.out.println(new Color(bi.getRGB(i, 1030)));
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void test6() {
		int x = 155;
		for(int i = 1;i<1080;i++) {
			MouseUtil.moveTo(x, i);
			System.out.println(x + "," + i + " " + ColorUtil.getColor(x, i));
		}
	}
	
	public static void test7() {
		int y = 690;
		for(int i = 100;i<1000;i++) {
			MouseUtil.moveTo(i, y);
			System.out.println(i + "," + y + " " + ColorUtil.getColor(i, y));
		}
	}
	
	public static void test8() throws AWTException, IOException {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
		Robot robot = new Robot();
		BufferedImage bi = robot.createScreenCapture(rectangle);
		ImageIO.write(bi, "jpg", new File("H:/temp/screen.jpg"));
		for(int w = 0;w < bi.getWidth(); w++) {
			for(int h = 0; h< bi.getHeight(); h++) {
				bi.setRGB(w, h, bi.getRGB(w, h));
			}
		}
		ImageIO.write(bi, "jpg", new File("H:/temp/screen2.jpg"));
	}
	
	/**
	 * 模糊图片
	 * @throws IOException 
	 */
	public static void vague(int r) throws IOException {
		r = r + 1;
		BufferedImage bi = ImageIO.read(new File("H:/temp/screen2.jpg"));
		int width = bi.getWidth();
		int height = bi.getHeight();
		for(int w = 0;w < bi.getWidth(); w++) {
			for(int h = 0; h< bi.getHeight(); h++) {
				//int sumRGB = 0;
				int sumR = 0;
				int sumG = 0;
				int sumB = 0;
				int count = 0;
				for(int i = w - r + 1;i<w+r;i++) {
					if(i >= 0 && i < width) {
						for(int j=h-r+1;j<h+r;j++) {
							if(j >=0 && j < height) {
								int wz = Math.abs(w - i);
								int hz = Math.abs(h - j);
								int weight = wz * wz * hz * hz;
								//sumRGB = sumRGB + bi.getRGB(i, j) * weight;
								sumR = sumR + new Color(bi.getRGB(i, j)).getRed() * weight;
								sumG = sumG + new Color(bi.getRGB(i, j)).getGreen() * weight;
								sumB = sumB + new Color(bi.getRGB(i, j)).getBlue() * weight;
								count = count + weight;
							}
						}
					}
				}
				bi.setRGB(w, h, new Color(sumR/count, sumG/count, sumB/count).getRGB());
			}
		}
		ImageIO.write(bi, "jpg", new File("H:/temp/vague_weight_rgb_5.jpg"));
	}
	
	public static void test9() throws IOException {
		BufferedImage bi = ImageIO.read(new File("H:/temp/stock.png"));
		System.out.println(bi.getHeight() + " " + bi.getWidth());
	}
	
	public static void test10() throws IOException {
		BufferedImage bi = ImageIO.read(new File("H:/temp/stock.png"));
		System.out.println(loadInitData(bi));
	}
	
	public static void test11() throws IOException {
		BufferedImage bi = ImageIO.read(new File("H:/temp/stock.png"));
		for(int i = 111; i < 658; i++) {
			int rgb = bi.getRGB(127, i);
			if(isData(rgb)) {
				System.out.println("123, " + i + " : " + new Color(rgb));
			}
		}
	}
	
	public static boolean loadInitData(BufferedImage bi) {
		int priceInitY = 657, priceTop = 111, priceBottom = 658,
				hourBegin = 5, minutes = 30, hourLength = 56,
				timeBeginX = 122;
		StockDataAnalyzer analyzer = StockDataAnalyzer.getInstance();
		Calendar calendar = new GregorianCalendar();
		int currHour = calendar.get(Calendar.HOUR_OF_DAY);
		int top = priceInitY, bottom = priceInitY;
		if (currHour < hourBegin) {
		} else {
			analyzer.putData("0500", new ArrayList<>());
			for (int i = 0; i < currHour - hourBegin + 1; i++) {
				for (int j = 0; j < minutes; j++) {
					int dataX = timeBeginX + i * hourLength + j * hourLength / minutes;
					List<Integer> data = new ArrayList<>();
					if (isData(bi, dataX, top)) {
						data.add(top);
						for (int t = top - 1; t > priceTop; t--) {
							if (isData(bi, dataX, t)) {
								data.add(t);
							} else {
								top = t;
								break;
							}
						}
						for (int b = top + 1; b < priceBottom; b++) {
							if (isData(bi, dataX, b)) {
								data.add(b);
							} else {
								bottom = b;
								break;
							}
						}
					} else if (isData(bottom)) {
						data.add(bottom);
						for (int t = bottom - 1; t > top; t--) {
							if (isData(bi, dataX, t)) {
								data.add(t);
							} else {
								top = t;
								break;
							}
						}
						for (int b = bottom + 1; b < priceBottom; b++) {
							if (isData(bi, dataX, b)) {
								data.add(b);
							} else {
								bottom = b;
								break;
							}
						}
					} else {
						boolean flag = false;
						for (int t = priceTop; t < priceBottom; t++) {
							if (isData(bi, dataX, t)) {
								if (!flag) {
									flag = true;
									top = t;
								}
								data.add(t);
							} else if (flag) {
								bottom = t - 1;
							}
						}
					}
					int currMinute = j * 60 / minutes;
					int curHour = hourBegin + i;
					String currTime = "" + (curHour > 9 ? curHour : "0" + curHour)
							+ (currMinute > 9 ? currMinute : "0" + currMinute);
					analyzer.putData(currTime, data);
				}
			}
			System.out.println("ffff");
			analyzer.printData();
			return true;
		}
		return false;
	
	}
	
	private static boolean isData(int rgb) {
		Color color = new Color(rgb);
		if(color.getRed() > 40 && color.getRed() == color.getBlue() && color.getRed() == color.getBlue())
			return true;
		return false;
	}
	
	private static boolean isData(BufferedImage bi, int x, int y) {
		Color color = new Color(bi.getRGB(x, y));
		//MouseUtil.moveTo(x + 30, y);
		//System.out.println("check data:" + x + "," + y + " color:" + color);
		if(color.getRed() > 40 && color.getRed() == color.getBlue() && color.getRed() == color.getBlue())
			return true;
		return false;
	}
}
