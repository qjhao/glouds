package sin.chess.bean.config;

import java.util.HashMap;
import java.util.Map;

public enum ENDTYPE {

	TIME_OVER,FATAL_MOVE,SURRENDER;
	
	@SuppressWarnings("serial")
	public static Map<ENDTYPE, String> endType = new HashMap<ENDTYPE, String>(){
		{
			put(TIME_OVER, "超时判负");
			put(FATAL_MOVE, "绝杀");
			put(ENDTYPE.SURRENDER, "弃子认输");
		}
	};
}
