package sin.glouds.secret.reading;

import java.io.IOException;

import sin.glouds.util.ebooks.alpha.EBookAdapter;

public class Test extends EBookAdapter {

	public static void main(String[] args) throws IOException {
		Test test = new Test();
//		Entries entries = test.getChapterEntries("http://www.rushuwu.com");
//		int i = 1;
//		for(Entry entry : entries) {
//			System.out.println(i++ + "\t" + entry.title);
//		}
		System.out.println(test.getHtml("http://www.x23us.com/html/27/27936/"));
//		String fileName = "H://sins/sins/src/main/resource/123";
//		BufferedReader reader = new BufferedReader(new FileReader(fileName));
//		int i = Integer.parseInt(reader.readLine());
//		reader.close();
//		System.out.println(i);
//		PrintWriter writer = new PrintWriter(fileName);
//		writer.write(i + 1 + "");
//		writer.close();
		
	}
}
