package sin.glouds.util.ebooks.alpha;

import java.util.HashMap;
import java.util.Map;

public enum FilterType {
	ID,CLASS,ATTR,TAG;
	
	@SuppressWarnings("serial")
	public static Map<String, FilterType> typeMap = new HashMap<String, FilterType>() {
		{
			put("id", ID);
			put("class", CLASS);
			put("attribute", ATTR);
			put("tag", TAG);
		}
	};
}
