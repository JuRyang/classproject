package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService;
import member.service.MemberInfoService2;
import member.service.MemberRegService;
import member.service.MemberRegService2;

public class MemberMain3 {

	public static void main(String[] args) {
		
		//1.Spring 컨테이너 생성(요청) ->설정파일이 필요하여 appCtx설정함.
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx6.xml");
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx7.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx8.xml");
		
		//2.MemberRegService 객체가 필요
		MemberRegService2 regService = ctx.getBean("memberRegService", MemberRegService2.class); //getBean을 이용해서 appCtx의 아이디 memberRegService 불러온다
				
		//3.MemberRegService -> process()실행 
		regService.process();
		
		//4.MemberInforService 객체
		MemberInfoService2 infoService = ctx.getBean("memberInfoService",MemberInfoService2.class);
		
		//5.MemberInforService - >process()
		infoService.process();
	}

}
