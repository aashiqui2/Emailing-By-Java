package com.mail.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.dto.MailDTO;
import com.mail.service.MailService;


@RequestMapping("/mail")
@RestController
public class MailController {
	
	private final MailService mailService;
	
	public MailController(MailService mailService) {
		this.mailService = mailService;
	}

	@PostMapping("/sendBasic")
	public ResponseEntity<String> sendSimpleMail(@RequestBody MailDTO mailDTO) {
		String response = mailService.sendBasicMail(mailDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/sendAdvanced")
	public ResponseEntity<String> sendAdvancedMail(@RequestBody MailDTO mailDTO) {
		Resource attachment = new ClassPathResource("images/sample.png");
		String response = mailService.sendAdvancedMail(mailDTO, attachment);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
