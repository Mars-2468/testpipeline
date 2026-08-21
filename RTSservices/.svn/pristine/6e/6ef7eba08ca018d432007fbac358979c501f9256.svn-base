package com.mars.mail.service.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mars.common.service.UserService;
import com.mars.common.utils.ApplicationSettings;
import com.mars.mail.service.MailService;
import com.mars.rti.service.RTIApplicationService;

public class MailServiceImpl implements MailService {

	private static Log log = LogFactory.getLog(MailServiceImpl.class);

	private JavaMailSender javaMailSender;

	private VelocityEngine velocityEngine;
	
	private UserService userService;
	
	private RTIApplicationService rtiApplicationService;

	public MailServiceImpl() {

	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	@SuppressWarnings("unchecked")
	public void sendMail(Map<String, Object> mailMap) {

		String mailTemplateName = null;
		
		
		String strSubject = "SMARTRAJRTI Mail";
		String strFilePath = null;
		ArrayList<String> mailList = (ArrayList<String>) mailMap.get("MAILING_LIST");

		if (!mailMap.containsKey("MAIL_TEMPLATE_NAME")) {
			log.error("MAIL TEMPLATE NOT Defined");
			return;
		}

		try {
			mailTemplateName = (String) mailMap.get("MAIL_TEMPLATE_NAME");

			String mailContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, mailTemplateName, mailMap);

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			
			
					 
			 message.addHeaderLine("TEST FROM RTI");

			if (mailMap.containsKey("MAIL_SUBJECT"))
				strSubject = mailMap.get("MAIL_SUBJECT").toString();
			//mailList.add("satheeskumarbe@gmail.com");
			for (String mailAddr : mailList) {
				helper.addTo(mailAddr);
				System.out.println("MailServiceImpl String "+mailAddr);
			}

			if (mailMap.containsKey("FILE_PATH"))
				strFilePath = mailMap.get("FILE_PATH").toString();

			helper.setSubject(strSubject);
			helper.setText(mailContent, true);
			
			
			
			

			if (strFilePath != null) {
				File file = new File(strFilePath);
				helper.addAttachment(file.getName(), file);
			}
			javaMailSender.send(message);
		} catch (MessagingException e) {
			log.error(e.getMessage());
		}

	}

	public void sendEmailNotifiactations() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dNow = new Date();
		String currentDate=(dateFormat.format(dNow));
		String strSender=ApplicationSettings.mailSender;
		int afterSpecificPeriod=Integer.parseInt(ApplicationSettings.mailSendAfterSpecificPeriod);
		
		Map<String,Object> model = new HashMap<String,Object>();
		
		model.put("MAIL_TEMPLATE_NAME", "acknowledgement.vm");
		model.put("sender", strSender);
		//sendMail(model);
			
	}
	
	public int numberOfDays(String currentDate,String ForwardDate){
		 java.util.Calendar cal1 = new java.util.GregorianCalendar();
		java.util.Calendar cal2 = new java.util.GregorianCalendar();
		int intYearFrom = Integer.parseInt(currentDate.substring(6,10));
		int intMonFrom=Integer.parseInt(currentDate.substring(3,5));
		int intDdFrom=Integer.parseInt(currentDate.substring(0,2));
		cal1.set(intYearFrom, intMonFrom, intDdFrom);
		int intDdTo = Integer.parseInt(ForwardDate.substring(0,2 ));
		int intMonTo=Integer.parseInt(ForwardDate.substring(3,5));
		int intYearTo=Integer.parseInt(ForwardDate.substring(6,10));
		cal2.set(intYearTo, intMonTo, intDdTo);
		int daysBetween= daysBetween(cal1.getTime(),cal2.getTime());
		int days = daysBetween(cal1.getTime(),cal2.getTime());
	    return days;
	 }
	   
	public int daysBetween(Date d1, Date d2)
	   {
	      return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	   }
		
		
	}
