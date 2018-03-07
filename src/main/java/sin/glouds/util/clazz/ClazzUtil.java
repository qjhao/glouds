package sin.glouds.util.clazz;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ClazzUtil {

	public static String getClassLocation(Class<?> clazz) {
		URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
		String location = url.getPath();
		if (location.endsWith(".jar")) {
			try {
				return new File(url.toURI()).getAbsolutePath();
			} catch (URISyntaxException e) {
			}
		} else {
			String[] strs = clazz.getName().split("\\.");
			String suffix = "";
			if (strs.length > 0) {
				for (String str : strs) {
					suffix = suffix + "\\" + str;
				}
			} else {
				suffix = clazz.getName() + ".class";
			}
			try {
				location = new File(clazz.getClassLoader().getResource("").toURI()).getAbsolutePath() + suffix
						+ ".class";
				return location;
			} catch (URISyntaxException e) {

			}
		}
		return "get class location failed";
	}
}
