package sin.glouds.interest.biquge;

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
	
	private final String path = "F://sins/sins/file/books/biquge/";
	
	public static void main(String[] args) {
		new Test().start("https://www.ybdu.com/book/allvisit/0/", "/", 665);
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
							JConnector.preparedStatement("insert into novel_biquge (title,url,author,length,date,status,path) values ('" + novel.getTitle() + "','" + novel.getUrl() + "','" + novel.getAuthor() + "','" + novel.getLength() + "','" + novel.getDate() + "','" + novel.getStatus() + "','" + path + "/" + novel.getTitle() + "')").execute();
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
		Elements elts = document.getElementsByClass("clearfix rec_rullist");
		if(elts == null || elts.size() == 0)
			return novels;
		Element element = elts.first();
		Elements elements = element.getElementsByTag("ul");
		if(elements == null || elements.size() == 0)
			return novels;
		for(Element tr : elements) {
			Elements els = tr.getElementsByTag("li");
			if(els != null && els.size() == 7) {
				Novel novel = new Novel();
				String title = els.get(1).text();
				novel.setTitle(title.endsWith("全文阅读")?title.substring(0, title.length() - 4):title);
				novel.setUrl(els.get(1).getElementsByTag("a").first().attr("href"));
				novel.setAuthor(els.get(3).text());
				novel.setLength(els.get(4).text());
				novel.setDate(els.get(5).text());
				novel.setType(els.get(6).text());
				novel.setStatus("全本");
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
