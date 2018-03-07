package sin.glouds.util.ebooks.beta;

public interface EBookListener {

	void onTaskCreateed(EBookDownloader downloader, String name);

	void onFinish(EBookDownloader downloader);

	void onDownloadFinished(EBookDownloader downloader, String name);

	void onChapterDownloadFinished(EBookDownloader downloader, String name, Chapters chapters);

	void onDownloading(EBookDownloader downloader, int index, int size, String name);

	void onBeforeWrite(EBookDownloader downloader);

	void onAfterWrite(EBookDownloader downloader, String fileName, long size);

	void onBeforeDownloading(EBookDownloader eBookDownloader, String name, Contents contents);

	void onError(EBookDownloader downloader, Exception e);

	void onStartTask(EBookDownloader downloader);

	void onChapterDownloadStarted(EBookDownloader eBookDownloader, String name, Chapters chapters);
}
