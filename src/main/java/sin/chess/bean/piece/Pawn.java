package sin.chess.bean.piece;

import sin.chess.bean.board.ChessBoard;
import sin.chess.bean.board.Point;
import sin.chess.bean.config.CAMP;
import sin.chess.bean.config.PIECE;

public class Pawn extends Pieces {

	public Pawn(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(camp == CAMP.CAMP_RED) {
				if(this.point.x < point.x)
					return false;
				if(Math.abs(this.point.x - point.x) + Math.abs(this.point.y - point.y) != 1)
					return false;
			}else {
				if(this.point.x > point.x)
					return false;
				if(Math.abs(this.point.x - point.x) + Math.abs(this.point.y - point.y) != 1)
					return false;
			}
		}else
			return false;
		return true;
	}

}
