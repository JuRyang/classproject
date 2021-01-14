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
import com.aia.op.member.domain.SearchParam;



@Service
public class MemberListService {
	
	private MemberDao dao; 
	
	@Autowired
	private SqlSessionTemplate template; //인터페이스MemberDao get매퍼로 이용하여 코드 간단하게 한다
	
	//뷰 반환(몇번째 페이지번호인지 중요! )
	public MemberListView getListView(SearchParam param) {
		
		MemberListView listView = null; // 변수 만들어서 초기화
		
		try {
		// MemberDao 구현체 생성
			dao = template.getMapper(MemberDao.class);
			System.out.println("pageNumber : " + param.getP());

		int cntPerPage = 5;

		int startRow = (param.getP() - 1) * cntPerPage;
		int endRow = startRow + cntPerPage - 1;

		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("index", startRow);
		listMap.put("count", cntPerPage);
		listMap.put("searchParam", param);

		// int totalMemberCount = dao.selectTotalCount();
		int totalMemberCount = dao.selectSearchMemberCount(listMap);
		System.out.println("memberTotalCount : " + totalMemberCount);

		List<Member> memberList = dao.selectMemberList(listMap);
		System.out.println(memberList);

		listView = new MemberListView(param.getP(), totalMemberCount, cntPerPage, memberList, startRow, endRow);

	} catch (Exception e) {
		e.printStackTrace();
	}

	return listView;
}

}
