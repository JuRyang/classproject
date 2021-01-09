package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain {

	public static void main(String[] args) {
		
		//1.Spring 컨테이너 생성(요청) ->설정파일이 필요하여 appCtx설정함.
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml"); //classpath:appCtx.xml(인스턴스를 만들어놓음) 로드
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx2.xml");
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx3.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx4.xml");
		
		//2.MemberRegService 객체가 필요
		MemberRegService regService = ctx.getBean("memberRegService", MemberRegService.class); //getBean을 이용해서 appCtx의 아이디 memberRegService 불러온다
				
		//3.MemberRegService -> process()실행 
		regService.process();
		
		//4.MemberInforService 객체
		MemberInfoService infoService = ctx.getBean("memberInfoService",MemberInfoService.class);
		
		//5.MemberInforService - >process()
		infoService.process();
	}

}
