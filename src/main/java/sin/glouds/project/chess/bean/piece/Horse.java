package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class Horse extends Pieces {

	public Horse(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(Math.abs(this.point.x - point.x) + Math.abs(this.point.y - point.y) != 3)
				return false;
			if(Math.abs(this.point.x - point.x) == 2)
				return !board.hasPiece(new Point((this.point.x + point.x)/2, this.point.y));
			else
				return !board.hasPiece(new Point(this.point.x, (this.point.y+point.y)/2));
		}else
			return false;
	}

}
