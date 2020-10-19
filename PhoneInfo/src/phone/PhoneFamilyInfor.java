package phone;

public class PhoneFamilyInfor extends PhoneInfo {

	
	private String relation;
	PhoneFamilyInfor(String name, String pNum, String addr, String email, String relation) {
		super(name, pNum, addr, email);
		this.relation=relation;
		
	}
	@Override
	public void showData() {
		super.showData();
		System.out.println("가족관계:"+relation);
	}
	@Override
	public void showBasicInfo() {
	
		super.showBasicInfo();
		System.out.println("이름:"+getName());
		System.out.println("전화번호:"+getPhonNumber());
		System.out.println("주소:"+getAddr());
		System.out.println("가족관계:"+relation);
		
	}
	
	

}
