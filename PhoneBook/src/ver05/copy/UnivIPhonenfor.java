package ver05.copy;

public class UnivIPhonenfor extends PhoneInfor {

	// 대학친구 : 전공, 학년
	private String major; //전공
	private int grade;    //학년
	
	//생성자: 상위클래스의 생성자 호출, 추가된 변수의 초기화 
	public UnivIPhonenfor(String name, String phoneNum, String addr, String email, String major, int grade) {
		//상위 클래스의 생성자 호출 : 상위클래스의 멤버변수 초기화
		super(name, phoneNum, addr, email);
		//새로 추가된 멤버 변수 초기화
		this.major=major;
		this.grade=grade;
		
	}

	//추가된 변수 get,set
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("전공:"+major);
		System.out.println("학년:"+grade);
	}

	

	@Override
	public void showBasicInfor() {
		super.showInfo();
		
	}


	
	

}
