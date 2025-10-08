package com.mail;

import java.io.File;
import java.util.Scanner;

import com.mail.service.MailService;
import com.mail.service.impl.MailServiceImpl;


public class App {
	
    public static void main(String[] args) {
    	try (Scanner scanner = new Scanner(System.in)) {
    		System.out.print("Enter recipient email: ");
	        String recipientEmail = scanner.nextLine();
	        System.out.print("Enter subject: ");
	        String subject = scanner.nextLine();
	        System.out.print("Enter message body: ");
	        String body = scanner.nextLine();
	        System.out.print("Do you want to send an attachment? (yes/no): ");
	        String attachOption = scanner.nextLine().trim().toLowerCase();
	        MailService mailService = new MailServiceImpl();
	        String response;
	        if (attachOption.equals("yes")) {
	        	File attachment = new File(App.class.getClassLoader().getResource("images/sample.png").toURI());
	            response = mailService.sendAdvancedMail(recipientEmail, subject, body, attachment);
	        } else {
	            response = mailService.sendBasicMail(recipientEmail, subject, body);
	        }
	        System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
