package sin.glouds.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sin.glouds.beans.NetProperties;
/**
 * 
 * @author glouds
 * @see mail.jar
 *
 */
public class MailUtils {

	private static boolean sendMail(String host, String username, String password, String receiver, String subject, String content, Boolean ifThrowException) throws Exception {
		if(ifThrowException)
			return sendMailWithException(host, username, password, receiver, subject, content);
		return sendMailWithOutException(host, username, password, receiver, subject, content);
	}
	
	/**
	 * 当前仅支持海仓邮件发送服务器
	 * 
	 * @param username 发件人邮箱
	 * @param password 密码
	 * @param receiver 收件人邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @return 邮件是否发送成功
	 * @throws Exception
	 */
	public static boolean sendMail(String username, String password, String receiver, String subject, String content) throws Exception {
		return sendMail(NetProperties.MAIL_HOST, username, password, receiver, subject, content, false);
	}
	
	/**
	 * 当前仅支持海仓邮件发送服务器
	 * 
	 * @param receiver 收件人邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @return 邮件发送是否成功
	 * @throws Exception
	 */
	public static boolean sendMail(String receiver, String subject, String content) throws Exception {
		return sendMail(NetProperties.MAIL_HOST, NetProperties.MAIL_USERNAME, NetProperties.MAIL_PASSWORD, receiver, subject, content, false);
	}
	
	/**
	 * 当前仅支持海仓邮件发送服务器
	 * 
	 * @param username 发件人邮箱
	 * @param password 密码
	 * @param receiver 收件人邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @param ifThrowException 是否作抛出异常处理
	 * @return 邮件发送是否成功
	 * @throws Exception
	 */
	public static boolean sendMail(String username, String password, String receiver, String subject, String content, boolean ifThrowException) throws Exception {
		return sendMail(NetProperties.MAIL_HOST, username, password, receiver, subject, content, ifThrowException);
	}
	
	/**
	 * 当前仅支持海仓邮件发送服务器
	 * 
	 * @param receiver 收件人邮箱
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @param ifThrowException 是否作异常抛出处理
	 * @return 发送是否成功
	 * @throws Exception
	 */
	public static boolean sendMail(String receiver, String subject, String content, boolean ifThrowException) throws Exception {
		return sendMail(NetProperties.MAIL_HOST, NetProperties.MAIL_USERNAME, NetProperties.MAIL_PASSWORD, receiver, subject, content, ifThrowException);
	}
	
	private static Message createSimpleMessage(Session session, String username, String receiver, String subject, String content) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=UTF-8");
		return message;
	}
	
	private static boolean sendMailWithOutException(String host, String username, String password, String receiver, String subject, String content) {
		try{
			if(StringUtil.isEmpty(host) || StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(receiver) || StringUtil.isEmpty(subject) || StringUtil.isEmpty(content)) {
				throw new IllegalArgumentException("参数不允许为空");
			}
			
			Properties properties = new Properties();
			properties.setProperty("mail.host", host);
			properties.setProperty("mail.transport.protocol", "smtp");
			properties.setProperty("mail.smtp.auth", "true");
			
			Session session = Session.getInstance(properties);
			session.setDebug(true);
			
			Transport ts = session.getTransport();
			ts.connect(host,username,password);
			
			Message message = createSimpleMessage(session, username, receiver, subject, content);
			
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean sendMailWithException(String host, String username, String password, String receiver, String subject, String content) throws Exception {
		if(StringUtil.isEmpty(host) || StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(receiver) || StringUtil.isEmpty(subject) || StringUtil.isEmpty(content)) {
			throw new IllegalArgumentException("参数不允许为空");
		}
		
		Properties properties = new Properties();
		properties.setProperty("mail.host", host);
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties);
		session.setDebug(true);
		
		Transport ts = session.getTransport();
		ts.connect(host,username,password);
		
		Message message = createSimpleMessage(session, username, receiver, subject, content);
		
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
		return true;
	}
}
