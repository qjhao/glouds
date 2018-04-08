package sin.mymusic.util;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sin.glouds.common.Global;
import sin.mymusic.entity.Music;
import sin.mymusic.util.MusicUtil;

public final class Context {

	private static List<Music> musics = new ArrayList<>();
	private static Random ran = new Random();

	public static List<Music> getMusics() {
		return getMusics(false);
	}
	
	public static List<Music> getMusics(boolean fresh) {
		try {
			musics.addAll(MusicUtil.getMusics("", fresh));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return musics;
	}
	
	public static List<Music> getMusics(String port) {
		try {
			musics.addAll(MusicUtil.getMusics("", true, port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return musics;
	}

	public static Music play(HttpServletRequest request) {
		if(musics.size() == 0) {
			getMusics(Global.getConfig("musicFilePort"));
		}
		if(musics.size() == 0)
			return null;
		int r = ran.nextInt(musics.size());
		HttpSession session = request.getSession();
		session.setAttribute("currentIndex", r);
		return musics.get(r);
	}
	
	public static Music next(HttpServletRequest request) {
		if(musics.size() == 0) {
			getMusics(Global.getConfig("musicFilePort"));
		}
		if(musics.size() == 0)
			return null;
		int r = -1;
		HttpSession session = request.getSession();
		if(session.getAttribute("currentIndex") != null) {
			r = Integer.parseInt(session.getAttribute("currentIndex").toString()) + 1;
			r = r % musics.size();
		}
		if(r == -1)
			r = ran.nextInt(musics.size());
		session.setAttribute("currentIndex", r);
		return musics.get(r);
	}
	
	public static Music nextRandom(HttpServletRequest request) {
		if(musics.size() == 0) {
			getMusics(Global.getConfig("musicFilePort"));
		}
		if(musics.size() == 0)
			return null;
		int r = ran.nextInt(musics.size());
		HttpSession session = request.getSession();
		session.setAttribute("currentIndex", r);
		return musics.get(r);
	}
}
