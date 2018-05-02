package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class Elephant extends Pieces {

	public Elephant(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
		motionLimit = true;
		if(camp == CAMP.CAMP_RED) {
			for(int i=5;i<10;i+=2) {
				for(int j=0;j<9;j+=2)
					rangeOfMotion.add(new Point(i, j));
			}
		}else {
			for(int i=0;i<5;i+=2) {
				for(int j=0;j<9;j+=2)
					rangeOfMotion.add(new Point(i, j));
			}
		}
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(Math.abs(this.point.x - point.x) != 2 || Math.abs(this.point.y - point.y) != 2)
				return false;
		}else
			return false;
		return true;
	}

}
