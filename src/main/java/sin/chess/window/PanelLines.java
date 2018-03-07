package sin.chess.window;

import java.util.ArrayList;
import java.util.List;

public class PanelLines {
	public List<Line> lines = new ArrayList<>();
	public static int unitWidth = 50;
	public static int x0 = 25,xn = unitWidth * 8 +x0,y0 = 25, yn = unitWidth * 9 + y0,ym = unitWidth * 4 + y0;
	
	public PanelLines() {
		for(int i=0;i<10;i++)
			lines.add(new Line(x0, y0 + unitWidth * i, xn, y0 + unitWidth * i));
		for(int i=0;i<9;i++) {
			if(i == 0 || i == 8) {
				lines.add(new Line(x0 + unitWidth*i, y0, x0 + unitWidth*i, yn));
			}else {
				lines.add(new Line(x0 + unitWidth*i, y0, x0 + unitWidth*i, ym));
				lines.add(new Line(x0 + unitWidth*i, ym + unitWidth, x0 + unitWidth*i, yn));
			}
		}
		lines.add(new Line(x0 + unitWidth * 3, y0, x0 + unitWidth * 5, y0 + unitWidth * 2));
		lines.add(new Line(x0 + unitWidth * 3, y0 + unitWidth * 2, x0 + unitWidth * 5, y0));
		lines.add(new Line(x0 + unitWidth * 3, yn, x0 + unitWidth * 5, yn - unitWidth * 2));
		lines.add(new Line(x0 + unitWidth * 3, yn - unitWidth * 2, x0 + unitWidth * 5, yn));
	}
}
