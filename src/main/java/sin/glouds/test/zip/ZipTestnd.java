package sin.glouds.test.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTestnd {

	public static void main(String[] args) throws Exception {
		new ZipTestnd().zip("H://temp/", "H://src");
	}

	public void zip(String targetPath, String sourcePath) {
		try {
			// 1.初始化输出文件
			File target = new File(targetPath);
			if (!target.exists()) {
				if (target.getName().endsWith(".zip") || target.getName().endsWith(".rar")) {
					target.getParentFile().mkdirs();
				} else {
					target.mkdirs();
				}
			}
			if (target.exists()) {
				if (target.isDirectory()) {
					File source = new File(sourcePath);
					if (!source.exists())
						throw new IllegalArgumentException("源文件不存在：" + sourcePath);
					if (source.isFile() && source.getName().contains(".")) {
						target = new File(targetPath,
								source.getName().substring(0, source.getName().lastIndexOf(".")) + ".zip");
					} else {
						target = new File(targetPath, source.getName() + ".zip");
					}
				}
			}

			System.out.println(target.getAbsolutePath());

			// 2.获取所有的文件和目录
			List<File> files = new ArrayList<>();
			File source = new File(sourcePath);
			if(source.isDirectory())
				fillFiles(source.list(), source, files);
			else 
				files.add(source);

			System.out.println(files.size());

			// 3.写入zip文件
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(target));
			
			if(source.isFile()) {
				ZipEntry entry = new ZipEntry(source.getName());
				zos.putNextEntry(entry);
				FileInputStream fis = new FileInputStream(source);
				byte[] bs = new byte[1024];
				int len = 0;
				while ((len = fis.read(bs)) > 0) {
					zos.write(bs, 0, len);
				}
				fis.close();
			}else {
				String drop = source.getAbsolutePath() + "\\";
				System.out.println(drop);
				for (File file : files) {
					String name = file.getAbsolutePath().replace(drop, "");
					if(file.isDirectory())
						name = name + "/";
					System.out.println(name);
					ZipEntry entry = new ZipEntry(name);
					zos.putNextEntry(entry);
					if(file.isFile()) {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void fillFiles(String[] sourcePahts, File sourceParent, List<File> files) {
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
}
