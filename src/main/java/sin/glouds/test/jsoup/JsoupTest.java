package sin.glouds.test.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupTest {

	public static void main(String[] args) throws IOException {
		Connection conn = Jsoup.connect("http://59.110.222.94:8080/sins");
		Document doc = conn.get();
		System.out.println(doc.data());
		System.out.println("=====================================");
		System.out.println(doc.html());
		System.out.println("========================================");
		System.out.println(doc.tag().getName());
		System.out.println("=========================================");
		for(Element element : doc.getAllElements()) {
			System.out.println(element.tagName());
		}
		System.out.println("========================================");
		for(Element element : doc.getAllElements().get(2).siblingElements()) {
			System.out.println(element.tagName());
		}
	}
}
