package sin.chess.bean.piece;

import sin.chess.bean.board.ChessBoard;
import sin.chess.bean.board.Point;
import sin.chess.bean.config.CAMP;
import sin.chess.bean.config.PIECE;
import sin.chess.bean.play.Step;

public abstract class ChessPiece {

	public Point point, originalPoint;
	public CAMP camp;
	public PIECE piece;

	abstract protected Step move(Point point, ChessBoard board);

	abstract protected boolean canMove(Point point, ChessBoard board);

	abstract Step moveTo(Point point, ChessBoard board);

	public ChessPiece(Point point) {
		this.originalPoint = point;
		this.point = point;
	}
	
	public ChessPiece(Point point, CAMP camp, PIECE piece) {
		this.originalPoint = point;
		this.point = point;
		this.camp = camp;
		this.piece = piece;
	}

}
