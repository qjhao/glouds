package sin.mymusic.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import sin.glouds.bean.TaskStatus;
import sin.mymusic.entity.Music;
import sin.mymusic.util.Context;

@Service
public class MusicService {
	
	public TaskStatus getAll() {
		Map<String, Object> map = new HashMap<>();
		map.put("musicList", Context.getMusics());
		return TaskStatus.SUCCESS("success").setData(map);
	}

	public Music play(HttpServletRequest request) {
		Music music = Context.play(request);
		return music;
	}
	
	public Music next(HttpServletRequest request) {
		Music music = Context.next(request);
		return music;
	}
	
	public Music nextRandom(HttpServletRequest request) {
		Music music = Context.nextRandom(request);
		return music;
	}
}
