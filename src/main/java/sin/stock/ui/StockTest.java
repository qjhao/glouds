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

import javax.imageio.ImageIO;

import sin.glouds.util.ColorUtil;
import sin.glouds.util.MouseUtil;

public class StockTest {

	public static void main(String[] args) throws AWTException, IOException {
		vague(5);
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
}
