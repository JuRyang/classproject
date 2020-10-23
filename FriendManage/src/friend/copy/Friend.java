package friend.copy;

public  class Friend {
	
	private String name;              //친구이름
	private String phoneNumber;       //전화번호  
	private String addr;              //주소
	
	//생성자를 통해서 인스턴스 변수들을 초기화
	Friend (String name, String pNum, String addr){
		this.name=name;
		this.phoneNumber=pNum;
		this.addr=addr;
	}
	
	// private이기 때문에 HighFriend에서 못불러옴 그래서 get메서드 생성
	public String getName() {
		return name;
	}
	
	public String getphoneNumber() {
		return phoneNumber;
	}
	
	public String getAddr() {
		return addr;
	}
	
	
	
	
	
	//오버라이딩 처리: 상속하는 클래스의 추가 속성을 출력
	public void showData() {
		System.out.println("이름: "+name);
		System.out.println("전화번호:" +phoneNumber);
		System.out.println("주소: "+addr);
	}
	
	//오버라이딩 : 비어있는 처리부를 기능을 추가
	public void showBasicInfo() {
		
	}
	
/*	public abstract void showBaseicInfp();*/
	
	
	
	

}
