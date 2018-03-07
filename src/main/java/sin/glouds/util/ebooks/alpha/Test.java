package sin.glouds.util.ebooks.alpha;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

public class Test {

	public static void main(String[] args) throws IOException {
		// EBookUtil.ebook("http://www.x23us.com/html/51/51230/",
		// "http://www.x23us.com/html/51/51230/");
		
//		String url = "http://www.x23us.com/html/51/51230/28485786.html";
//		Jsoup.connect(url).get().getElementsByAttributeValue("id", "contents").forEach(obj -> System.out.println(obj.text() + "\n=============================="));
//		PrintWriter writer = new PrintWriter(new FileOutputStream("F://sins/sins/files/儒道.txt"));
		String url = "http://www.x23us.com/html/51/51230/";
		List<Entry> entries = new EBookAdapter().getEntries("http://www.x23us.com/html/51/51230/");
//		int index = 1;
//		for (int i = 1490; i < entries.size(); i++) {
//			Entry entry = entries.get(i);
//			System.out.println(entry.url);
//			try {
//				Document doc = Jsoup.connect(url + entry.url).get();
//				writer.println(entry.title + "\n\n" + doc.getElementById("contents").text() + "\n");
//			} catch (IOException e) {
//				if (e instanceof UnknownHostException || e instanceof ConnectException) {
//					try {
//						Document doc = Jsoup.connect(url + entry.url).get();
//						writer.println(entry.title + "\n\n" + doc.getElementById("contents").text() + "\n");
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//				} else {
//					e.printStackTrace();
//				}
//			}
//		}
//		writer.close();
//		for(Entry entry : entries) {
//			System.out.println(index++ + " " +entry.title);
//		}
		Entry entry = entries.get(2133);
		System.out.println(Jsoup.connect(url+entry.url).get().html()+"\n"+entry.title);
	}
}
