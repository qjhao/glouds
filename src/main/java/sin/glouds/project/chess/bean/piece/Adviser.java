package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class Adviser extends Pieces {

	public Adviser(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
		motionLimit = true;
		if(camp == CAMP.CAMP_RED) {
			rangeOfMotion.add(new Point(7, 3));
			rangeOfMotion.add(new Point(7, 5));
			rangeOfMotion.add(new Point(8, 4));
			rangeOfMotion.add(new Point(9, 3));
			rangeOfMotion.add(new Point(9, 5));
		}else {
			rangeOfMotion.add(new Point(0, 3));
			rangeOfMotion.add(new Point(0, 5));
			rangeOfMotion.add(new Point(1, 4));
			rangeOfMotion.add(new Point(2, 3));
			rangeOfMotion.add(new Point(2, 5));
		}
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(Math.abs(this.point.x - point.x) != 1 || Math.abs(this.point.y - point.y) != 1)
				return false;
		}else
			return false;
		return true;
	}
	
}
