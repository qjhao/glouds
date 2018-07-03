package com.eagerto.ws.service;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.eagerto.ws.bean.FaultBean;
import com.eagerto.ws.exception.FaultException;
import com.eagerto.ws.interfaces.ITestService;

@WebService(targetNamespace = "http://www.eagerto.com")
public class TestServiceImpl implements ITestService {

	@Override
	@WebMethod(operationName = "test1")
	public String test() {
		return "now is " + new Date();
	}
	
	@WebMethod(operationName = "test2")
	public String test2() throws FaultException {
		FaultBean bean = new FaultBean();
		bean.setMessage("自定义异常11");
		throw new FaultException("自定义异常");
	}

}
