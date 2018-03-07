package sin.glouds.test.swing.dialog;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static sin.glouds.test.swing.SwingConsole.*;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
	private JTextField rows = new JTextField("3"),
			cols = new JTextField("3");
	private enum State {
		BLANK, XX, OO
	}
	
	static class ToeDialog extends JDialog {
		private State turn = State.XX;
		public ToeDialog(int cellsWide, int cellsHigh) {
			setTitle("The game itself");
			setLayout(new GridLayout(cellsWide, cellsHigh));
			for(int i = 0; i < cellsHigh * cellsWide; i++) {
				add(new ToeButton());
			}
			setSize(cellsWide * 50, cellsHigh * 50);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		class ToeButton extends JPanel {
			private State state = State.BLANK;
			public ToeButton() {
				addMouseListener(new ML());
			}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				int x1 = 0, y1 = 0,
						x2 = getSize().width - 1,
						y2 = getSize().height - 1;
				g.drawRect(x1, y1, x2, y2);
				x1 = x2/4;
				y1 = y2/4;
				int wide = x2/2, high = y2/2;
				if(state == State.XX) {
					g.drawLine(x1, y1, x1 + wide, y1 + high);
					g.drawLine(x1, y1 + high, x1 + wide, y1);
				}
				if(state == State.OO) {
					g.drawOval(x1, y1, x1 + wide/2, y1 + high/2);
				}
			}
			class ML extends MouseAdapter {
				public void mousePressed(MouseEvent e) {
					if(state == State.BLANK) {
						state = turn;
						turn = (turn == State.XX ? State.OO : State.XX);
					}else {
						state = (state == State.XX ? State.OO : State.XX);
					}
					repaint();
				}
			}
		}
	}
	class BL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog dialog = new ToeDialog(new Integer(rows.getText()), new Integer(cols.getText()));
			dialog.setVisible(true);
		}
		
	}
	
	public TicTacToe() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Rows", JLabel.CENTER));
		p.add(rows);
		p.add(new JLabel("Columns", JLabel.CENTER));
		p.add(cols);
		add(p, BorderLayout.NORTH);
		JButton button = new JButton("go");
		button.addActionListener(new BL());
		add(button, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		run(new TicTacToe(), 200, 200);
	}
}
