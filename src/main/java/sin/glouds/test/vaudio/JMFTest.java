package sin.glouds.test.vaudio;

import java.io.File;

import javax.media.ControllerAdapter;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.media.StopEvent;
import javax.media.Time;

public class JMFTest {
	private static Player player;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		player = Manager.createRealizedPlayer(new File("C://hjb/sins/common/audio/ttt.wav").toURL());
		player.addControllerListener(new PlayerEventHandler());
		player.setMediaTime(new Time(180.0));
		player.setStopTime(new Time(185.0));
		player.start();
		System.out.println(player.getMediaTime().getSeconds());
	}

	private static class PlayerEventHandler extends ControllerAdapter {
		public void endOfMedia(EndOfMediaEvent e) {
			System.out.println("end");
			player.setMediaTime(new Time(1.0));
			player.start();
		}

		public void realizeComplete(RealizeCompleteEvent realizeDoneEvent) {
			player.prefetch(); // 预取媒体数据
		}

		// 完成预取媒体数据后，开始播放媒体
		public void prefetchComplete(PrefetchCompleteEvent prefetchDoneEvent) {
			player.start(); // 开始播放媒体
		}

		@Override
		public void stop(StopEvent e) {
			System.out.println(player.getMediaTime().getSeconds());
			player.start();
			System.out.println(player.getMediaTime().getSeconds());
		}

	}
}
