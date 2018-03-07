package sin.glouds.util.ebooks.alpha;

import java.io.File;
import java.util.List;

public interface EBookListener {
	List<Entry> getEntries(String url);
	List<String> getContents(List<Entry> entries, String url, FilterType type, String filterValue);
	void write(File file, List<String> contents);
	String format(String content);
}
