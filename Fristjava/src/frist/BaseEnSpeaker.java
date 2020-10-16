package frist;

public class BaseEnSpeaker extends Speaker {
	
	private int baseRate;
	
	public void setBaseRate(int base) {
		baseRate = base;
	}
	
	//오버라이딩: 
	//상속관계에서 상속받은 메서드를 선언부는 동일하게 하고 처리부를 재구성하는 것
	@Override // 어노테이션: 자바의 키워드는 아님.주석도 아님 추가적인 의미를 부여한다
	void showCurrnetState() {
		//System.out.println("메소드의 처리부분을 변경했습니다.");
		super.showCurrnetState(); // super.상위클래스를 선언 하지않으면  상위클래스에 있는 기능을 사용못한다.
		System.out.println("베이스 크기:"+baseRate);
	}

}
