package frist;

public class ExamOper2 { // oprator은 내가 풀이한거 비교해보기

	public static void main(String[] args) {

		System.out.println("연산자 추가 문제풀이1----------------");
		// 문제 1
		int x = 2;

		int y = 5;

		char c = 'A'; // 'A'의문자코드는 65

		System.out.println(y += 10 - x++); // y=y+(10-x++) 5+(10-2) = 13
		System.out.println(x += 2);
		System.out.println(!('A' <= c && c <= 'Z')); // 65<= 65 && 65<=93
		System.out.println('C' - c); // 67-65=2
		System.out.println('5' - '0');
		System.out.println(c + 1); // char + int =int +int = 65+1=66
		System.out.println(++c); // 증가 후 출력 ->B
		System.out.println(c++); // 출력 후 증가 -> B
		System.out.println(c); // c

		System.out.println("문제풀이2----------------");

		// [2] 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다.
		// 만일 사과의수가 123개이고 하나의 바구니에는10개의 사과를 담을 수 있다면,13개의 바구니가 필요할 것이다.
		// (1)에 알맞은 코드를 넣으시오.

		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10;

		// 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
	/*	// 1. 전체 사과를 10으로 나눈 몫이 바구니 개수
		// 2.전체 사과를 0으로 나눈 나머지가 0 보다 크면 바구니 +1
		int numOfBucket = numOfApples / 10;
		if (numOfApples % 10 > 0) {
			numOfBucket++;
		} */
		
		//삼항연산자로 바꿔보자
		int numOfBucket = numOfApples/10 + (numOfApples%10 > 0 ? 1 : 0 );
		

		// 모든 사과를담는데 필요한 바구니의 수
		System.out.println("필요한바구니의 수 :" + numOfBucket);
		
		System.out.println("문제풀이3----------------");
		
		// 문제 3 아래는 변수num의 값에 따라 ‘양수’,‘음수’,‘0’을 출력하는 코드이다.
		//삼항 연산자를 이용해서(1)에 알맞은 코드를 넣으시오.
		
		int num = 10;
		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : "0"));
		
		System.out.println("문제풀이4----------------");
		// 문제4 아래는 변수num1의 값 중에서 백의 자리 이하를 버리는 코드이다.
		// 만일 변수 num1 의 값이‘456’이라면 ‘400’이 되고,‘111’이라면 ‘100’이 된다.(1)에 알맞은 코드를 넣으시오.		​

		int num1 = 456;
		System.out.println(num1 / 100*100);
		
		System.out.println("문제풀이5----------------");
		// 문제5
		// 아래는 변수num2의 값 중에서 일의 자리를1로 바꾸는 코드이다.
		//만일 변수 num2의값이 333이라면 331이 되고,777이라면 771이 된다.
		// (1)에 알맞은 코드를 넣으시오.
	
		int num2 =777;
		System.out.println(num2/10*10+1);
		
		System.out.println("문제풀이6----------------");
		// 문제6
		// 아래는 변수num의 값보다 크면서도 가장 가까운10의 배수에서 변수num의 값을뺀 나머지를 구하는 코드이다.
		// 예를 들어, 24의 크면서도 가장 가까운10의 배수는 30이다.19의 경우 20이고,81의 경우 90이 된다.
		// 30에서 24를 뺀 나머지는6이기 때문에 변수num의 값이 24라면6을결과로 얻어야 한다
		
		//30-24 =>6  10-4->6
		//20-19=>1   10-9->1
		//90-81=>9   10-1->9    => 공통부분 10 에서 1의 자리 빼  -> 십으로 나누고 나버지를 10으로 빼자
		
		num = 81;

		System.out.println(10 -num%10 );
		
		System.out.println("문제풀이7----------------");
		//[7] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
		//변환공식이 'C =5/9 ×(F - 32)'라고 할 때,(1)에 알맞은 코드를 넣으시오.
		//단, 변환 결과값은 소수점셋째 자리에서 반올림해야 한다.(Math.round()를 사용하지 않고 처리할 것)
		
		int fahrenheit =100;
		float celcius = (int)( 5/9f *(fahrenheit - 32)*100+0.5 )/100f ;
		
		System.out.println("Fahrenheit:"+fahrenheit);

		System.out.println("Celcius:"+celcius);
		
		System.out.println("문제풀이8----------------");
		
		byte a = 10;
		byte b = 20;
		byte cc = (byte)(a + b);
		System.out.println("cc="+cc);

		char ch = 'A';
		ch = (char)(ch + 2);
		System.out.println("ch="+ch);

		float f = 3 / 2f;
		System.out.println("f="+f);
		
		long l = 3000L * 3000 * 3000;
		System.out.println("l="+l);

		float f2 = 0.1f;
		double d = 0.1;

		boolean result = (float)d==f2;
		System.out.println("result="+result);
		
		System.out.println("문제풀이9----------------");
		
		// 다음은 문자형 변수ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수b의 값이true가 되도록 하는 코드이다.
		//(1)에 알맞은 코드를 넣으시오
		
		char ch1 = '0';
		boolean b1 = ch1>= 'a' && ch1<='z'|| 
				     ch1>= 'A' && ch1<='Z'|| 
				     ch1>= '0' && ch1<='9';

		System.out.println(b1);
		
		System.out.println("문제풀이10----------------");
		
		//[10] 다음은 대문자를 소문자로 변경하는 코드인데,문자 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경한다.
		//문자코드는 소문자가 대문자보다32만큼 더 크다.
		//예를들어 'A‘의 코드는65이고 ’a'의 코드는97이다. 
		//(1)~(2)에 알맞은 코드를 넣으시오.
		
		char chh = 'a';
		char lowerCase = (chh>='A' && chh <='Z') ? (char)(chh+32): chh;

		System.out.println("ch:"+chh);
		System.out.println("chto lowerCase:"+lowerCase);






		
		

		
		
		
	}

}
