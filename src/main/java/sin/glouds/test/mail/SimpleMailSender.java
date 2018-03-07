package sin.glouds.test.mail;

import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SimpleMailSender {
	
	private Properties props = System.getProperties();

	private MailAuthenticator mailAuthenticator;
	
	private Session session;
	
	public SimpleMailSender(final String hostName, final String username, final String password) {
		init(username, password, hostName);
	}
	
	public SimpleMailSender(final String username, final String password) {
		String hostName = "smtp." + username.split("@")[1];
		init(username, password, hostName);
	}
	
	public void init(String username, String password, String hostName) {
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", hostName);
		
		mailAuthenticator = new MailAuthenticator(username, password);
		
		session = Session.getDefaultInstance(props, mailAuthenticator);
	}
	
	public void send(String recipient, String subject, Object content) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(mailAuthenticator.getUsername()));
		message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
		message.setSubject(subject);
		message.setContent(content.toString(), "text/html;charset=utf-8");
		
		Transport.send(message);
	}
	
	public void send(List<String> recipients, String subject, Object content) throws AddressException, MessagingException {
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(mailAuthenticator.getUsername()));
		
		InternetAddress[] addresses = new InternetAddress[recipients.size()];

		for(int i = 0; i < recipients.size(); i++) {
			addresses[i] = new InternetAddress(recipients.get(i));
		}
		
		message.setRecipients(RecipientType.TO, addresses);
		message.setSubject(subject);
		message.setContent(content.toString(), "text/html;charset=utf-8");
		
		Transport.send(message);
	}
	
	public static void main(String[] args) throws AddressException, MessagingException {
		SimpleMailSender sender = new SimpleMailSender("hzqinjianhao@highstore.cn", "qjhao123..");
		sender.send("1916852789", "test", "my test.");
	}
}
