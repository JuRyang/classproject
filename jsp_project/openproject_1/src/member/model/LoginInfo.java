package member.model;

public class LoginInfo {
	

	//beans처럼 만들어(로그인정보에pw저장하지않음)
	private String memberId;
	private String memberName;
	private String memberPhoto;
	
	//생성자
	public LoginInfo(String memberId, String memberName,String memberPhoto) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhoto= memberPhoto;
	}

	//set는 정보를 바꾸면 안되니까 정의하지않는다.
	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}

	//디버기용
	@Override
	public String toString() {
		return "LoginInfo [memberId=" + memberId + ", memberName=" + memberName + ", memberPhoto=" + memberPhoto + "]";
	}
	
	
	

}
