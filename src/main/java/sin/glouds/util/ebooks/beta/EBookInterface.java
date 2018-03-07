package sin.glouds.util.ebooks.beta;

import java.io.File;

public interface EBookInterface {
	Chapters getChapterEntries(String url);
	Contents getContents(Chapters entries, String url, FilterType type, String filterValue);
	void write(File file, Contents contents);
	String format(String content);
}
