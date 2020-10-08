package exam1;

import java.util.Scanner;

public class MethodTest {
	
	//문제1

//두 개의 정수를 전달받아서, 두수의 사칙연산 결과를 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해보자.
//단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
	

	
	
	void plus(int num1, int num2) {
		int result=num1 +num2;
		
		System.out.println(result);
		
	}
	
	void minus(int num1, int num2) {
		int result=num1 - num2;
		
		System.out.println(result);
		
	}
	
	void ggub (int num1, int num2) {
		int result=num1 * num2;
		
		System.out.println(result);
		
	}
	void nanu (int num1, int num2) {
		int result=num1 / num2;
		
		System.out.println(result);
		
	}
	void namae (int num1, int num2) {
		int result=num1 % num2;
		
		System.out.println(result);
		
	}
	
	

}
