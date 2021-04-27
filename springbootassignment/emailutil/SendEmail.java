package com.utils.email;

import java.util.ArrayList;
import java.util.Properties;

//Java program to send email 
//with HTML templates 

import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*; 
import javax.mail.internet.*;


public class SendEmail 
{ 
	public static void send(String recipiat,String fileloc) throws Exception{	 
		System.out.println("Preparing to send ");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
				
		String gmailAcc = "vipinramar978@gmail.com";
		String password = "vipinasc";
		String recipient = recipiat;
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmailAcc, password);
			}
		});
		
		Message msg = prepareMessage(session,gmailAcc,recipient,fileloc);
		
		Transport.send(msg);
		System.out.println("Sent succesfully");
	}
	
	private static Message prepareMessage(Session session,String gmailAcc,String recipient,String fileLoc) {
		 try {
			 Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(gmailAcc));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			message.setSubject("Regarding ur invoice details...");
			String filename = fileLoc;    
            DataSource source = new FileDataSource(filename);    
            message.setDataHandler(new DataHandler(source));    
            message.setFileName(filename); 
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}
} 



