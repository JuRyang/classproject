package frist;

public class AgeInputException extends Exception {

	
	private int age;
	
	//Exception클래스에 있는 상위클래스 
	public AgeInputException(int age) {
		super("유효하지 않은 나이가 입력되었습니다."); //바꿀 수 있는 이유는 메시지를 받을 수 있는 클래스여서..?
		this.age=age;
		
	}

	@Override
	public String toString() {
		return "AgeInputException [age=" + age + ", getMessage()=" + getMessage() + "]";
	}

	
}
