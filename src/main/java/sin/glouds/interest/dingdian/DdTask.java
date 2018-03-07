package sin.glouds.interest.dingdian;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sin.glouds.jdao.connector.JConnector;

public class DdTask {
	private final String path = "F://sins/sins/file/books/games";

	public void start(String prefix, String suffix, int size) {
		File file = new File(path);
		if(!file.exists() || !file.isDirectory())
			file.mkdirs();
		for (int i = 1; i < size; i++) {
			final String url = prefix + i + suffix;
			Novels novels = getNovels(url);
			System.out.println(novels.size());
			for(Novel novel : novels) {
				System.out.println(novel.toString());
				try {
					JConnector.preparedStatement("insert into novel (title,url,author,length,date,status,path) values ('" + novel.getTitle() + "','" + novel.getUrl() + "','" + novel.getAuthor() + "','" + novel.getLength() + "','" + novel.getDate() + "','" + novel.getStatus() + "','" + path + "/" + novel.getTitle() + "')").execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Novels getNovels(String url) {
		Novels novels = new Novels();
		Document document = getDocument(url);
		if(document == null)
			return novels;
		Element element = document.getElementById("content");
		if(element == null)
			return novels;
		Elements elements = element.getElementsByTag("tr");
		if(elements == null || elements.size() == 0)
			return novels;
		for(Element tr : elements) {
			Elements els = tr.getElementsByTag("td");
			if(els != null && els.size() == 6) {
				Novel novel = new Novel();
				novel.setTitle(els.get(0).getElementsByTag("a").get(1).text());
				novel.setDesc(els.get(0).getElementsByTag("a").get(1).attr("href"));
				novel.setUrl(els.get(1).getElementsByTag("a").first().attr("href"));
				novel.setAuthor(els.get(2).text());
				novel.setLength(els.get(3).text());
				novel.setDate(els.get(4).text());
				novel.setStatus(els.get(5).text());
				novels.add(novel);
			}
		}
		return novels;
	}
	
	private Document getDocument(String url) {
		try{
			return Jsoup.connect(url).get();
		}catch(IOException e) {
			try{
				return Jsoup.connect(url).get();
			}catch(IOException ex) {
				try{
					return Jsoup.connect(url).get();
				}catch(IOException exc) {
					return null;
				}
			}
		}
	}
	
}
