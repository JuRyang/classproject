package friend;

public class UniverFriend extends Friend{

	private String major;     //친구의 전공
	
	//생성자를 이용해서 초기화
	public UniverFriend(String name, String pNum, String addr, String major) {
		super(name, pNum, addr);
		this.major = major;
	}
	
	//오버라이딩
	
	public void showData() {
		super.showData();
		System.out.println("전공:"+major);
	}
	
	//오버라이딩
	public void showBasicInfo() {
		System.out.println("이름:"+getName());
		System.out.println("전화번호:"+getphoneNumber());
		System.out.println("전공:"+major);
	}

	

	
}
