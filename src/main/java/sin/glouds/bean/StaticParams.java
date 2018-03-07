package sin.glouds.bean;

import java.util.HashMap;
import java.util.Map;

public class StaticParams {
	@SuppressWarnings("serial")
	public static final Map<String, String> ORDER_STATUS = new HashMap<String, String>() {
		{
			put("50","打单");
			put("100", "分拣");
			put("200", "打包");
			put("300", "发货");
			put("400", "分拣缺货");
			put("500", "海关扣留");
			put("550", "海关返回数据");
		}
	};
}
