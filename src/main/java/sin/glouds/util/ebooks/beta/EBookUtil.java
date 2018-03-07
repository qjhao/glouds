package sin.glouds.util.ebooks.beta;
//package sin.glouds.util.ebooks;
//
//import java.io.File;
//
//public final class EBookUtil {
//
//	private static final EBookListener DEFAULT_LISTENER = new EBookAdapter(); 
//	
//	public static void ebook(EBookListener listener,String filePath,String mainPageUrl, String baseUrl) {
//		File file = new File(filePath);
//		ebook(listener, file, mainPageUrl, baseUrl);
//	}
//	
//	public static void ebook(EBookListener listener,File file, String mainPageUrl, String baseUrl) {
//		if(listener == null)
//			listener = DEFAULT_LISTENER;
//		listener.write(file, listener.getContents(listener.getEntries(mainPageUrl), baseUrl, FilterType.));
//	}
//	
//	public static void ebook(File file, String mainPageUrl, String baseUrl) {
//		ebook(null, file, mainPageUrl, baseUrl);
//	}
//	
//	public static void ebook(String mainPageUrl, String baseUrl) {
//		File file = new File(System.getProperty("user.dir")+"\\files", "ebook.txt");
//		ebook(file, mainPageUrl, baseUrl);
//	}
//}
