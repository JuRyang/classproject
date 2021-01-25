package com.aia.firstspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.firstspring.domain.MemberRegRequest;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.member.service.MemberListService;
import com.aia.firstspring.member.service.MemberRegService;
import com.aia.firstspring.member.service.MemberRestService;

@RestController
@RequestMapping("/rest/ver1/members")
public class RestApiController {
	
	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberRegService regService;

	//문자열 반환 
	
//	@GetMapping("/{idx}") // GET /rest/ver1/members/39
//	//@GetMapping
//	public String getRest(
//			@PathVariable("idx") int idx
//			) {    
//		return"@RestController 사용한 응답 처리:"+ idx ;
//	}
	
	@GetMapping   //   /rest/ver1/members  경로
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}
	
	@GetMapping("/map")   //   /rest/ver1/members  경로 실제rest는 이렇게 안함
	public Map<Integer, Member> getMemberListMap(){ //Map은 기본데이터가 아님 집합 덩어리로 저장하기 때문(X int)
		
		Map<Integer, Member> memberMap = new HashMap<Integer, Member>();
		
		// 배열 콜렉션(요소의 개수만큼 반복, 선택적?)
		for (Member member : listService.getMemberList()) {
			memberMap.put(member.getIdx(), member);
		}
		
		return memberMap; //원본
	}
	
	
	@GetMapping("/{idx}") //home페이지에 따로 경로 설정 안해도 됨 겟매핑 했기때문
	public Member getMemberInfo(
			  @PathVariable("idx") int idx
			){
		return restService.getMember(idx);
		
	}
	
	//@RequestMapping(method = RequestMethid.POST)
	@PostMapping 
	public String insertMember(
			@RequestBody MemberRegRequest regRequest
		
		){
			
		//String result = "N";
		
		System.out.println(regRequest);
		System.out.println(regRequest.getToMember());
		
		// regService.insertMember(regRequest.getToMember());
		
		return regService.insertMember(regRequest.getToMember())>0 ? "Y" : "N";
	}
	
	
	
	
}
