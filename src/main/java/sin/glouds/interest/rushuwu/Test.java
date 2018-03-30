package sin.glouds.interest.rushuwu;

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

	//private static final String url = "http://www.rushuwu.com/list/6-1.html";
	private final String path = "F://sins/sins/file/books/rushuwu/newest";
	public static void main(String[] args) throws IOException {
		//System.out.println(Jsoup.connect("http://www.rushuwu.com/12/12086/2917031.html").get().html());
		new Test().start("http://www.rushuwu.com/allvote-", ".html", 483);
	}
	
	private void start(String prefix, String suffix, int size) {
//		File file = new File(path);
//		if(!file.exists() || !file.isDirectory())
//			file.mkdirs();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 1; i < size; i++) {
			final String url = prefix + i + suffix;
			final int index = i;
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					Novels novels = getNovels(url);
					System.out.println("第" + index + "页，共" + size + "页，本页含" + novels.size() + "本。");
					for(Novel novel : novels) {
						try {
							String sql = "insert into novel_rushuwu (title,url,author,length,date,status,path,description,desc_url,type) values ('" + novel.getTitle() + "','" + novel.getUrl() + "','" + novel.getAuthor() + "','" + novel.getLength() + "','" + novel.getDate() + "','" + novel.getStatus() + "','" + path + "/" + novel.getTitle() + "','" + novel.getDesc() + "','" + novel.getDescUrl() + "','" + novel.getType() + "')";
							//System.out.println(sql);
							JConnector.preparedStatement(sql).execute();
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
		Elements elts = document.getElementsByClass("ultwo");
		if(elts == null || elts.size() == 0)
			return novels;
		Elements elements = elts.first().getElementsByTag("li");
		if(elements == null || elements.size() == 0)
			return novels;
		for(Element tr : elements) {
			Elements els = tr.getElementsByTag("p");
			if(els != null && els.size() == 4) {
				Novel novel = new Novel();
				novel.setTitle(els.get(0).getElementsByTag("a").first().text());
				novel.setUrl(els.get(0).getElementsByTag("a").first().attr("href"));
				novel.setStatus(els.get(0).getElementsByTag("span").first().text());
				novel.setType(els.get(2).text());
				novel.setDesc(els.get(3).text());
				novels.add(novel);
			}
		}
		return novels;
	}
	
	private Document getDocument(String url) {
		try{
			return Jsoup.connect(url).timeout(5000).get();
		}catch(IOException e) {
			System.out.println(e.getMessage());
			try{
				return Jsoup.connect(url).timeout(5000).get();
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
				try{
					return Jsoup.connect(url).timeout(5000).get();
				}catch(IOException exc) {
					System.out.println(exc.getMessage());
					return null;
				}
			}
		}
	}
}
