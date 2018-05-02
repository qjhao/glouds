package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;
import sin.glouds.project.chess.bean.play.Step;

public class Chariot extends Pieces {

	public Chariot(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
	}

	@Override
	public Step move(Point point, ChessBoard board) {
		return super.move(point, board);
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if(super.canMove(point, board)) {
			if(this.point.x == point.x) {
				if(this.point.y > point.y) {
					for(int i=point.y+1;i<this.point.y;i++) {
						if(board.hasPiece(point.x, i))
							return false;
					}
				}else {
					for(int i=this.point.y+1;i<point.y;i++) {
						if(board.hasPiece(point.x, i))
							return false;
					}
				}
			}else if(this.point.y == point.y) {
				if(this.point.x > point.x) {
					for(int i=point.x+1;i<this.point.x;i++) {
						if(board.hasPiece(i, point.y))
							return false;
					}
				}else {
					for(int i=this.point.x+1;i<point.x;i++) {
						if(board.hasPiece(i, point.y))
							return false;
					}
				}
			}
		}else {
			return false;
		}
		return true;
	}

	@Override
	public Step moveTo(Point point, ChessBoard board) {
		return super.moveTo(point, board);
	}

	@Override
	public Pieces getPiece() {
		return this;
	}
	
	

}
