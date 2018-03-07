package sin.chess.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import sin.chess.bean.board.ChessBoard;
import sin.chess.bean.board.Point;
import sin.chess.bean.board.Position;
import sin.chess.bean.config.PIECE;
import sin.chess.bean.piece.Pieces;

public class ChessPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChessPanel() {
		setSize(450, 500);
		repaint();
	}
	
	public void paint(Graphics g) {
		for(Line line : new PanelLines().lines) {
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
		Pieces piece = new Pieces(new Point(0, 0));
		piece.piece = PIECE.兵;
		Position position = new Position();
		position.piece = piece;
		position.point = piece.point;
		ChessBoard board = new ChessBoard();
		board.positions[0][0] = position;
		drawPiece(g, position);
	}
	
	public void drawPiece(Graphics g, Position position) {
		int xindex = position.point.x;
		int yindex = position.point.y;
		int x = PanelLines.x0 + xindex * PanelLines.unitWidth;
		int y = PanelLines.y0 + yindex * PanelLines.unitWidth;
		g.drawOval(x - PanelLines.unitWidth/2, y - PanelLines.unitWidth/2, PanelLines.unitWidth, PanelLines.unitWidth);
		g.setColor(Color.WHITE);
		g.fillOval(x - PanelLines.unitWidth/2, y - PanelLines.unitWidth/2, PanelLines.unitWidth, PanelLines.unitWidth);
		g.setColor(Color.BLACK);
		g.setFont(new Font("微软雅黑", Font.BOLD, 40));
		g.drawString(position.piece.piece.toString(), x - 20, y + 20);
	}
	
}
