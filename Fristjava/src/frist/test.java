package frist;

public class test {

	public static void main(String[] args) {

		// int 형 변수 num1, num2, num3가 각각 10,20,30 으로 초기화 되어 있다.
		// 다음문장을 실행하면 각각 변수에는 어떠한 값이 저장되겠는가?
		// 확인 하는 코드를 작성하고, 그 결과에 대해 설명.
		/*
		 * int num1 =10; int num2 =20; int num3 =30;
		 * 
		 * num1=num2=num3; // <-------------이렇게 값이 대입됨
		 * 
		 * System.out.println(num1); System.out.println(num2); System.out.println(num3);
		 */

		// 수학식 {{(25x5)+(36-4)}-72}/5 의 계산결과를 출력하는 프로그램 작성.
/*
		int num1 = 25;
		int num2 = 5;
		int num3 = 36;
		int num4 = 4;
		int num5 =72;
		int num6 = 5;
		
		int result = (((num1*num2)+(num3-num4))-num5)/num6;
		
		System.out.println(result);
				*/

		// 3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성.
		// 단. 덧셈 연산의 횟수 최소화
		
		int num = 3;
		int i;
		int sum;
		for(i=3; i<13; i++) {
			if(i % 3 ==0) {
				sum = num + i;
				
				System.out.println(sum);
			}
				
		}
		
		
	
		
		
		

		// 문제4.
		// a= {{(25+5)+(36/4)}-72}*5, b= {{(25x5)+(36-4)}-71}/4, c=(128/4)*2 일 때
		// a>b>c 가 참이면 true 아니면 false를 출력하는 프로그램 작성
	/*	
		int a = (((25+5)+(36/4))-72)*5;
		int b = (((25*5)+(36-4))-71)/4;
		int c = (128/4)*2;
	
		
		
		if(a>b && a>c) {
			System.out.println(true);
			
		}else {
			System.out.println(false);
		}
		
			*/	
		
		

	}

}
