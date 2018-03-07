package sin.glouds.test.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.setProperty("mail.host", "smtp.highstore.cn");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties);
		session.setDebug(true);
		
		Transport ts = session.getTransport();
		ts.connect("smtp.highstore.cn","hzqinjianhao@highstore.cn","qjhao123..");
		
		Message message = createSimpleMessage(session);
		
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createSimpleMessage(Session session) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("hzqinjianhao@highstore.cn"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("1916852789@qq.com"));
		message.setSubject("邮件测试");
		message.setContent("这是一封测试邮件", "text/html;charset=UTF-8");
		return message;
	}
}
