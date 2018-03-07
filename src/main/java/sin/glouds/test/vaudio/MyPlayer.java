package sin.glouds.test.vaudio;

//程序所用到的各种程序包
import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.GainControl;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.swing.JFrame;
//本程序对应的类；
@SuppressWarnings("serial")
public class MyPlayer extends JFrame implements ActionListener, ControllerListener, ItemListener {
	//MediaPlayer类的变量成员的声明；
	//JMF提供的播放器对象；
	Player player;
	Component vc, cc, gcc;
	GainControl gc;
	//first值用来控制在刚开始程序时显示一幅欢迎界面；loop用以标记是否循环播放；
	boolean first = true, loop = false;
	//设立一个字符串记录当前打开文件的路径
	String currentDirectory;
	MyPlayer(String title) {
		super(title);
		// 利用一个adapter实现对用户点击窗口系统菜单的关闭按钮 
		// 时的响应； 
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//调用dispose以执行windowClosed
				dispose();
			}
			public void windowClosed(WindowEvent e) {
				if (player != null)
					player.close();
				System.exit(0);
			}
		});
		//调用设置程序菜单栏的方法成员完成菜单的布置
		setupMenu();
		setSize(400, 400);
		setVisible(true);
	}
	//本方法用以设置程序菜单栏
	public void setupMenu() {
		//设置一个菜单
		Menu file = new Menu("文件");
		//往设置的菜单种添加菜单项
		MenuItem open = new MenuItem("打开");
		open.addActionListener(this);
		file.add(open);
		file.addSeparator();
		CheckboxMenuItem cycle = new CheckboxMenuItem("循环", false);
		cycle.addItemListener(this);
		file.add(cycle);
		file.addSeparator();
		open = new MenuItem("退出");
		open.addActionListener(this);
		file.add(open);
		Menu list = new Menu("播放列表");
		Menu control = new Menu("播放控制");
		MenuItem move = new MenuItem("播放");
		move.addActionListener(this);
		control.add(move);
		control.addSeparator();
		MenuItem pause = new MenuItem("暂停");
		pause.addActionListener(this);
		control.add(pause);
		control.addSeparator();
		MenuItem stop = new MenuItem("停止");
		stop.addActionListener(this);
		control.add(stop);
		control.addSeparator();
		//设置一个菜单栏
		MenuBar mb = new MenuBar();
		//将设置的菜单依次加入程序的菜单栏中去
		mb.add(file);
		mb.add(control);
		mb.add(list);
		//将构造完成的菜单栏交给当前程序的窗口；
		setMenuBar(mb);
	}
	//事件响应成员；捕捉发送到本对象的各种事件；
	public void actionPerformed(ActionEvent e) {
		//设一个字符串用于暂存打开的媒体文件的路径；
		String cufile , selcectfile;
		if (e.getActionCommand().equals("退出")) {
			// 调用dispose以便执行windowClosed 
			dispose();
			return;
		}
		//次事件表明用户选择了"播放"菜单命令；
		//如果当前有一个文件可以播放则执行播放命令；
		if (e.getActionCommand().equals("播放")) {
			if (player != null) {
				player.start();
			}
			return;
		}
		//如果当前正在播放某一文件，则执行暂停；
		if (e.getActionCommand().equals("暂停")) {
			if (player != null) {
				player.stop();
			}
			return;
		}
		//次事件表明用户选择了"播放"菜单命令；
		//如果当前有一个文件可以播放则执行播放命令；
		if (e.getActionCommand().equals("停止")) {
			if (player != null) {
				player.stop();
				player.setMediaTime(new Time(0));
			}
			return;
		}
		//用户选择要播放的媒体文件
		if (e.getActionCommand().equals("打开")) {
			FileDialog fd = new FileDialog(this, "打开媒体文件", FileDialog.LOAD);
			fd.setDirectory(currentDirectory);
			fd.setVisible(true);
			// 如果用户放弃选择文件，则返回 
			if (fd.getFile() == null)
				return;
			//保存了所选文件的名称及其全路径名称已被稍后使用
			//同时设置当前文件夹路径
			selcectfile = fd.getFile();
			currentDirectory = fd.getDirectory();
			cufile = currentDirectory + selcectfile;
			//将用户选择的文件作为一个菜单项加入播放列表该菜单项"名为"该文件名；
			//被点击后给出的命令串是该文件的全路径名
			MenuItem open = new MenuItem(selcectfile);
			open.setActionCommand(cufile);
			MenuBar mb = getMenuBar();
			Menu m = mb.getMenu(2);
			open.addActionListener(this);
			m.add(open);
		} else {
			//程序逻辑运行到此表示用户选择了一个"播放列表"中的媒体文件
			//此时可以通过如下动作获得该文件的全路径名；
			cufile = e.getActionCommand();
			selcectfile = cufile;
		}
		//如果已存在一个播放器，则先将其关闭，稍后重新创建
		//创建播放器时需要捕捉一些异常；
		if (player != null)
			player.close();
		try {
			player = Manager.createPlayer(new MediaLocator("file:" + cufile));
		} catch (java.io.IOException e2) {
			System.out.println(e2);
			return;
		} catch (NoPlayerException e2) {
			System.out.println("不能找到播放器.");
			return;
		}
		if (player == null) {
			System.out.println("无法创建播放器.");
			return;
		}
		first = false;
		setTitle(selcectfile);
		//设置处理播放控制器实际的对象；
		player.addControllerListener(this);
		player.prefetch();
	}
	//因为实现了"ControllerListener"接口，本方法用于处理媒体播放器传来的事件；
	public void controllerUpdate(ControllerEvent e) {
		Container tainer = getContentPane();
		// 调用player.close()时ControllerClosedEvent事件出现。 
		// 如果存在视觉部件，则该部件应该拆除（为一致起见， 
		// 我们对控制面板部件也执行同样的操作下一次需要时再构造）
		if (e instanceof ControllerClosedEvent) {
			if (vc != null) {
				remove(vc);
				vc = null;
			}
			if (cc != null) {
				remove(cc);
				cc = null;
			}
			return;
		}
		//在播放结束时，将播放指针置为文件之首，如果设定了循环播放，则再次启动播放器；
		if (e instanceof EndOfMediaEvent) {
			player.setMediaTime(new Time(0));
			if (loop) {
				player.start();
			}
			return;
		}
		//PrefetchCompleteEvent事件发生后调用start，正式启动播放
		if (e instanceof PrefetchCompleteEvent) {
			player.start();
			return;
		}
		//本事件表示由于用于播放的资源已经确定；此时要将媒体的图形conmopnent
		//（如果有）显示出来，同时将播放器player的控制器显示到窗口里；
		if (e instanceof RealizeCompleteEvent) {
			//如果媒体中有图像，将对应图像component载入窗体；
			vc = player.getVisualComponent();
			if (vc != null)
				tainer.add(vc, BorderLayout.CENTER);
			//将对应控制器component载入窗体；
			cc = player.getControlPanelComponent();
			cc.setBackground(Color.BLUE);
			if (cc != null)
				tainer.add(cc, BorderLayout.SOUTH);
			//有一些特殊媒体在播放时提供另外的控制手段，将该控制器一并加入窗口；
			gc = player.getGainControl();
			gcc = gc.getControlComponent();
			if (gcc != null)
				tainer.add(gcc, BorderLayout.NORTH);
			//根据媒体文件中是否有图像，设定相应的窗口大小	
			if (vc != null) {
				pack();
				return;
			} else {
				setSize(300, 75);
				setVisible(true);
				return;
			}
		}
	}
	//菜单状态改变事件的响应函数；
	public void itemStateChanged(ItemEvent e) {
		loop = !loop;
	}
	//不执行背景清除操作，以免控制面板部件闪烁 
	//同时使得本程序在用鼠标拖动窗口时存在一些没有及时重绘的情况，有待改进
	public void update(Graphics g) {
		paint(g);
	}
	//本类的main函数，其中构造了本类的一个实例；
	public static void main(String[] args) {
		new MyPlayer("简单媒体播放器");
	}
	public void paint(Graphics g) {
		// 调用超类Frame的paint()方法，该paint()方法将调用Frame包含的各个容器 
		// 和部件（包括控制面板部件）的paint()方法。 
		super.paint(g);
		//以下代码实现了在开启程序之初显示欢迎界面	
		if (first) {
			int w = getSize().width;
			int h = getSize().height;
			g.setColor(Color.white);//magenta);
			g.fillRect(0, 0, w, h);
			Font f = new Font("DialogInput", Font.BOLD, 18);
			g.setFont(f);
			FontMetrics fm = g.getFontMetrics();
			int swidth = fm.stringWidth(" 简单媒体播放器 ");
			g.setColor(Color.white);
			g.drawString(
				" 简单媒体播放器 ",
				(w - swidth) / 2,
				(h + getInsets().top) / 2);
		}
	}
}

