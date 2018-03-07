package sin.glouds.test.swing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * 并没有预想中的效果
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class OutMove extends JFrame {
	
	private static boolean[][] bs;
	private int f = 1;
	
	public static void main(String[] args) {
		OutMove madol = new OutMove();
		
		madol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		madol.setSize(300, 300);
		madol.setTitle("扩散演示");
		madol.setVisible(true);
		
		madol.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX()+":"+e.getY());
				int x = e.getX();
				int y = e.getY();
				
				int w = e.getComponent().getWidth();
				int h = e.getComponent().getHeight();
				
				bs = new boolean[w][h];
				bs[x][y] = true;
				boolean[][] cs = bs;
				
				while(true) {
					boolean b = true;
					
					for(int i=0;i<w;i++) {
						for(int j=0;j<h;j++) {
							if(bs[i][j]) {
								if(i>0) {
									if(j>0) {
										cs[i-1][j-1] = true;
										System.out.println("zuoshang--");
										e.getComponent().getGraphics().drawOval(i-1, j-1, 1, 1);
									}
									if(j<h-1) {
										cs[i-1][j+1] = true;
										System.out.println("youshang----");
										e.getComponent().getGraphics().drawOval(i-1, j+1, 1, 1);
									}
								}
								if(i<w-1) {
									if(j>0) {
										cs[i+1][j-1] = true;
										System.out.println("zuoxia----");
										e.getComponent().getGraphics().drawOval(i+1, j-1, 1, 1);
									}
									if(j<h-1) {
										cs[i+1][j+1] = true;
										System.out.println("youxia---");
										e.getComponent().getGraphics().drawOval(i+1, j+1, 1, 1);
									}
								}
							}else {
								b = false;
							}
						}
					}
					
					bs = cs;
					//e.getComponent().paint(e.getComponent().getGraphics());
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if(b)
						break;
				}
				
				e.getComponent().getGraphics().drawBytes("over".getBytes(), 0, 4, 10, 10);
			}
		});
	}
	
	public void paint(Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		
		BufferedImage bImage = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
		
		for(int i=1;i<w;i++) {
			for(int j=1;j<h;j++) {
				if(bs[i][j]) {
					bImage.setRGB(i, j, 222);
				}
			}
		}
		
		try {
			ImageIO.write(bImage, "12345", new File("E:/myimage.jpg"));
			System.out.println(f++);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(bImage, 0, 0, null);
	}
}
