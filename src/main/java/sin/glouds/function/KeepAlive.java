package sin.glouds.function;

import java.util.Timer;
import java.util.TimerTask;

import sin.glouds.util.MouseUtil;

public class KeepAlive {

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				MouseUtil.moveTo(MouseUtil.getX(), MouseUtil.getY());
			}
		}, 1000);
	}
}
