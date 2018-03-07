package sin.glouds.util;

import java.io.File;
import java.io.FileOutputStream;

import sin.glouds.common.config.Global;
import sin.glouds.exception.file.FileIsNotDirectoryException;

public class FileUtil {

	/**
	 * 创建目录
	 * 
	 * @param file
	 */
	public static void makeDirs(File file) {
		if (file.isFile())
			throw new FileIsNotDirectoryException("file param is not a directory");
		if (file.exists())
			return;
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			makeDirs(file.getParentFile());
			file.mkdir();
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param file
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 */
	public static void saveFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	/**
	 * 在用户目录的dir相对目录下新建一个名为file的文件对象，并返回文件对象
	 * 
	 * dir格式应为 /dir/subdir/ fileName 应包含后缀名
	 * 
	 * @param dir
	 *            文件相对目录
	 * @param fileName
	 *            文件名
	 * @return file
	 */
	public static File createFileInUserHome(String dir, String fileName) {
		File file = null;
		if (StringUtil.isNotEmpty(dir) && StringUtil.isNotEmpty(fileName) && dir.matches("^(/[a-zA-Z_0-9\u0391-\uFFE5]*)*/$")
				&& fileName.matches("^[a-zA-z_0-9\u0391-\uFFE5]+(.[a-zA-z0-9]+){0,1}$")) {
			File path = new File(Global.getProjectDataDir() + dir);
			makeDirs(path);
			file = new File(path, fileName);
		}
		return file;
	}
}
