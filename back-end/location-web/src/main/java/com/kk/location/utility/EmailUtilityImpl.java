package com.kk.location.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilityImpl implements EmailUtility {

	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(message);
		try {
			mimeHelper.setTo(toAddress);
			mimeHelper.setSubject(subject);
			mimeHelper.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(message);
	}

}
