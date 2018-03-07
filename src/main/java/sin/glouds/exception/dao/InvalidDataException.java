package sin.glouds.exception.dao;

public class InvalidDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	  
	  public InvalidDataException(String msg)
	  {
	    super(msg);
	  }
	  
	  public String getMessage()
	  {
	    return "无效数据：" + super.getMessage();
	  }
}
