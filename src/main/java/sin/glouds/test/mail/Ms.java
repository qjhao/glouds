package sin.glouds.test.mail;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Ms {
	private final transient Properties props = System.getProperties();
	private transient Mf mf;
	private transient Session session;
	
	public Ms(final String hostName, final String username, final String password) {
		init(username, password, hostName);
	}
	
	public Ms(final String username, final String password) {
		final String hostName = "smtp." + username.split("@")[1];
		init(username, password, hostName);
	}
	
	private void init(String username, String password, String hostName) {
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", hostName);
		
		mf = new Mf(username, password);
		session = Session.getInstance(props, mf);
	}
	
	public void send(String recipient, String subject, Object content) throws AddressException,MessagingException {
		final MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mf.getUsername()));
		message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
		message.setSubject(subject);
		message.setContent(content.toString(), "text/html;charset=utf-8");
		
		Transport.send(message);
	}
	
	public static void main(String[] args) {
		Ms ms1 = new Ms("1916852789@qq.com", "");
		try {
			ms1.send("1977870413@qq.com", "TEST", "SUCCESS");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
