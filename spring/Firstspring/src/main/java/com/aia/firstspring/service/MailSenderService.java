package com.aia.firstspring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean simpleMailSend() {
		
		boolean result = true;
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		//SimpleMailMessage message = new SimpleMailMessage(temlpateMessage);
		message.setTo("wnfid3374@naver.com");
		message.setSubject("테스트이메일발송");
		message.setText("내용입니다.");

		try {
			mailSender.send(message);
		} catch (Exception e) {
			result = false;
		}
		
		return result;
		
	}

	/*
	  param@ toEmailAddress : 보내는 사람의 이메일
	  param@ name : 받는 사람의 이메일
	  param@ subject : 메일의 제목
	  param@ text : 메일 내용
	*/
	public boolean mailSend(String toEmailAddress,String Subject, String text, String html) {
		
		boolean result = true;
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			// 메일제목
			message.setSubject(Subject, "utf-8"); 
			// 메일 내용
			//String htmlStr = "<h1 style=\"colo:red;\">회원가입을 축하합니다.</h1>";
			message.setText(text, "utf-8", "html"); 
			//보내는 사람의 이메일의 gmail인 경우에는 인증된 메일로 적용이 된다.
			message.setFrom(new InternetAddress("wnfid3374@naver.com")); 
			
				//받는 사람의 이메일 주소
				message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress+"님 ", "웰컴웰컴", "utf-8"));
	
				//메일 전송
		}catch (UnsupportedEncodingException e) {
				result= false;
				e.printStackTrace();
			
		} catch (MessagingException e) {
			result= false;
			e.printStackTrace();
		}
		
		return result;
	}
}
