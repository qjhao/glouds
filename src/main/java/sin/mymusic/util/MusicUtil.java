package sin.mymusic.util;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import sin.glouds.common.config.Global;
import sin.mymusic.entity.Music;

/**
 * 获取音乐文件工具类 由于加了网址前缀，某些情况下只能本机访问相应文件
 * 例：已安装虚拟机的系统，由于InetAddress无法精确获取局域网IP导致返回地址无效
 * 
 * @author JohnSin
 *
 */
public class MusicUtil {

	private static final String space = "D://KwDownload/song";
	private static List<Music> musicList = new ArrayList<>();

	/**
	 * 获取filePath目录下所有MP3格式文件
	 * 
	 * @param filePath
	 *            文件目录
	 * @return
	 * @throws UnknownHostException
	 *             FileNotFoundException
	 * @author JohnSin
	 */
	public static List<Music> getMusics(String filePath) throws UnknownHostException {
		return getMusics(filePath, true);
	}

	private static void addAllMusic(File file, List<Music> list, String url) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File f : files) {
				addAllMusic(f, list, url);
			}
		} else {
			if (file.getName().endsWith(".mp3")) {
				Music music = new Music();
				String name = file.getName();
				music.setName(name.length() > 4 ? name.substring(0, name.length() - 4) : name);
				music.setUrl(url + "/" + file.getName());
				list.add(music);
			}
		}

	}

	/**
	 * 获取filePath目录下所有MP3格式文件
	 * 
	 * @param filePath
	 *            文件目录
	 * @param ifRefresh
	 *            是否刷新音乐列表
	 * @return
	 * @throws UnknownHostException
	 *             FileNotFoundException
	 * @author JohnSin
	 */
	public static List<Music> getMusics(String filePath, boolean ifRefresh) throws UnknownHostException {
		return getMusics(filePath, ifRefresh, Global.getConfig("musicFilePort"));
	}

	/**
	 * 获取filePath目录下所有MP3格式文件
	 * 
	 * @param filePath
	 *            文件目录
	 * @param ifRefresh
	 *            是否刷新音乐列表
	 * @param port
	 *            服务端端口号
	 * @return
	 * @throws UnknownHostException
	 *             FileNotFoundException
	 * @author JohnSin
	 */
	public static List<Music> getMusics(String filePath, boolean ifRefresh, String port) throws UnknownHostException {
		if (ifRefresh)
			musicList.clear();
		if (musicList.size() == 0) {
			File file = null;
			if (sin.glouds.util.StringUtil.isEmpty(filePath))
				file = new File(space);
			if (file == null)
				file = new File(filePath);
			if (!file.exists())
				return musicList;
			InetAddress host = Inet4Address.getLocalHost();
			String localhost = host.getHostAddress();
			addAllMusic(file, musicList, "http://" + localhost + ":" + port + "/song");
		}
		return musicList;
	}

	public static void main(String[] args) {
		try {
			getMusics("");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
