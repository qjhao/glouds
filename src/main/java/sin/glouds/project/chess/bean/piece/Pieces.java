package sin.glouds.project.chess.bean.piece;

import java.util.ArrayList;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.Config;
import sin.glouds.project.chess.bean.config.PIECE;
import sin.glouds.project.chess.bean.play.Step;

public class Pieces extends ChessPiece {

	// 车Chariot炮Cannon马Horse兵Pawn将King 士Adviser 象Elephant

	boolean motionLimit;
	ArrayList<Point> rangeOfMotion = new ArrayList<>();

	public Pieces(Point point) {
		super(point);
	}
	
	public Pieces(Point point, CAMP camp, PIECE piece) {
		super(point, camp, piece);
	}

	@Override
	public Step move(Point point, ChessBoard board) {
		if (!canMove(point, board))
			return null;
		return moveTo(point, board);
	}

	@Override
	protected boolean canMove(Point point, ChessBoard board) {

		if (!board.pointInBoard(point))
			return false;

		if (motionLimit && rangeOfMotion.stream().noneMatch((p) -> p.equals(point)))
			return false;

		if (this.point.x == point.x && this.point.y == point.y) {
			return false;
		}
		
		if(board.hasPiece(point) && board.positions[point.x][point.y].piece.camp == this.camp) {
			return false;
		}
		return true;
	}

	@Override
	public Step moveTo(Point point, ChessBoard board) {
		Step step = new Step();
		step.index = Config.steps.size() + 1;
		step.camp = this.camp;
		step.piece = this.piece;
		step.from = this.point;
		step.to = point;
		if (board.hasPiece(point)) {
			step.isKill = true;
			step.killed = board.positions[point.x][point.y].piece.piece;
		} else {
			step.isKill = false;
		}
		board.setCheckPosition(this.point, null);
		board.setCheckPosition(point, this);
		this.originalPoint = this.point;
		this.point = point;
		return step;
	}

	public Pieces getPiece() {
		switch (piece) {
		case 兵:
			return (Pawn) this;

		case 士:
			return (Adviser) this;
		case 将:
			return (King) this;
		case 炮:
			return (Cannon) this;
		case 象:
			return (Elephant) this;
		case 车:
			return (Chariot) this;
		case 马:
			return (Horse) this;
		default:
			return this;
		}
	}
}
