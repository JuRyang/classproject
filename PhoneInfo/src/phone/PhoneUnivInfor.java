package phone;

public class PhoneUnivInfor extends PhoneInfo {
	
	private String major; // 전공
	private String year;  // 학년 

	//생성자 초기화
	 PhoneUnivInfor(String name, String pNum, String addr, String email, String major, String year){
		super(name, pNum, addr, email);
		this.major=major;
		this.year=year;
		
	}



	@Override
	public void showData() {
		super.showData();
		System.out.println("전공:"+major);
		System.out.println("학년:"+year);
		
	}

	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름: "+getName());
		System.out.println("전화번호:"+getPhonNumber());
		System.out.println("주소: "+getAddr());
		System.out.println("이메일:"+getEmail());
		System.out.println("전공:"+major);
		System.out.println("학년:"+year);
	}
	
	

}
