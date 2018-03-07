package sin.glouds.util;

import java.util.Timer;
import java.util.TimerTask;

public class KeepLive {

	private static int index = 10;

	public static void start() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (MouseUtil.getX() > 700) {
					index = -10;
				} else if (MouseUtil.getX() < 100) {
					index = 10;
				}

				MouseUtil.moveTo(MouseUtil.getX() + index, MouseUtil.getY());
			}
		}, 0, 1000);
	}
	
	public static void main(String[] args) {
		start();
	}
}
