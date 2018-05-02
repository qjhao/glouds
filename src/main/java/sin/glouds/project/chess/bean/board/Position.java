package sin.glouds.project.chess.bean.board;

import sin.glouds.project.chess.bean.piece.Pieces;

public class Position {
	public Point point;
	public Pieces piece;
	
	public Position(){
		
	}
	public Position(Point p) {
		this.point = p;
	}
}
