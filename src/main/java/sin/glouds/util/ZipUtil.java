package sin.glouds.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * zip工具类，提供生成压缩文件和判断文件或输入流是否压缩过的工具类
 * 
 * 类中所有方法都会抛出IOException或RuntimeException异常，必须自行处理
 * 
 * @author JohnSin
 *
 */
public class ZipUtil {

	/**
	 * 判断所给文件是否为压缩文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static boolean isZip(File file) throws IOException {
		return isZip(new FileInputStream(file));
	}

	/**
	 * 判断所给输入流是否为压缩流
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static boolean isZip(InputStream is) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(is);
		bis.mark(2);
		byte[] header = new byte[2];
		bis.reset();
		// Judge header
		int headerData = (int) ((header[0] << 8) | header[1] & 0xFF);
		return headerData == 0x1f8b;
	}

	/**
	 * 将指定的源文件压缩并放在在指定的目标目录下，并返回压缩后的文件
	 * 
	 * @param targetPath
	 * @param sourcePath
	 * @return
	 * @throws RuntimeException
	 */
	public static File createZipFile(String targetPath, String sourcePath) throws RuntimeException {
		return createZipFile(new File(targetPath), new File(sourcePath));
	}

	/**
	 * 将指定的源文件压缩并放在在指定的目标目录下，并返回压缩后的文件
	 * 
	 * @param target
	 * @param sourcePath
	 * @return
	 * @throws RuntimeException
	 */
	public static File createZipFile(File target, String sourcePath) throws RuntimeException {
		return createZipFile(target, new File(sourcePath));
	}

	/**
	 * 将指定的源文件压缩并放在在指定的目标目录下，并返回压缩后的文件
	 * 
	 * @param targetPath
	 * @param source
	 * @return
	 * @throws RuntimeException
	 */
	public static File createZipFile(String targetPath, File source) throws RuntimeException {
		return createZipFile(new File(targetPath), source);
	}

	/**
	 * 将指定的源文件压缩并放在在指定的目标目录下，并返回压缩后的文件
	 * 
	 * @param target
	 * @param source
	 * @return
	 * @throws RuntimeException
	 */
	public static File createZipFile(File target, File source) throws RuntimeException {
		return zip(target, source);
	}

	private static File zip(final File targetFile, final File sourceFile) {
		try {
			File target = new File(targetFile.getAbsolutePath());
			File source = new File(sourceFile.getAbsolutePath());

			// 1.初始化输出文件
			if (!target.exists()) {
				if (target.getName().endsWith(".zip") || target.getName().endsWith(".rar")) {
					target.getParentFile().mkdirs();
				} else {
					target.mkdirs();
				}
			}
			if (target.exists()) {
				if (target.isDirectory()) {
					if (!source.exists())
						throw new IllegalArgumentException("源文件不存在：" + source.getAbsolutePath());
					if (source.isFile() && source.getName().contains(".")) {
						target = new File(target,
								source.getName().substring(0, source.getName().lastIndexOf(".")) + ".zip");
					} else {
						target = new File(target, source.getName() + ".zip");
					}
				}
			}

			// 2.获取所有的文件和目录
			List<File> files = new ArrayList<>();
			if (source.isDirectory())
				fillFiles(source.list(), source, files);
			else
				files.add(source);

			// 3.写入zip文件
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target));

			if (source.isFile()) {
				ZipEntry entry = new ZipEntry(source.getName());
				zos.putNextEntry(entry);
				FileInputStream fis = new FileInputStream(source);
				byte[] bs = new byte[1024];
				int len = 0;
				while ((len = fis.read(bs)) > 0) {
					zos.write(bs, 0, len);
				}
				fis.close();
			} else {
				String drop = source.getAbsolutePath() + "\\";
				for (File file : files) {
					String name = file.getAbsolutePath().replace(drop, "");
					if (file.isDirectory())
						name = name + "/";
					ZipEntry entry = new ZipEntry(name);
					zos.putNextEntry(entry);
					if (file.isFile()) {
						FileInputStream fis = new FileInputStream(file);
						byte[] bs = new byte[1024];
						int len = 0;
						while ((len = fis.read(bs)) > 0) {
							zos.write(bs, 0, len);
						}
						fis.close();
					}
				}
			}
			zos.close();
			return target;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private static void fillFiles(String[] sourcePahts, File sourceParent, List<File> files) {
		for (String path : sourcePahts) {
			File file = null;
			if (sourceParent == null)
				file = new File(path);
			else
				file = new File(sourceParent, path);
			if (!file.exists())
				throw new IllegalArgumentException("源文件不存在：" + path);
			files.add(file);
			if (file.isDirectory())
				fillFiles(file.list(), file, files);
		}
	}

	/**
	 * 将源文件压缩并放到临时文件夹中，返回压缩文件对象
	 * 
	 * @param sourcePath
	 * @return
	 * @throws RuntimeException
	 */
	public static File createTempZipFile(String sourcePath) throws RuntimeException {
		return createTempZipFile(new File(sourcePath));
	}

	/**
	 * 将源文件压缩并放到临时文件夹中，返回压缩文件对象
	 * 
	 * @param source
	 * @return
	 * @throws RuntimeException
	 */
	public static File createTempZipFile(File source) throws RuntimeException {
		try {
			return createZipFile(File.createTempFile("johnsin_temp_zipfile", ".zip"), source);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		File file = createTempZipFile("H://src");
		System.out.println(file.getAbsolutePath());
	}
}
