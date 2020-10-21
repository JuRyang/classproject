package frist;

public class ExceptionThrow {

	public static void main(String[] args) {
		
		try {
			
			//프로그래머가 강제로 예외를 발생시킨다.
			//1. 예외클래스의 인스턴스 생성
			Exception e = new Exception("강제로 발행한 예외!");
			//2. 예외 발생 : throw 예외타입의 인스턴스 참조값
			throw e;
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();  //예외발생 순서
		}
		System.out.println("프로그램 종료");

	}

}
