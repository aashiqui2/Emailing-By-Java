package com.mail.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.core.io.Resource;

import com.mail.dto.AttachmentDTO;
import com.mail.dto.MailDTO;


public interface AsyncMailService {
	
	CompletableFuture<String> sendEmail(MailDTO mailDTO);

	CompletableFuture<String> sendEmailWithAttachment(MailDTO mailDTO, Resource attachment);

	CompletableFuture<String> sendEmailWithAttachment(MailDTO mailDTO, List<AttachmentDTO> attachments);

}
