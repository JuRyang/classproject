package frist;

public class Usevariable {

	public static void main(String[] args) {
		// 1.정수형 타입의 변수  num1변수를 선언하자
		int num1;
		
		//2.변수 num1에 숫자 데이터 10을 저장하자.
		num1 = 10;
		
		//3.정수형 타입의 변수 num2변수를 선언하고.숫자 20을 대입하자
		int num2 = 20;
		
		//4.정수형 타입의 변수 num3을 선언하고
		//변수 num1과 num2을 합하는 연산한 결과를
		//변수 num3에 대입한다.
		int num3 = num1 +num2;

		//5.연산의 결과를 출력하자.
		System.out.println(num3);
		
		float n1 = 1.000001f;
		double n2 = 1.000001;
		
		System.out.println((double)n1);
		System.out.println(n1+n2);

		char ch1='A';
		System.out.println(ch1);
		System.out.println((int)ch1);
		
		//boolean : true / false
		/*
	    boolean check = true;
	    
	    if(check) {
	    	System.out.println(true);
	    	
	    }
	    int i =0;
		while(check) {
			if( i < 5) {
				break;
			}
			i++; // 탈출의 연산식 이게 없으면 무한루프
		}
		*/
		
		//상수 생성
		final double PI = 3.141592;
		
		// PI = 3.14;
		
		// int num5 = 10000000000; 범위 초과
		// int num5 = 10000000000L; //int인데 long 값으로 처리 못함
		   long num5 = 10000000000L;
		   
		   char ch3 ='A';
		   
		   int chNumber = ch3;
		   
		   System.out.println("A의 유니코드 값=>"+chNumber);
		   
		   chNumber += 1; // chNumber = chNumber + 1
		   System.out.println(chNumber);
		   
		   System.out.println((char)chNumber);
		   
		   int age = 200;
		   
		   System.out.println((byte)age);
		   
		
		
	}

}
