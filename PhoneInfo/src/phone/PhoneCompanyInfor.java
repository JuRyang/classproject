package phone;

public class PhoneCompanyInfor extends PhoneInfo {
	
	
	private String company; //회사명 
	
	//생성자 
	PhoneCompanyInfor(String name, String pNum, String addr, String email, String company) {
		super(name, pNum, addr, email);
		this.company=company;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("회사:" +company);
	}
	

	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름: "+getName());
		System.out.println("전화번호:"+getPhonNumber());
		System.out.println("주소: "+getAddr());
		System.out.println("이메일:"+getEmail());
		System.out.println("회사:"+company);
		
		
	}
	
	
	

		
	}


