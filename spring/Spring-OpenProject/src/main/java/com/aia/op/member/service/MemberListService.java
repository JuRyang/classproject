package com.aia.op.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.domain.Member;
import com.aia.op.member.domain.MemberListView;

@Service
public class MemberListService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public MemberListView getListView(int pageNumber) {
		
		MemberListView listView = null;
		
		try {
		// MemberDao 구현체 생성
		dao = template.getMapper(MemberDao.class);
		
		System.out.println("pageNumber : " + pageNumber);
		
		
		int cntPerPage = 5;
		
		int startRow = (pageNumber-1)*cntPerPage;
		int endRow = startRow+cntPerPage-1;
		
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("startRow", startRow);
		listMap.put("cntPerPage",cntPerPage);
		listMap.put("searchParam", param);
		
		int totalMemberCount = dao.selectTotalCount(listMap);
		System.out.println("memberTotalCount : " + totalMemberCount);
		
		
		List<Member> memberList = dao.selectMemberList(startRow, cntPerPage);
		System.out.println(memberList);
		
		listView = new MemberListView(pageNumber, totalMemberCount, cntPerPage, memberList, startRow, endRow);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listView;
	}

}
