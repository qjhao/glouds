package sin.glouds.util.webservice;

import javax.xml.soap.SOAPFault;

public class SoapResult<T> {

	private boolean flag;
	private T result;
	private SOAPFault errorMessage;
	
	public static <E> SoapResult<E> success(E result) {
		SoapResult<E> soapResult = new SoapResult<E>();
		soapResult.setFlag(true);
		soapResult.setResult(result);
		return soapResult;
	}
	
	public static <E> SoapResult<E> fail(SOAPFault fault) {
		SoapResult<E> soapResult = new SoapResult<E>();
		soapResult.setFlag(false);
		soapResult.setErrorMessage(fault);
		return soapResult;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public SOAPFault getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(SOAPFault errorMessage) {
		this.errorMessage = errorMessage;
	}

}
