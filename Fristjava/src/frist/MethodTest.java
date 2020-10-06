package frist;

public class MethodTest {

	public static void main(String[] args) {

		MyMeth my = new MyMeth(); // 인스턴스 생성

		System.out.println(my.add(1, 5)); // n1 =1 n2=5); // n1 =1 n2=5

		my.sayHello();

		my.plus(10, 20);
		
		System.out.println(my.check());
		
		hiEveryone();
		
		my.div(10, 2);
		my.div(10, 0);

	}
	
	static void hiEveryone() {
		System.out.println("안녕하세요");
	}
	
	
	

}
