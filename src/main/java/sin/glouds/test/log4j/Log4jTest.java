package sin.glouds.test.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jTest.class);
		System.out.println(logger);
		System.out.println(logger.getName() + " " + logger.getLevel());
		logger.info("info");
		logger.debug("debug");
		logger.error("error");
	}
}
