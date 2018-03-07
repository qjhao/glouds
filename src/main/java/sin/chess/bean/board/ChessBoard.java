package sin.chess.bean.board;

import java.util.ArrayList;
import java.util.List;

import sin.chess.bean.config.CAMP;
import sin.chess.bean.config.PIECE;
import sin.chess.bean.piece.Adviser;
import sin.chess.bean.piece.Cannon;
import sin.chess.bean.piece.Chariot;
import sin.chess.bean.piece.Elephant;
import sin.chess.bean.piece.Horse;
import sin.chess.bean.piece.King;
import sin.chess.bean.piece.Pawn;
import sin.chess.bean.piece.Pieces;

public class ChessBoard {
	public Position[][] positions = new Position[10][9];
	
	public ChessBoard() {
		init();
	}
	
	public ChessBoard(Position[][] positions) {
		init(positions);
	}
	
	private void init() {
		for(int i=0; i<10;i++) {
			for(int j=0;j<9;j++) {
				positions[i][j] = new Position(new Point(i, j));
			}
		}
		initDefault();
	}
	
	private List<Pieces> red = new ArrayList<>();
	private List<Pieces> black = new ArrayList<>();
	
	private void initDefault() {
		initDefaultRed();
		initDefaultBlack();
		initPieces();
	}
	
	private void initPieces() {
		for(Pieces piece : red) {
			Position position = positions[piece.point.x][piece.point.y];
			position.piece = piece;
		}
		for(Pieces piece : black) {
			Position position = positions[piece.point.x][piece.point.y];
			position.piece = piece;
		}
	}

	private void initDefaultBlack() {
		Pieces cp1 = new Chariot(new Point(0, 0), CAMP.CAMP_BLACK, PIECE.车);
		red.add(cp1);
		Pieces cp2 = new Chariot(new Point(0, 8), CAMP.CAMP_BLACK, PIECE.车);
		red.add(cp2);
		Pieces cp3 = new Horse(new Point(0, 1), CAMP.CAMP_BLACK, PIECE.马);
		red.add(cp3);
		Pieces cp4 = new Horse(new Point(0, 7), CAMP.CAMP_BLACK, PIECE.马);
		red.add(cp4);
		Pieces cp5 = new Elephant(new Point(0, 2), CAMP.CAMP_BLACK, PIECE.象);
		red.add(cp5);
		Pieces cp6 = new Elephant(new Point(0, 6), CAMP.CAMP_BLACK, PIECE.象);
		red.add(cp6);
		Pieces cp7 = new Adviser(new Point(0, 3), CAMP.CAMP_BLACK, PIECE.士);
		red.add(cp7);
		Pieces cp8 = new Adviser(new Point(0, 5), CAMP.CAMP_BLACK, PIECE.士);
		red.add(cp8);
		Pieces cp9 = new King(new Point(0, 4), CAMP.CAMP_BLACK, PIECE.将);
		red.add(cp9);
		Pieces cp10 = new Pawn(new Point(3, 0), CAMP.CAMP_BLACK, PIECE.兵);
		red.add(cp10);
		Pieces cp11 = new Pawn(new Point(3, 2), CAMP.CAMP_BLACK, PIECE.兵);
		red.add(cp11);
		Pieces cp12 = new Pawn(new Point(3, 4), CAMP.CAMP_BLACK, PIECE.兵);
		red.add(cp12);
		Pieces cp13 = new Pawn(new Point(3, 6), CAMP.CAMP_BLACK, PIECE.兵);
		red.add(cp13);
		Pieces cp14 = new Pawn(new Point(3, 8), CAMP.CAMP_BLACK, PIECE.兵);
		red.add(cp14);
		Pieces cp15 = new Cannon(new Point(2, 1), CAMP.CAMP_BLACK, PIECE.炮);
		red.add(cp15);
		Pieces cp16 = new Cannon(new Point(2, 7), CAMP.CAMP_BLACK, PIECE.炮);
		red.add(cp16);
	}

	private void initDefaultRed() {
		Pieces cp1 = new Chariot(new Point(9, 0), CAMP.CAMP_RED, PIECE.车);
		red.add(cp1);
		Pieces cp2 = new Chariot(new Point(9, 8), CAMP.CAMP_RED, PIECE.车);
		red.add(cp2);
		Pieces cp3 = new Horse(new Point(9, 1), CAMP.CAMP_RED, PIECE.马);
		red.add(cp3);
		Pieces cp4 = new Horse(new Point(9, 7), CAMP.CAMP_RED, PIECE.马);
		red.add(cp4);
		Pieces cp5 = new Elephant(new Point(9, 2), CAMP.CAMP_RED, PIECE.象);
		red.add(cp5);
		Pieces cp6 = new Elephant(new Point(9, 6), CAMP.CAMP_RED, PIECE.象);
		red.add(cp6);
		Pieces cp7 = new Adviser(new Point(9, 3), CAMP.CAMP_RED, PIECE.士);
		red.add(cp7);
		Pieces cp8 = new Adviser(new Point(9, 5), CAMP.CAMP_RED, PIECE.士);
		red.add(cp8);
		Pieces cp9 = new King(new Point(9, 4), CAMP.CAMP_RED, PIECE.将);
		red.add(cp9);
		Pieces cp10 = new Pawn(new Point(6, 0), CAMP.CAMP_RED, PIECE.兵);
		red.add(cp10);
		Pieces cp11 = new Pawn(new Point(6, 2), CAMP.CAMP_RED, PIECE.兵);
		red.add(cp11);
		Pieces cp12 = new Pawn(new Point(6, 4), CAMP.CAMP_RED, PIECE.兵);
		red.add(cp12);
		Pieces cp13 = new Pawn(new Point(6, 6), CAMP.CAMP_RED, PIECE.兵);
		red.add(cp13);
		Pieces cp14 = new Pawn(new Point(6, 8), CAMP.CAMP_RED, PIECE.兵);
		red.add(cp14);
		Pieces cp15 = new Cannon(new Point(7, 1), CAMP.CAMP_RED, PIECE.炮);
		red.add(cp15);
		Pieces cp16 = new Cannon(new Point(7, 7), CAMP.CAMP_RED, PIECE.炮);
		red.add(cp16);
	}

	private void init(Position[][] positions) {
		this.positions = positions;
	}

	public void setCheckPosition(Point point, Pieces checkPiece) {
		positions[point.x][point.y].piece = checkPiece;
	}

	public boolean hasPiece(Point point) {
		return point.x < 10 && point.y < 9 && point.x >= 0 && point.y >= 0 && positions[point.x][point.y].piece != null;
	}
	
	public boolean hasPiece(int x, int y) {
		return positions[x][y].piece != null;
	}
	
	public void printChessBoard() throws InterruptedException {
		String blank = "  ";
		for(Position[] pos : positions) {
			for(Position p : pos) {
				if(p.piece == null) {
					System.err.print(blank);
					Thread.sleep(10);
				}else {
					if(p.piece.camp == CAMP.CAMP_RED) {
						System.out.print(p.piece.piece);
						Thread.sleep(10);
					}else if(p.piece.camp == CAMP.CAMP_BLACK){
						System.out.print(p.piece.piece);
						Thread.sleep(10);
					}
				}
			}
			System.out.println();
			Thread.sleep(10);
		}
	}
	
	public boolean pointInBoard(Point point) {
		if(point.x >= 0 && point.x < 10 && point.y >=0 && point.y < 9)
			return true;
		return false;
	}
}
