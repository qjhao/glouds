package sin.glouds.test.spider.exception;

public class IllegalRuleException extends RuntimeException {

	private static final long serialVersionUID = -3531899847486801452L;

	public IllegalRuleException() {
		super();
	}
	
	public IllegalRuleException(Throwable cause) {
		super(cause);
	}
	
	public IllegalRuleException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IllegalRuleException(String message) {
		super(message);
	}
}
