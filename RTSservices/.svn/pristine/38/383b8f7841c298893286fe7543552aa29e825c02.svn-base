package com.mars.mail.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MailService {
	
	/**
	 * <p>
	 * 		This method used to send e-mail for an user.
	 * 		Pass mail subject, to, mailTemplateName, etc..,
	 * 		inside <b> Map &lt;String,Object&gt;</b> as a Parameter 		
	 * </p>
	 * <br />
	 * <p>
	 * 		Refer docs,
	 *	<br />	http://javamail.kenai.com/nonav/javadocs/
	 * 	<br />	http://static.springsource.org/spring/docs/2.0.x/reference/mail.html
	 * </p>
	 * @param request 
	 *	@param mailMap
	 */
	
	void sendMail(Map<String,Object> map);
	
	public void sendEmailNotifiactations();
}
