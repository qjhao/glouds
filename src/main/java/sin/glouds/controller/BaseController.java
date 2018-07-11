package sin.glouds.controller;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sin.glouds.bean.Data;

public class BaseController {

	protected Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	protected Logger logger = Logger.getLogger(getClass());
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	protected String success(Object data) {
		return gson.toJson(Data.SUCCESS.setData(data));
	}
	
	protected String fail(String msg) {
		return gson.toJson(Data.FAIL.setMessage(msg).setData(msg));
	}
	
	protected void error(Object message) {
		logger.error(message);
	}
	
	protected void error(Object message, Throwable e) {
		logger.error(message, e);
	}
	
	protected void warn(Object message) {
		logger.error(message);
	}
	
	protected void warn(Object message, Throwable e) {
		logger.error(message, e);
	}
	
	protected void info(Object message) {
		logger.error(message);
	}
	
	protected void info(Object message, Throwable e) {
		logger.error(message, e);
	}
	
	protected void debug(Object message) {
		logger.error(message);
	}
	
	protected void debug(Object message, Throwable e) {
		logger.error(message, e);
	}
}
