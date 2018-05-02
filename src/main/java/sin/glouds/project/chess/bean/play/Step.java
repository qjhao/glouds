package sin.glouds.project.chess.bean.play;

import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.config.CAMP;
import sin.glouds.project.chess.bean.config.PIECE;

public class Step {
	public int index;
	public CAMP camp;
	public String step;
	public PIECE piece;
	public Point from;
	public Point to;
	public boolean isKill;
	public PIECE killed;

	public static String forward = "进";
	public static String backward = "退";
	public static String sideward = "平";

	public String formatStep() {
		StringBuilder sb = new StringBuilder();
		sb.append(piece);
		sb.append(camp == CAMP.CAMP_RED ? 9 - from.y : 1 + to.y);
		if (camp == CAMP.CAMP_RED) {
			if (to.x < from.x)
				sb.append(forward);
			else if (from.x > to.x)
				sb.append(backward);
			else
				sb.append(sideward);
		} else {
			if (to.x < from.x)
				sb.append(backward);
			else if (from.x > to.x)
				sb.append(forward);
			else
				sb.append(sideward);
		}
		if(from.x == to.x) {
			if(camp == CAMP.CAMP_RED) {
				sb.append(9 - to.y);
			}else {
				sb.append(to.y + 1);
			}
		}else if(from.y == to.y) {
			sb.append(Math.abs(from.y - to.y));
		}else {
			if(camp == CAMP.CAMP_RED) {
				sb.append(9 - to.y);
			}else {
				sb.append(to.y + 1);
			}
		}
		step = sb.toString();
		return step;
	}
}
