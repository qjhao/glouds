package sin.glouds.interest.bxwx;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sin.glouds.interest.dingdian.Novel;
import sin.glouds.interest.dingdian.Novels;
import sin.glouds.jdao.connector.JConnector;

public class Test {

	private final String path = "F://sins/sins/file/books/bxwx/";
	private static final String url = "http://www.bxwx9.org/modules/article/index.php?fullflag=1&page=";
	
	public static void main(String[] args) {
		new Test().start(url, "", 213);
	}

	public void start(String prefix, String suffix, int size) {
		File file = new File(path);
		if(!file.exists() || !file.isDirectory())
			file.mkdirs();
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 1; i < size; i++) {
			final int index = i;
			service.submit(new Runnable() {
				public void run() {
					final String url = prefix + index + suffix;
					Novels novels = getNovels(url);
					System.out.println("第" + index + "页，数量：" + novels.size());
					for(Novel novel : novels) {
						//System.out.println(novel.toString());
						try {
							JConnector.preparedStatement("insert into novel_bxwx (title,url,author,length,date,status,path) values ('" + novel.getTitle() + "','" + novel.getUrl() + "','" + novel.getAuthor() + "','" + novel.getLength() + "','" + novel.getDate() + "','" + novel.getStatus() + "','" + path + "/" + novel.getTitle() + "')").execute();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
	
	private Novels getNovels(String url) {
		Novels novels = new Novels();
		Document document = getDocument(url);
		if(document == null)
			return novels;
		Elements elts = document.getElementsByClass("grid");
		if(elts == null || elts.size() == 0)
			return novels;
		Element element = elts.first();
		Elements elements = element.getElementsByTag("tr");
		if(elements == null || elements.size() == 0)
			return novels;
		for(Element tr : elements) {
			Elements els = tr.getElementsByTag("td");
			if(els != null && els.size() == 6) {
				Novel novel = new Novel();
				String title = els.get(0).text();
				novel.setTitle(title);
				novel.setUrl(els.get(0).getElementsByTag("a").first().attr("href"));
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
