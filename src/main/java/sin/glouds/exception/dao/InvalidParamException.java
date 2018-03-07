package sin.glouds.exception.dao;

public class InvalidParamException extends RuntimeException {
	private static final long serialVersionUID = -7769031711772817076L;

	public InvalidParamException(String msg) {
		super(msg);
	}

	public String getMessage() {
		return "无效的参数：" + super.getMessage();
	}
}
