package com.mail.service;


public interface MailService {
	
	String sendBasicMail(String recipientMail, String subject, String body);

}
