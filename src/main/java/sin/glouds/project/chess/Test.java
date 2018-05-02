package sin.glouds.project.chess;

import java.util.Scanner;

import sin.glouds.project.chess.bean.board.Point;
import sin.glouds.project.chess.bean.play.Play;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		//test();
		Play play = new Play();
		System.out.println(play.click(9, 7));
		System.out.println(play.click(7, 6));
		play.move(new Point(9, 7), new Point(7, 6));
		play.printChessBoard();
		play.printQipu();
	}

	public static void start() {
		Scanner scanner = new Scanner(System.in);

		String line;
		Play play = new Play();

		while (true) {
			line = scanner.nextLine();
			if ("exit".equals(line.trim()))
				break;
			if (!"".equals(line)) {
				if ("printBoard".equals(line)) {
					play.printChessBoard();
				} else if ("printBook".equals(line)) {
					play.printQipu();
				} else {
					if (line.length() == 4) {
						play.move(line);
					}
				}
			}
		}

		scanner.close();
	}

	public static void test() {
		Play play = new Play();
		play.move("象三进五");
		play.move("象三进五");
		play.move("象三进五");
		play.printQipu();
	}
}
