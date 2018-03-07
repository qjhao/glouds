package sin.glouds.test.vaudio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

@SuppressWarnings("restriction")
public class MusicPlay {
	private AudioStream as;
	ContinuousAudioDataStream cas;
	
	public MusicPlay(URL url) {
		try{
			as = new AudioStream(url.openStream());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		if(as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		}else {
			AudioPlayer.player.start(as);
		}
	}
	
	public void stop() {
		if(as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		}else {
			AudioPlayer.player.stop(as);
		}
	}
	
	public void continuousStart() {
		AudioData data = null;
		try{
			data = as.getData();
		}catch(IOException e) {
			e.printStackTrace();
		}
		cas = new ContinuousAudioDataStream(data);
		
		AudioPlayer.player.start(cas);
	}
	
	public void continuousStop() {
		if(cas != null) {
			AudioPlayer.player.stop(cas);
		}
	}
	
	public void showInfo() {
		try {
			System.out.println(as.available());
			System.out.println(as.getLength());
			System.out.println(as.markSupported());
			System.out.println(as.getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		URL url = MusicPlay.class.getClassLoader().getResource("ttt.wav");
		MusicPlay player = new MusicPlay(url);
		//player.continuousStart();
		//player.start();
		player.showInfo();
	}
}
