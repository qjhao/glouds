package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class King extends Pieces {

	public King(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
		motionLimit = true;
		if(camp == CAMP.CAMP_RED) {
			for(int i=7;i<10;i++) {
				for(int j = 3;j<6;j++) {
					rangeOfMotion.add(new Point(i, j));
				}
			}
		}else {
			for(int i=0;i<3;i++) {
				for(int j = 3;j<6;j++) {
					rangeOfMotion.add(new Point(i, j));
				}
			}
		}
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(Math.abs(this.point.x - point.x) + Math.abs(this.point.y - point.y) != 1)
				return false;
		}else
			return false;
		return true;
	}

	
}
