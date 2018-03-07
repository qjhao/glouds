package sin.glouds.test.sound;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class BackMusic {

	private String musicPath;
	private volatile boolean run = true;
	private Thread mainThread;
	
	private AudioInputStream audioStream;
	private AudioFormat audioFormat;
	private SourceDataLine sourceDataLine;
	
	public BackMusic(String musicPath) {
		this.musicPath = musicPath;
		prefetch();
	}
	
	private void prefetch() {
		try{
			audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
			audioFormat = audioStream.getFormat();
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
			
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		sourceDataLine.drain();
		sourceDataLine.close();
		audioStream.close();
	}
	
	private void playMusic(boolean loop) throws Exception {
		try {
			if(loop) {
				while(true) {
					playMusic();
				}
			}else {
				playMusic();
				sourceDataLine.drain();
				sourceDataLine.close();
				audioStream.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void playMusic() {
		try {
			synchronized (this) {
				run = true;
			}
			
			audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
			int count;
			byte tempBuff[] = new byte[1024];
			
			while((count = audioStream.read(tempBuff, 0, tempBuff.length)) != -1) {
				synchronized (this) {
					while(!run) {
						wait();
					}
				}
				sourceDataLine.write(tempBuff, 0, count);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void stopMusic() {
		synchronized (this) {
			run = false;
			notifyAll();
		}
	}
	
	private void continueMusic() {
		synchronized (this) {
			run = true;
			notifyAll();
		}
	}
	
	public void start(boolean loop) {
		mainThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					playMusic(loop);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		mainThread.start();
	}
	
	public void stop() {
		new Thread(new Runnable() {
			public void run() {
				stopMusic();
			}
		}).start();
	}
	
	public void continues() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				continueMusic();
			}
		}).start();
	}
	
	public static void main(String[] args) throws Exception {
		BackMusic player = new BackMusic("F:/sins/sins/src/main/resource/ttt.wav");
		player.start(true);
		TimeUnit.SECONDS.sleep(5);
		player.stop();
		TimeUnit.SECONDS.sleep(4);
		player.continues();
	}
}
