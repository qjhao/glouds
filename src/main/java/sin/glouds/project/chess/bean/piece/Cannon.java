package sin.glouds.project.chess.bean.piece;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class Cannon extends Pieces {

	public Cannon(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {
		if (super.canMove(point, board)) {
			if (board.hasPiece(point)) {
				if (board.positions[point.x][point.y].piece.piece == this.piece) {
					return false;
				} else {
					int count = 0;

					if (this.point.x == point.x) {
						if (this.point.y > point.y) {
							for (int i = point.y + 1; i < this.point.y; i++) {
								if (board.hasPiece(point.x, i))
									if (++count > 1)
										return false;
							}
						} else {
							for (int i = this.point.y + 1; i < point.y; i++) {
								if (board.hasPiece(point.x, i))
									if (++count > 1)
										return false;
							}
						}
					} else if (this.point.y == point.y) {
						if (this.point.x > point.x) {
							for (int i = point.x + 1; i < this.point.x; i++) {
								if (board.hasPiece(i, point.y))
									if (++count > 1)
										return false;
							}
						} else {
							for (int i = this.point.x + 1; i < point.x; i++) {
								if (board.hasPiece(i, point.y))
									if (++count > 1)
										return false;
							}
						}
					}
				}
			} else {
				if (this.point.x == point.x) {
					if (this.point.y > point.y) {
						for (int i = point.y + 1; i < this.point.y; i++) {
							if (board.hasPiece(point.x, i))
								return false;
						}
					} else {
						for (int i = this.point.y + 1; i < point.y; i++) {
							if (board.hasPiece(point.x, i))
								return false;
						}
					}
				} else if (this.point.y == point.y) {
					if (this.point.x > point.x) {
						for (int i = point.x + 1; i < this.point.x; i++) {
							if (board.hasPiece(i, point.y))
								return false;
						}
					} else {
						for (int i = this.point.x + 1; i < point.x; i++) {
							if (board.hasPiece(i, point.y))
								return false;
						}
					}
				}
			}
		}
		return true;
	}

}
