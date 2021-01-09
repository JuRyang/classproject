package com.aia.firstspring.member.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //이걸 해줘야 핸들러매핑에 등록 됨
public class HelloController {

	//메소드는 프론트컨트롤로 ViewName을 반환 해야 한다. 반환타입을 ModelAndView를 이용해서 반환하자
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/hello");  //  /WEB-INF/view/member/hello.jsp ->member/hello 
		mav.addObject("greeting",greeting());
		
		return mav;
	}

	private String greeting() {
		
		String result = "안녕하세요.";
		
		int nowtime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(nowtime>=6 && nowtime<=10) {
			result="좋은 아침입니다.";
		}else if(nowtime>=12 && nowtime<=15) {
			result="점심 식사는 하셨나요?";
		}else if(nowtime>=18 && nowtime<=22) {
			result="좋은 밤 되세요";
		}
		
		
		
		return result;
	}
}
