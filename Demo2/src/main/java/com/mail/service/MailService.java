package com.mail.service;

import java.io.File;


public interface MailService {
	
	String sendBasicMail(String recipientMail, String subject, String body);
	
	String sendAdvancedMail(String recipientMail, String subject, String body, File attachment);

}
