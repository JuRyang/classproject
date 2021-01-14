package com.aia.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDeleteService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	int deleteMember(int idx) {
		
		//회원정보 삭제
		return dao.deleteMemberByIdx(int idx);
		
	}
}
