package sin.glouds.util.ebooks.beta;

public abstract class EBookAdapter implements EBookListener {

	@Override
	public void onTaskCreateed(EBookDownloader downloader, String name) {
		EBooks.books.put(name, new EBookInfo(name));
		System.out.println("-----开始任务：" + name + "----------");
	}

	@Override
	public void onFinish(EBookDownloader downloader) {
		System.out.println("任务完成！！！！");
	}

	@Override
	public void onDownloadFinished(EBookDownloader downloader, String name) {
		downloader.write(EBooks.books.get(name).getContents());
		System.out.println("下载完成！！！！");
	}

	@Override
	public void onChapterDownloadFinished(EBookDownloader downloader,String name,Chapters chapters) {
		EBooks.books.get(name).setChapters(chapters);
		System.out.println("成功获取章节目录");
		downloader.getContents(chapters);
	}

	@Override
	public void onDownloading(EBookDownloader downloader, int index, int size, String name) {
		System.out.println("下载中  " + ((index * 100) / size) + "%");
		if(index == size) {
			System.out.println("下载完成！！！！");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			downloader.service.shutdown();
			downloader.write(EBooks.books.get(name).getContents());
		}
	}

	@Override
	public void onBeforeWrite(EBookDownloader downloader) {
		System.out.println("开始写入文件");
	}

	@Override
	public void onAfterWrite(EBookDownloader downloader, String fileName, long size) {
		System.out.println("文件写入完成，文件地址为：" + fileName + ", 文件大小为：" + (size / 1024) + " KB");
	}
	
	@Override
	public void onBeforeDownloading(EBookDownloader downloader,String name,Contents contents) {
		EBooks.books.get(name).setContents(contents);
		System.out.println("开始下载");
	}
	
	@Override
	public void onError(EBookDownloader downloader,Exception e) {
		System.err.println("程序发生异常" + e.getMessage());
	}
	
	@Override
	public void onStartTask(EBookDownloader downloader) {
		System.out.println("开始任务。。。。");
		downloader.getChapterEntries();
	}

	@Override
	public void onChapterDownloadStarted(EBookDownloader eBookDownloader, String name, Chapters chapters) {
		EBooks.books.get(name).setChapters(chapters);;
		System.out.println("开始获取章节目录");
	}
}
