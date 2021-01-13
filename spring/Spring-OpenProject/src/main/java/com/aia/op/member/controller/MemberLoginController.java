package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login") //뷰의 요청 경로
public class MemberLoginController {
	
	@Autowired
	private MemberLoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET) //뷰의 요청 경로 지정
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model //출력
			) {
		//Model 객체를 이용해서, view로 Data전달
		model.addAttribute("loginCheck", loginService.login(request, response)); 
		
		
		return "member/loginView"; //뷰 파일 리턴
	}
	
	
	
	
	
	
	
	
	
	
	

}