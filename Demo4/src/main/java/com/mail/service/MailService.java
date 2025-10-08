package com.mail.service;

import com.mail.dto.MailDTO;


public interface MailService {
	
	String sendBasicMail(MailDTO mailDTO);

}
