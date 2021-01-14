package com.aia.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.domain.SearchParam;
import com.aia.op.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/list")  // /member/list?p=1 -> /member/list 디폴트페이지를 1 로 정해주자
	public String memberList(
			@RequestParam(value = "p", defaultValue="1") int page,
			SearchParam param, 
			Model model
			) {
		
		System.out.println(param);
		
//		MemberListView listView = listService.getListView(page);
//		System.out.println(listView);
		model.addAttribute("listView", listService.getListView(param));
		
		return "member/list";
	}
}
