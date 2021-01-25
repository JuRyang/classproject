package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.service.MailSenderService;

@Controller
@RequestMapping("/mail")	
public class MailSenderController {
	
	@Autowired
	MailSenderService mailsenderService; 
	
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	@Autowired
//	private SimpleMailMessage temlpateMessage;

	@RequestMapping("/simplemail")  //  /mail.simplemail.jsp
	public void simpleMailSend() {
		
		mailsenderService.simpleMailSend();
		
		
	} // mail/simplemail
}
