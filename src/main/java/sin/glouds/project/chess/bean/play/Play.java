package sin.glouds.project.chess.bean.play;

import java.util.ArrayList;
import java.util.List;

import sin.glouds.project.chess.bean.board.ChessBoard;
import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.ENDTYPE;
import sin.glouds.project.chess.bean.config.PIECE;
import sin.glouds.project.chess.bean.piece.Pieces;
import sin.glouds.util.CNCharacterUtil;

public class Play {

	public ChessBoard board;
	boolean finish;
	CAMP winner;
	CAMP action;
	ENDTYPE endType;
	List<Step> steps = new ArrayList<>();

	public Play() {
		this.board = new ChessBoard();
		action = CAMP.CAMP_RED;
	}

	public void printQipu() {
		if (steps.size() == 0) {
			System.out.println("棋局未开始");
		} else {
			int stepIndex = 1;
			for (Step step : steps) {
				System.out.println("第" + (stepIndex++) + "手 : " + (step.camp.equals(CAMP.CAMP_RED) ? "红方" : "黑方") + " "
						+ step.step);
			}
		}
	}

	public void printChessBoard() {
		try {
			board.printChessBoard();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void move(Point from, Point to) {
		Pieces piece = board.positions[from.x][from.y].piece;
		if (piece == null) {
			System.out.println("此处无子");
		} else if (piece.camp != action) {
			System.out.println("现在是" + (action == CAMP.CAMP_RED ? "红方" : "黑方") + "的回合");
		} else {
			move(piece, to);
		}
	}

	public Pieces getPiece(String name, String y) {
		if (!CNCharacterUtil.xMapper.containsKey(y))
			return null;
		PIECE p = null;
		for (PIECE piece : PIECE.values()) {
			if (name.equals(piece.toString())) {
				p = piece;
				break;
			}
		}
		if (p == null)
			return null;
		int fy;
		if (action == CAMP.CAMP_RED) {
			fy = 9 - CNCharacterUtil.xMapper.get(y);
		} else {
			fy = CNCharacterUtil.xMapper.get(y) - 1;
		}
		for (int i = 0; i < 10; i++) {
			if (board.positions[i][fy].piece != null && board.positions[i][fy].piece.camp == action
					&& board.positions[i][fy].piece.piece == p)
				return board.positions[i][fy].piece;
		}
		return null;
	}

	public Step move(Pieces pieces, String act, String to) {
		return pieces == null ? null : pieces.getPiece().move(getToPoint(pieces, act, to), board);
	}

	public void move(String line) {
		String piece = line.substring(0, 1);
		String from = line.substring(1, 2);
		String action = line.substring(2, 3);
		String to = line.substring(3, 4);

		Step step = move(getPiece(piece, from), action, to);
		if (step != null) {

			step.step = line;
			this.action = this.action == CAMP.CAMP_BLACK ? CAMP.CAMP_RED : CAMP.CAMP_BLACK;
			steps.add(step);
		}
	}

	public Point getToPoint(Pieces pieces, String act, String to) {
		int sp = CNCharacterUtil.xMapper.get(to);

		if (Step.forward.equals(act)) {
			switch (pieces.piece) {
			case 兵:
				if (sp == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x - sp, pieces.point.y);
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x + sp, pieces.point.y);
				}
				break;
			case 车:
				if (CAMP.CAMP_RED == pieces.camp)
					return new Point(pieces.point.x - sp, pieces.point.y);
				else if (CAMP.CAMP_BLACK == pieces.camp)
					return new Point(pieces.point.x + sp, pieces.point.y);
				break;
			case 炮:
				if (CAMP.CAMP_RED == pieces.camp)
					return new Point(pieces.point.x - sp, pieces.point.y);
				else if (CAMP.CAMP_BLACK == pieces.camp)
					return new Point(pieces.point.x + sp, pieces.point.y);
				break;
			case 将:
				if (sp == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x - sp, pieces.point.y);
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x + sp, pieces.point.y);
				}
				break;
			case 马:
				if (Math.abs((9 - sp) - pieces.point.y) == 1 || Math.abs(sp - 1 - pieces.point.y) == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x - 2, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x + 2, pieces.point.y - (sp - 1 - pieces.point.y));
				} else if (Math.abs((9 - sp) - pieces.point.y) == 2 || Math.abs(sp - 1 - pieces.point.y) == 2) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + 1, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - 1, pieces.point.y - (sp - 1 - pieces.point.y));
				}
				break;
			case 士:
				if (Math.abs(sp - 1 - pieces.point.y) == 1 || Math.abs(9 - sp - pieces.point.y) == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x - 1, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x + 1, pieces.point.y + (sp - 1 - pieces.point.y));
				}
				break;
			case 象:
				if (Math.abs(sp - 1 - pieces.point.y) == 2 || Math.abs(9 - sp - pieces.point.y) == 2) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x - 2, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x + 2, pieces.point.y + (sp - 1 - pieces.point.y));
				}
				break;

			default:
				break;
			}
		} else if (Step.backward.equals(act)) {
			switch (pieces.piece) {
			case 车:
				if (CAMP.CAMP_RED == pieces.camp)
					return new Point(pieces.point.x + sp, pieces.point.y);
				else if (CAMP.CAMP_BLACK == pieces.camp)
					return new Point(pieces.point.x - sp, pieces.point.y);
				break;
			case 炮:
				if (CAMP.CAMP_RED == pieces.camp)
					return new Point(pieces.point.x + sp, pieces.point.y);
				else if (CAMP.CAMP_BLACK == pieces.camp)
					return new Point(pieces.point.x - sp, pieces.point.y);
				break;
			case 将:
				if (sp == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + sp, pieces.point.y);
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - sp, pieces.point.y);
				}
				break;
			case 马:
				if (Math.abs(sp - pieces.point.y - 1) == 1 || Math.abs(9 - sp - pieces.point.y) == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + 2, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - 2, pieces.point.y - (sp - 1 - pieces.point.y));
				} else if (Math.abs(sp - pieces.point.y - 1) == 2 || Math.abs(9 - sp - pieces.point.y) == 2) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + 1, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - 1, pieces.point.y - (sp - 1 - pieces.point.y));
				}
				break;
			case 士:
				if (Math.abs(sp - 1 - pieces.point.y) == 1 || Math.abs(9 - sp - pieces.point.y) == 1) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + 1, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - 1, pieces.point.y + (sp - 1 - pieces.point.y));
				}
				break;
			case 象:
				if (Math.abs(sp - 1 - pieces.point.y) == 2 || Math.abs(9 - sp - pieces.point.y) == 2) {
					if (CAMP.CAMP_RED == pieces.camp)
						return new Point(pieces.point.x + 2, pieces.point.y + (9 - sp - pieces.point.y));
					else if (CAMP.CAMP_BLACK == pieces.camp)
						return new Point(pieces.point.x - 2, pieces.point.y + (sp - 1 - pieces.point.y));
				}
				break;

			default:
				break;
			}
		} else {
			switch (pieces.piece) {
			case 兵:
				if (Math.abs(sp - 1 - pieces.point.y) == 1) {
					if (pieces.camp == CAMP.CAMP_RED)
						return new Point(pieces.point.x, sp - 1);
					else
						return new Point(pieces.point.x, 9 - sp);
				}
				break;
			case 车:
				if (pieces.camp == CAMP.CAMP_RED)
					return new Point(pieces.point.x, sp - 1);
				else
					return new Point(pieces.point.x, 9 - sp);
			case 炮:
				if (pieces.camp == CAMP.CAMP_RED)
					return new Point(pieces.point.x, sp - 1);
				else
					return new Point(pieces.point.x, 9 - sp);
			case 将:
				if (Math.abs(sp - 1 - pieces.point.y) == 1) {
					if (pieces.camp == CAMP.CAMP_RED)
						return new Point(pieces.point.x, sp - 1);
					else
						return new Point(pieces.point.x, 9 - sp);
				}
				break;

			default:
				break;
			}
		}
		return new Point(-1, -1);
	}

	Pieces activePiece;

	public int click(int x, int y) {
		if (!board.hasPiece(x, y)) {
			if (activePiece == null)
				return 0;
			return 2;
		}
		Pieces pieces = board.positions[x][y].piece;
		if (activePiece == null) {
			if (pieces.camp == action) {
				activePiece = pieces;
				return 1;
			}
			return 0;
		} else {
			if (pieces.camp == activePiece.camp) {
				activePiece = pieces;
				return 1;
			}
			return 2;
		}
	}

	public boolean move(int x, int y) {
		return move(activePiece, new Point(x, y));
	}

	public boolean move(Pieces piece, Point to) {
		Step step = piece.move(to, board);
		if (step == null) {
			return false;
		} else {
			step.formatStep();
			steps.add(step);
			action = action == CAMP.CAMP_RED ? CAMP.CAMP_BLACK : CAMP.CAMP_RED;
			return true;
		}
	}
}
