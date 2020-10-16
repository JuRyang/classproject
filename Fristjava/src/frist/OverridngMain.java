package frist;

public class OverridngMain {

	public static void main(String[] args) {


	//	BaseEnSpeaker bs = new BaseEnSpeaker();
		
	//	bs.showCurrnetState();
		
	//	Speaker s = new Speaker();
		
		//s.showCurrnetState();
		
		
		//다형성
		//조상클래스 타입의 참조변수에 자손클래스타입의 인스턴스를 참조 할 수 있는 것.
		//참조변수는 해당 타입의 멤버만 사용하겠다 라고 선언.
		Speaker s = new BaseEnSpeaker();
		//참조변수s는 volumeRate 변수와 showCurrentState().setVolume()만 사용하겠다 
		
		//Speaker클래스가 가지는 멤버
		s.setVolume(5);
		
		//BaseEnSpeaker가 가지는 멤버
		// s.setBaseRate(20); 오류 speaker에 있는 기능만 사용가능
		
		//BaseEnSpeaker 오버라이딩한 메서드가 호출된다.
		s.showCurrnetState();
		
		
		
		
	}

}
