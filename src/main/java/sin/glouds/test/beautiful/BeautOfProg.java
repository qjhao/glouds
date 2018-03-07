package sin.glouds.test.beautiful;

import java.util.TimerTask;
import java.util.Timer;

public class BeautOfProg {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				for (int i = 0; i < 40000000; i++) {
					
				}
			}
		}, 500, 500);
	}
}
