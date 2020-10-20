package ver04;

public class CafePhoneInfor extends PhoneInfor {

	// 동호회 이름, 닉네임
	private String cafeName;
	private String nickName;
	
	//생성자
	public CafePhoneInfor(String name, String phoneNum, String addr, String email, String cageName, String nickName) {
		//상위클래스
		super(name, phoneNum, addr, email);
		this.cafeName=cafeName;
		this.nickName=nickName;
		
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("동호회 이름:"+cafeName);
		System.out.println("닉네임:"+nickName);
	}
	
	

	
}
