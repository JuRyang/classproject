package exam1;

public class PhoneInfor {
	
	/*

	* Version 0.1 전화번호 관리 프로그램.

	* PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의

	* 적절한 출력이 가능하도록 메소드 정의 ​

	* • 이름 name String • 전화번호 phoneNumber String • 생년월일 birthday String ​ 단, 생년월일

	* 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.

	*/

	String name; //이름
	String phoneNumber; //전화번호
	String Birthday; //생년월일


	//생성자 정의

	PhoneInfor(String name, String phoneNumber, String Birthday){

	this.name = name;

	this.phoneNumber = phoneNumber;

	this.Birthday= Birthday;

	}

	// 생년월일 값을 비워두기 위한 메소드 

	PhoneInfor(String name, String phoneNumber) {

	this.name = name;
	this.phoneNumber = phoneNumber;
	this.Birthday= null;
//​

	}
	//결과 출력
	
	void result() {

	System.out.println("이름:" + name);
	System.out.println("전화번호:" + phoneNumber);
	System.out.println("생년월일:" + Birthday);
	}



		public static void main(String[] args) {
			//인스턴스 선언

	PhoneInfor phone = new PhoneInfor("홍길동", "010-1234-5678");
	PhoneInfor phone1 = new PhoneInfor("아무개", "010-1234-9999", "2020.11.08");
	PhoneInfor phone2 = new PhoneInfor("나다","11-111-1111","2020.11.18");
	


	System.out.println("전화번호부");

	phone.result();
	phone1.result();
	phone2.result();


	}

	}
