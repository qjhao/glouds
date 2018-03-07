package sin.chess.window;

import javax.swing.JFrame;

public class ChineseChess extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChineseChess() {
		this.add(new ChessPanel());
		this.setSize(475,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChineseChess();
	}
}
