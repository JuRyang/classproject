package ver02;

import java.util.Scanner;
import ver03.*;

//import ver01.PhoneInfor;
//import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		
		//사용자에게 데이터를 받는다.
		Scanner s =new Scanner(System.in);
		
	//	Util.sc.nextLine(); //ver03에 있는 util 스캐너 불러옴,  import ver03.Util;
		//new PhoneBookManager(); //ver03에 있는 생성자 불러옴, 불러올때  import ver03.*; 이렇게 해야 오류 안남(ver03에 있는 폴더를 사용하곘다)
		
		while(true) {
			//인스턴스 생성을 위해서는 이름, 전화번호, 생일 데이터를 받는다.
			System.out.println("저장을 위한 데이터를 입력해주세요.");
			System.out.println("이름을 입력해주세요");
			String name = s.nextLine();  //nextLine 문자열을 받아오는 명령어
			
			System.out.println("전화번호를 입력해주세요");
			String phoneNumber = s.nextLine();
			
			System.out.println("생일을 입력해주세요.");
			String birthday = s.nextLine();  // ""
			
			//인스턴스 생성
			
			 PhoneInfor infor = null;
			 
			 //trim() -> "      12  3         "        .trim() -> "123"
			 
			 //입력값 없이 enter인 경우 공백 문자열을 반환.
			 //문자열의 길이가 0이면
			 //if(birthday.length()==0) { //"    "  .trim() ->"" (공백을 지워준다)
			 if(birthday.trim().isEmpty()) {  //length() ==0 => true
				infor =  new PhoneInfor(name,phoneNumber,null); 
			 }else {
				 infor = new PhoneInfor(name,phoneNumber,birthday);
			 }
				 
			 new PhoneInfor(name,phoneNumber,birthday); 
			 
			 new PhoneInfor(name,phoneNumber,null); 
			 
			//메서드 호출
			 infor.showInfor();

		}
		
		
	}

}
