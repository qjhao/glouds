package sin.glouds.util.ebooks.beta;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String url = "http://www.23us.com/html/26/26491/";
		new EBookDownloader("王朝教父.txt", "F://sins/sins/files", url, url
				, FilterType.ID, "contents", new EBookAdapter() {
				}).startTask();
	}
}
