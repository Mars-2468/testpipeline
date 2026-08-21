package com.mars.common.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(String toEmail, String subject, String body){
		try
	    {
			final String fromEmail = "nmcegovrts@gmail.com"; //requires valid gmail id//password=Redhat@2k24#
			//final String password = "xyklmxoxqcmbebna"; // correct password for gmail id
			final String password ="uvlq anpj olxa xjhd";
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "25"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			
	               //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress(fromEmail, false));

	      msg.setReplyTo(InternetAddress.parse(fromEmail, false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());
	      if(toEmail!=null)
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
	      if(toEmail!=null)
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
