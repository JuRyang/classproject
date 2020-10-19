package phone;

public class PhoneInfo {
	
	private String name;       //친구이름
	private String phonNumber; //전화번호
	private String addr;       //주소
	private String email;      //이메일
	
	//생성자를 통해서 인스턴스 변수들 초기화
	PhoneInfo(String name, String pNum, String addr,String email) {
		this.name=name;
		this.phonNumber=pNum;
		this.addr=addr;
		this.email=email;
	}
	
	
	
	//private타입이기때문에  get 메서드 생성
	
	public String getName() {
		return name;
	}

	public String getPhonNumber() {
		return phonNumber;
	}

	public String getAddr() {
		return addr;
	}

	public String getEmail() {
		return email;
	}

	


	//오버라이딩: 상속하는 클래스의 추가 속성을 출력
	public void showData() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phonNumber);
		System.out.println("주소:"+addr);
		System.out.println("이메일:"+email);
		
	}
	
	


	//오버라이딩 : 비어있는 처리부를 기능을 추가
	public void showBasicInfo() {
		
	}
	
	

}
