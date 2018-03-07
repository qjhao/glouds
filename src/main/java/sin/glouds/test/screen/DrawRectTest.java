package sin.glouds.test.screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class DrawRectTest {
	public static void main(String[] args) {
		new NewFrame();
	}
}

class NewFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/*
	 * 创建一个小的窗口。点击按钮来截屏。
	 */
	JButton button;

	NewFrame() {
		setVisible(true);
		setLayout(new FlowLayout());
		setBounds(1000, 600, 100, 100);
		setResizable(false);
		button = new JButton("截图");
		add(button);
		button.addActionListener(new ActionListener() {// 鼠标点击按钮，new
														// 一个ScreenFrame，设置可见，
			public void actionPerformed(ActionEvent e) {
				ScreenFrame sf = new ScreenFrame();
				sf.setAlwaysOnTop(true);
				sf.setUndecorated(true);
				sf.setVisible(true);
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class ScreenFrame extends JFrame {
	private static final long serialVersionUID = 2L;
	/*
	 * 创建一个全屏的窗口，将全屏的图像放在JFrame的窗口上，以供来截屏。
	 */
	Dimension di = Toolkit.getDefaultToolkit().getScreenSize();

	ScreenFrame() {
		// 设置大小，即全屏
		setSize(di);
		// 返回此窗体的 contentPane对象
		getContentPane().add(new DrawRect());
	}

	class DrawRect extends JPanel implements MouseMotionListener, MouseListener {
		private static final long serialVersionUID = 3L;
		/*
		 * 将全屏的图像放在JPanel 上， 可以通过new DrawRect来获得JPanel，并且JPanel上有全屏图像
		 */
		int sx, sy, ex, ey;
		int count = 1;
		File file = null;
		BufferedImage image, getImage;
		boolean flag = true;

		public DrawRect() {
			try {// 获取全屏图像数据，返回给image
				Robot robot = new Robot();
				image = robot.createScreenCapture(new Rectangle(0, 0, di.width, di.height));
			} catch (Exception e) {
				throw new RuntimeException("截图失败");
			}
			// 添加 鼠标活动事件
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		// 重写paintComponent，通过repaint 显示出来截屏的范围
		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, di.width, di.height, this);
			g.setColor(Color.blue);
			if (sx < ex && sy < ey)// 右下角
				g.drawRect(sx, sy, ex - sx, ey - sy);
			else // 左上角
				g.drawRect(ex, ey, sx - ex, sy - ey);
		}

		// 以下都是鼠标事件
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3)// 右键退出程序
				System.exit(0);
			else if (e.getClickCount() == 2) // 双击截屏
			{
				try {
					cutScreens();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		// 自定义截屏函数
		private void cutScreens() throws Exception {
			Robot ro = new Robot();
			if (sx < ex && sy < ey)// 右下角
				getImage = ro.createScreenCapture(new Rectangle(sx, sy, ex - sx, ey - sy));
			else // 左上角
				getImage = ro.createScreenCapture(new Rectangle(ex, ey, sx - ex, sy - ey));
			String name = "jietu" + count + ".bmp";
			file = new File("C:\\Users\\Administrator\\Desktop", name);
			while (file.exists()) {
				String na = "jietu" + (count++) + ".bmp";
				file = new File("C:\\Users\\Administrator\\Desktop", na);
			}
			ImageIO.write(getImage, "bmp", file);
			System.exit(0);
		}

		public void mousePressed(MouseEvent e) {
			if (flag) {
				sx = e.getX();
				sy = e.getY();
			}
		}

		public void mouseReleased(MouseEvent e) {
			flag = false;
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		// 鼠标移动中，通过repaint 画出要截屏的范围
		public void mouseDragged(MouseEvent e) {
			ex = e.getX();
			ey = e.getY();
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}
	}
}
