package sin.glouds.test.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String str = "秦建浩";
		try {
			System.out.println(PinyinHelper.toHanyuPinyinString(str, new HanyuPinyinOutputFormat(), ""));
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
	}
}
