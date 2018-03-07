package sin.glouds.test.vaudio;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class SimpleAudioPlayer {
	private Player audioPlayer = null;
	
	public SimpleAudioPlayer(URL url) throws IOException,NoPlayerException,CannotRealizeException {
		audioPlayer = Manager.createRealizedPlayer(url);
	}
	
	@SuppressWarnings("deprecation")
	public SimpleAudioPlayer(File file) throws IOException,NoPlayerException,CannotRealizeException {
		this(file.toURL());
	}
	
	public void play() {
		audioPlayer.start();
	}
	public void stop() {
		audioPlayer.stop();
		audioPlayer.close();
	}
	public static void main(String[] args) throws NoPlayerException, CannotRealizeException, IOException, InterruptedException {
		File audioFile = new File("E:/123.mp3");
		SimpleAudioPlayer player = new SimpleAudioPlayer(audioFile);
		player.play();
		System.out.println("play:start");
		Thread.sleep(100000);
		player.stop();
		System.out.println("play:stop");
	}
}
