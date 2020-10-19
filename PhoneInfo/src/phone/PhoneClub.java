package phone;

public class PhoneClub extends PhoneInfo {
	
	private String club; // 동호회 이름 

	public PhoneClub(String name, String pNum, String addr, String email, String club) {
		super(name, pNum, addr, email);
		this.club=club;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("동호회 이름:"+club);
	}

	@Override
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름:"+getName());
		System.out.println("전화번호:"+getPhonNumber());
		System.out.println("주소:"+getAddr());
		System.out.println("동호회이름:"+club);
	
	}

	
	
	
	
}
