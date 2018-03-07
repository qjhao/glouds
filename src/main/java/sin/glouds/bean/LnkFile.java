package sin.glouds.bean;

public class LnkFile {
	public byte[] linkFileHeader;//48 bytes
	public byte[] shellItemIdList;
	public byte[] fileLocationInfo;
	public byte[] descriptionString;
	public byte[] relativePathString;
	public byte[] workingDirectoryString;
	public byte[] commandLineString;
	public byte[] iconFilenameString;
	public byte[] extraStuff;
}
