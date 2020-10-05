package com.kk.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {

	@Value("${com.kk.flightreservation.itinerary.email.body}")
	private String EMAIL_BODY;

	@Value("${com.kk.flightreservation.itinerary.email.subject}")
	private String EMAIL_SUBJECT;

	@Autowired
	private JavaMailSender sender;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtility.class);

	public void sendEmailItinerary(String toAddress, String filePath) {
		LOGGER.info("Inside sendEmailItinerary");
		MimeMessage message = sender.createMimeMessage();
		try {

			MimeMessageHelper mimeHelper = new MimeMessageHelper(message, true);
			mimeHelper.setTo(toAddress);
			mimeHelper.setSubject(EMAIL_SUBJECT);
			mimeHelper.setText(EMAIL_BODY);
			mimeHelper.addAttachment("Itinerary", new File(filePath));

			sender.send(message);

		} catch (MessagingException e) {
			LOGGER.error("Exception inside Itinerary" + e);
			e.printStackTrace();
		}
	}

}
