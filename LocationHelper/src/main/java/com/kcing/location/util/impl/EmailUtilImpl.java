package com.kcing.location.util.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.kcing.location.util.EmailUtil;

@Component
public class EmailUtilImpl implements EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String subject, String to, String messageBody) {
		// TODO Auto-generated method stub
			MimeMessage message =javaMailSender.createMimeMessage();
			MimeMessageHelper hp = new MimeMessageHelper(message);
			try {
				hp.setTo(to);
				hp.setSubject(subject);
				hp.setText(messageBody);
				javaMailSender.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
