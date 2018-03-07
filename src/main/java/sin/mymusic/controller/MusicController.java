package sin.mymusic.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sin.glouds.controller.BaseController;
import sin.mymusic.entity.Music;
import sin.mymusic.service.MusicService;

@Controller
public class MusicController extends BaseController {

	@Resource
	private MusicService musicService;
	
	@ResponseBody
	@RequestMapping("/music/getAll")
	public String getAll() {
		return gson.toJson(musicService.getAll());
	}
	
	@ResponseBody
	@RequestMapping("/music/play")
	public String play(HttpServletRequest request) {
		Music music = musicService.play(request);
		if(music == null) {
			return fail("获取音频文件失败");
		}
		return success(music);
	}

	@ResponseBody
	@RequestMapping("/music/next")
	public String next(HttpServletRequest request) {
		Music music = musicService.next(request);
		if(music == null) {
			return fail("获取音频文件失败");
		}
		return success(music);
	}
	
	@ResponseBody
	@RequestMapping("/music/nextRandom")
	public String nextRandom(HttpServletRequest request) {
		Music music = musicService.nextRandom(request);
		if(music == null) {
			return fail("获取音频文件失败");
		}
		return success(music);
	}
}
