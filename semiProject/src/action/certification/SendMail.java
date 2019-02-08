package action.certification;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	private static SendMail instance = new SendMail();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static SendMail getInstance() {
		return instance;
	}

	private SendMail() {
	}
	
	/*@RequestMapping(value="/sendMail")*/
	public int InputmailSender(String email) throws AddressException, MessagingException{
	    
		int certnum = (int)(Math.random()*10000);
		System.out.println(certnum);
	    String subject = "���డ�� ������ȣ"; // ���� ����
	    String message = "������ȣ \n" + certnum + "\n�� �Է��� �ֽʽÿ�"; // ���� ����
	    
	    // SMTP ���� ����
	    final String host = "smtp.gmail.com"; // ����� smtp host, naver��� smtp.naver.com
	    final String accountId = "amajoinus";
	    final String accountPwd = "amajoinus123";
	    final int port = 465; // SMTP ��Ʈ
	     
	    String receiver = email; // �޴»�� �̸���
	    String sender = "amajoinus@gmail.com"; // �����»�� �̸���
	     
	    // Property ���� ����
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // ����� ����
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage ����
	    mimeMessage.setFrom(new InternetAddress(sender)); // ������ EMAIL (��Ȯ�� ����� SMTP �������� ���� ���е��� ����)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	    
	    
	    return certnum;
	}
	
	public void IDmailSender(String id, String email) throws AddressException, MessagingException{
	    
	    String subject = "���డ�� ���̵� ã��"; // ���� ����
	    String message = "����� ID�� \n" + id + "\n�Դϴ�."; // ���� ����
	    
	    // SMTP ���� ����
	    final String host = "smtp.naver.com"; // ����� smtp host, naver��� smtp.naver.com
	    final String accountId = "minji200";
	    final String accountPwd = "*Kalswl0529";
	    final int port = 465; // SMTP ��Ʈ
	     
	    String receiver = email; // �޴»�� �̸���
	    String sender = "minji200@naver.com"; // �����»�� �̸���
	     
	    // Property ���� ����
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // ����� ����
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage ����
	    mimeMessage.setFrom(new InternetAddress(sender)); // ������ EMAIL (��Ȯ�� ����� SMTP �������� ���� ���е��� ����)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	}
	
	public void PWmailSender(String dbPasswd, String email) throws AddressException, MessagingException{
	    
	    String subject = "���డ�� ��� ã��"; // ���� ����
	    String message = "����� PW�� \n" + dbPasswd + "\n�Դϴ�."; // ���� ����
	    
	    // SMTP ���� ����
	    final String host = "smtp.naver.com"; // ����� smtp host, naver��� smtp.naver.com
	    final String accountId = "minji200";
	    final String accountPwd = "*Kalswl0529";
	    final int port = 465; // SMTP ��Ʈ
	     
	    String receiver = email; // �޴»�� �̸���
	    String sender = "minji200@naver.com"; // �����»�� �̸���
	     
	    // Property ���� ����
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // ����� ����
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage ����
	    mimeMessage.setFrom(new InternetAddress(sender)); // ������ EMAIL (��Ȯ�� ����� SMTP �������� ���� ���е��� ����)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	    
	}
}
