package com.mail.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.dto.MailDTO;
import com.mail.service.MailService;


@Service
public class MailServiceImpl implements MailService {

	@Value("${spring.mail.username}")
	private String senderEmail;
	
	@Value("${success.message}")
	private String successMessage;

	private final JavaMailSender mailSender; //due to constructor injection don't need @Autowired
	
	public MailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public String sendBasicMail(MailDTO mailDTO) {
		return sendEmail(mailDTO);
	}

	private String sendEmail(MailDTO mailDTO) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(senderEmail);
			message.setTo(mailDTO.to());
			message.setSubject(mailDTO.subject());
			message.setText(mailDTO.body());
			mailSender.send(message);
			return successMessage;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
