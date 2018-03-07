package sin.chess.bean.board;

public class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Point))
			return false;
		Point obj = (Point) o;
		return this.x == obj.x && this.y == obj.y;
	}
}
