package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.dao.MemberDao;

public class MemberRegService2 implements MemberService {

	@Autowired(required = false) //타입 기반으로 등록해준다. 
	@Qualifier("guest")
	private Dao dao;

	@Override
	public Object process() {
		System.out.println("MemberRegService 실행");		
		dao.insert();
		return null;
	}

}
