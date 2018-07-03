package com.eagerto.ws.exception;

import javax.xml.ws.WebFault;

import com.eagerto.ws.bean.FaultBean;

@WebFault(faultBean="com.eagerto.ws.bean.FaultBean")
public class FaultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5612899807007813575L;

	private FaultBean faultBean;

	public FaultException() {
		super();
	}
	
	public FaultException(String message) {
		super(message);
	}
	
	public FaultException(String message, FaultBean faultBean,
            Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }

    public FaultException(String message, FaultBean faultBean) {
        super(message);
        this.faultBean = faultBean;
    }

    public FaultBean getFaultInfo() {
        return faultBean;
    }
}
