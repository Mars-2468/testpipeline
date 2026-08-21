package com.mars.workflow.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAuthenticator extends Authenticator {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("jbpm.nmmc", "jbpm4@nmmc");
	}
}
