package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain2 {

	public static void main(String[] args) {
		
		//1.Spring 컨테이너 생성(요청) ->설정파일이 필요하여 appCtx설정함.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
		
		Dao dao1 = ctx.getBean("memberDao",Dao.class);
		Dao dao2 = ctx.getBean("memberDao",Dao.class);
		
		System.out.println("dao1 == dao2 =>"+(dao1 == dao2)); //true
		
		
		//2.MemberRegService 객체가 필요
		MemberRegService regService1 = ctx.getBean("memberRegService", MemberRegService.class); //getBean을 이용해서 appCtx의 아이디 memberRegService 불러온다
		MemberRegService regService2 = ctx.getBean("memberRegService", MemberRegService.class);
		
		System.out.println("regService1 == regService2=> "+(regService1 == regService2)); //false
		
		//4.MemberInforService 객체
		MemberInfoService infoService1 = ctx.getBean("memberInfoService=> ",MemberInfoService.class);
		MemberInfoService infoService2 = ctx.getBean("memberInfoService=> ",MemberInfoService.class);
		
		System.out.println("infoService1 == infoService2=> "+(infoService1 ==infoService2)); //true
		
		
	}

}
