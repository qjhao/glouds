package sin.stock.ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sin.glouds.util.ColorUtil;
import sin.glouds.util.MouseUtil;

public class ColorPicker extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Color borderColor = new Color(190, 20, 10);
	private static Color nodeColor = new Color(132,0,0);
	private static int initBorderY = 690;
	private int timeBeginX, timeEndX, timeInitY;
	private boolean initFlag = false;
	JTextArea textArea;

	public ColorPicker() {
		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setColumns(20);
		textArea.setEditable(true);
		textArea.append("---系统启动---");
		JScrollPane scrollPane = new JScrollPane(textArea);
		JButton button = new JButton("初始化");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.append("\n" + "开始初始化时间轴。。。");
					setVisible(false);
					Thread.sleep(1000);
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
					Robot robot = new Robot();
					BufferedImage bi = robot.createScreenCapture(rectangle);
					if (initTimeInterval(bi)) {
						textArea.append("\n初始化时间轴成功！");
						textArea.append("时间轴跨度：" + timeBeginX + "," + timeEndX + " 包含" + (timeEndX - timeBeginX) + "像素");
						textArea.append("\n" + "开始初始化时间节点。。。");
						if (initTimenode(bi)) {
							initFlag = true;
							textArea.append("\n初始化时间节点成功！");
						} else {
							initFlag = false;
							textArea.append("\n初始化时间节点失败！");
							textArea.append("\n初始化失败！");
						}
					} else {
						initFlag = false;
						textArea.append("\n初始化时间轴失败！");
						textArea.append("\n初始化失败！");
					}
					setVisible(true);
				}catch(Exception ex) {
					textArea.append("\n初始化失败，发生了未知的错误");
				}
			}
		});
		setBackground(new Color(123, 123, 12));
		setLayout(new FlowLayout());
		add(button);
		add(scrollPane);
		setBounds((int) Toolkit.getDefaultToolkit().getScreenSize().width - 300,
				(int) Toolkit.getDefaultToolkit().getScreenSize().height - 400, 300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public boolean initTimeInterval(BufferedImage bi) {
		if (Desktop.isDesktopSupported()) {
			List<Integer> pointx = new ArrayList<>();
			fillColorPoint(pointx, initBorderY, bi);
			timeInitY = initBorderY;
			if (pointx.size() != 4) {
				timeInitY = initBorderY + 10;
				fillColorPoint(pointx, initBorderY + 10, bi);
			}
			if (pointx.size() == 4) {
				timeBeginX = pointx.get(0);
				timeEndX = pointx.get(1);
				return true;
			}
		}
		return false;
	}

	private static void fillColorPoint(List<Integer> points, int y, BufferedImage bi) {
		// System.out.println("开始填充颜色点,Y轴坐标:" + y);
		points.clear();
		for (int i = 0; i < bi.getWidth(); i++) {
//			System.out.println("校验点位:" + i + "," + y);
			int rgb = borderColor.getRGB();
			if (rgb == bi.getRGB(i, y)) {
				points.add(i);
			}
		}
		// System.out.println("颜色点数：" + points.size());
	}

	private boolean initTimenode(BufferedImage bi) {
		List<Integer> timenodes = new ArrayList<>();
		for (int i = timeBeginX; i < timeEndX; i++) {
			Color color = new Color(bi.getRGB(i, timeInitY));
			//Color color = ColorUtil.getColor(i, timeInitY);
			System.out.println(i + "," + timeInitY + " " + color);
			MouseUtil.moveTo(i, timeInitY);
			if (color.equals(nodeColor)) {
				timenodes.add(i);
			}
		}
		if (timenodes.size() > 0)
			return true;
		return false;
	}

	public static Color getBorderColor() {
		return borderColor;
	}

	public static void setBorderColor(Color borderColor) {
		ColorPicker.borderColor = borderColor;
	}

	public static Color getNodeColor() {
		return nodeColor;
	}

	public static void setNodeColor(Color nodeColor) {
		ColorPicker.nodeColor = nodeColor;
	}

	public static int getInitBorderY() {
		return initBorderY;
	}

	public static void setInitBorderY(int initBorderY) {
		ColorPicker.initBorderY = initBorderY;
	}

	public int getTimeBeginX() {
		return timeBeginX;
	}

	public void setTimeBeginX(int timeBeginX) {
		this.timeBeginX = timeBeginX;
	}

	public int getTimeEndX() {
		return timeEndX;
	}

	public void setTimeEndX(int timeEndX) {
		this.timeEndX = timeEndX;
	}

	public int getTimeInitY() {
		return timeInitY;
	}

	public void setTimeInitY(int timeInitY) {
		this.timeInitY = timeInitY;
	}

	public boolean isInitFlag() {
		return initFlag;
	}

	public void setInitFlag(boolean initFlag) {
		this.initFlag = initFlag;
	}
	
}
