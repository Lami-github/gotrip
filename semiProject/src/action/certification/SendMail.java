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
	    String subject = "여행가좌 인증번호"; // 메일 제목
	    String message = "인증번호 \n" + certnum + "\n를 입력해 주십시오"; // 메일 내용
	    
	    // SMTP 서버 설정
	    final String host = "smtp.gmail.com"; // 사용할 smtp host, naver라면 smtp.naver.com
	    final String accountId = "amajoinus";
	    final String accountPwd = "amajoinus123";
	    final int port = 465; // SMTP 포트
	     
	    String receiver = email; // 받는사람 이메일
	    String sender = "amajoinus@gmail.com"; // 보내는사람 이메일
	     
	    // Property 정보 생성
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // 사용자 인증
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage 생성
	    mimeMessage.setFrom(new InternetAddress(sender)); // 보내는 EMAIL (정확히 적어야 SMTP 서버에서 인증 실패되지 않음)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	    
	    
	    return certnum;
	}
	
	public void IDmailSender(String id, String email) throws AddressException, MessagingException{
	    
	    String subject = "여행가좌 아이디 찾기"; // 메일 제목
	    String message = "당신의 ID는 \n" + id + "\n입니다."; // 메일 내용
	    
	    // SMTP 서버 설정
	    final String host = "smtp.naver.com"; // 사용할 smtp host, naver라면 smtp.naver.com
	    final String accountId = "minji200";
	    final String accountPwd = "*Kalswl0529";
	    final int port = 465; // SMTP 포트
	     
	    String receiver = email; // 받는사람 이메일
	    String sender = "minji200@naver.com"; // 보내는사람 이메일
	     
	    // Property 정보 생성
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // 사용자 인증
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage 생성
	    mimeMessage.setFrom(new InternetAddress(sender)); // 보내는 EMAIL (정확히 적어야 SMTP 서버에서 인증 실패되지 않음)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	}
	
	public void PWmailSender(String dbPasswd, String email) throws AddressException, MessagingException{
	    
	    String subject = "여행가좌 비번 찾기"; // 메일 제목
	    String message = "당신의 PW는 \n" + dbPasswd + "\n입니다."; // 메일 내용
	    
	    // SMTP 서버 설정
	    final String host = "smtp.naver.com"; // 사용할 smtp host, naver라면 smtp.naver.com
	    final String accountId = "minji200";
	    final String accountPwd = "*Kalswl0529";
	    final int port = 465; // SMTP 포트
	     
	    String receiver = email; // 받는사람 이메일
	    String sender = "minji200@naver.com"; // 보내는사람 이메일
	     
	    // Property 정보 생성
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
	     
	    // 사용자 인증
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	            return new javax.mail.PasswordAuthentication(accountId, accountPwd);
	        }
	    });
	    session.setDebug(true);
	     
	    Message mimeMessage = new MimeMessage(session); //MimeMesage 생성
	    mimeMessage.setFrom(new InternetAddress(sender)); // 보내는 EMAIL (정확히 적어야 SMTP 서버에서 인증 실패되지 않음)
	    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver)); 
	     
	    // Message Setting
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(message);
	    Transport.send(mimeMessage); // Transfer
	    
	}
}
