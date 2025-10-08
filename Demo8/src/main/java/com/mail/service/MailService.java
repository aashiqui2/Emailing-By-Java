package com.mail.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.mail.dto.MailDTO;


public interface MailService {
	
	String sendBasicMail(MailDTO mailDTO);

	String sendAdvancedMail(MailDTO mailDTO, Resource attachment);

	String sendAdvancedMail(MailDTO mailDTO, List<MultipartFile> attachments);

}
