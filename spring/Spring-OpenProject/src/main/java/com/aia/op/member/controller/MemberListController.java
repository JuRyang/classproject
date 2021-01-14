package com.aia.op.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberListController {

	@RequestMapping("/member/list")
	public String memberList() {
		
		return "member/list";
	}
}
