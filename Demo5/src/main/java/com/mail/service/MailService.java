package com.mail.service;

import org.springframework.core.io.Resource;

import com.mail.dto.MailDTO;


public interface MailService {
	
	String sendBasicMail(MailDTO mailDTO);

	String sendAdvancedMail(MailDTO mailDTO, Resource attachment);

}
