package ver05.copy;

public  abstract class PhoneInfor implements Infor{ //extend object(기본)
	
	//친구의 이름, 전화번호, 주소, 이메일
	//캡슐화:정보은닉(변수의 직접 접근을 제한- 변수를 보호)
	private String name;   //이름
	private String phoneNum; //전화번호
	private String addr; //주소
	private String email; //이메일
	
	//컨트롤  알트 s- 구조필드
	public PhoneInfor(String name, String phoneNum, String addr, String email) {
		//super(); //object클래스 생성자 호출, 생략 가능
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.email = email;
	}

	//getter, setter
	
	public String getName() {  //get뒤에 대문자로 시작
		return name;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//정보 출력 기능
	//하위클래스에서 오버라이딩 하는 목적
	@Override
	public void showInfo() {
		System.out.println("이     름:"+name);
		System.out.println("전화번호:"+phoneNum);
		System.out.println("주      소:"+addr);
		System.out.println("이 메 일 :"+email);
	}
	
	//추상메서드 showBasicInfor() 멤버로 가진다.

	

}
