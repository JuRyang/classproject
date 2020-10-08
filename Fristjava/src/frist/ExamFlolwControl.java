package frist;

import java.util.Scanner;


public class ExamFlolwControl {

	public static void main(String[] args) {
		
		/*문제1.

		아래 예제는 두 개의 if문을 사용하고 있다. 한 개의 if 문만 사용하는 방식으로 변경해보자.
		​int num=120;

		if(num>0) {
		if((num%2)==0)
		System.out.println(“양수이면서 짝수");			
		}*/
		System.out.println("문제1=============");			
		int num = 120;
		if(num>0 && num%2 ==0) {
			System.out.println("양수이면서 짝수");
		}
	/*	문제2.

		다음과 같이 출력이 이루어지도록 작성해보자.

		num < 0 이라면 “0 미만” 출력
		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		300 ≤ num 이라면 “300이상 “ 출력  */
		System.out.println("문제2=============");		

		if(num<0) {
			System.out.println("0미만");
		}else if(num<100) {       //num>=0 && num<100
			System.out.println("0이상 100 미만");
		}else if(num<200) {      //100>=num && num<200
			System.out.println("100이상 2000 미만");
		}else if(300<=num ) {    //num>=200 && num < 300
			System.out.println("200이상 300 미만");
		}else {
			System.out.println("300이상");
		}
		
		/*문제3.

		CondOp.java를 조건연산자(3항 연산자)를 사용하지 않고,
		if~else를 사용하는 형태로 변경해 보자.

		int num1=50, num2=100;
		int big, diff;
		big = (num1>num2)? num1:num2;

		System.out.println(big);
		diff = (num1>num2)? num1-num2: num2-num1;  */
		System.out.println("문제3=============");		
		int num1 = 50;
		int num2=100;
		int big, diff;
		
		
		if(num1>num2) {
			big=num1;
		}else {
			big=num2;
		}
		System.out.println(big);
		
		if(num1>num2) {
			diff= num1-num2;
		}else {
			diff = num2-num1;
		}
		System.out.println(diff);
		
	/*	문제 4.
		SwitchBreak.java를 switch문이 아닌, if~else를 사용하는 형태로 변경해 보자.
		​
		int n=3;

		switch(n) {

		case 1:
		System.out.println("Simple Java");
		break;

		case 2:
		System.out.println("Funny Java");
		break;

		case 3:
		System.out.println("Fantastic Java");
		break;

		default:

		System.out.println("The best programming language");
		}

		System.out.println("Do you like coffee?"); */
		System.out.println("문제4=============");		
		int n = 3;
		if(n==1) {
			System.out.println("Simple Java");
		}else if(n==2) {
			System.out.println("Funny Java");
		}else if(n==3) {
			System.out.println("Fantastic Java");
		}else {
			System.out.println("Do you like coffee?");
		}
		
		/*문제 5.

		문제 2의 답안 코드를 switch 문으로 변경하여 보자.
		num < 0 이라면 “0 미만” 출력 부분은 if문을 사용하고 나머지 조건에 대해 변경하세요.*/
		
	/*	if(num<0) {
			System.out.println("0미만");
		}else if(num<100) {       //num>=0 && num<100 ->0-99 / 100 = 0
			System.out.println("0이상 100 미만");
		}else if(num<200) {      //100>=num && num<200
			System.out.println("100이상 2000 미만");
		}else if(300<=num ) {    //num>=200 && num < 300
			System.out.println("200이상 300 미만");
		}else {
			System.out.println("300이상");
		}*/
		System.out.println("문제5=============");		
		
		if(num<0) {
			System.out.println("0미만");
			switch(num/100) {
			case 0:
				System.out.println("0이상 100 미만");
				break;
			case 1:
				System.out.println("100이상 200미만");
				break;
			case 2:
				System.out.println("200이상 300미만");
				break;
				
				default:
					System.out.println("300이상");
			}
			
		}
		
		/*문제 6.

		while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성.*/
		System.out.println("문제6=============");	
		int i = 1;
		int sum = 0;
		 while(i<100) {
			 System.out.println("sum=" +sum+" +i="+i);
			 sum += i;
			 i++;
		 }
		 
		 System.out.println("1~99까지의 합:"+sum);
		
		/* 문제 7.
		 1부터 100까지 출력한 후, 다시 거꾸로 100부터 1까지 출력하는 프로그램을 작성. 
		 while문과 do~while 문을 각각 한번씩 사용해서 작성*/
		 System.out.println("문제7=============");	
		 int cnt =1;
		 while(cnt<=100) {
			 System.out.println(cnt++);
			 //cnt++;
		 }
		 
		 do {
			// cnt--;
			 System.out.println(--cnt);
			
		 }while(cnt>1);
			
		 
		 /* 문제 8.
		 1000 이하의 자연수 중에서 2의 배수 이면서 7의 배수인 숫자를 출력하고,
		 그 출력된 숫자들의 합을 구하는 프로그램을 while 문을 이용해서 작성*/
		 System.out.println("문제8=============");	
		 i = 1;
		 sum = 0;
		 int count =0;
		 
		 while(i<=1000) {
			 if(i %2==0 && i%7==0) {
				 System.out.println(i);
				 count++;
				 sum+=i;
				 
			 }
			 
			 i++;
		 }
		 System.out.println("1000이하의 자연수 중 14의 배수의 개수:"+count);
		 System.out.println("1000이하의 자연수 중 14의 배수들의 합:"+sum);

		/* 문제 9.
		 for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성 */
		 System.out.println("문제9=============");
		 int result =1; 
		 for(i=1; i<=10;i++) {
			 result= result * i;  //result *= i
			 
		 }
		 System.out.println("1~10까지의 곱:"+result);
		 
		 /*문제 10.
		 for 문을 이용하여 구구단 중 5단을 출력하는 프로그램 작성*/
		 
	/*	 System.out.println("문제10=============");
		 
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.println("원하는 구구단 하나를 입력해주세요");
		  
		  int select = sc.nextInt();
		  
		  for(i=1; i<10; i++) {
			  System.out.println(select+"X" +i+ "=" +select * i);
		  } */
		  
	/*	  문제 11.

		  ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성

		  int num=0;
		  int count=0;

		  while((num++)<100){
		     if(num%5!=0 || num%7!=0)
		            continue;
		  count++;
		  System.out.println(num);
		  }
		  System.out.println("count: " + count); */
		  System.out.println("문제11=============");
		  num = 0;
		  count = 0;
		  for(num=1; num<100; num++) {
			  if(num%5!=0 || num%7!=0)
				  continue;
		  }
		  count++;
		  System.out.println(num); 
		  
		/*  문제 12.

		  자연수 1부터 시작해서 (모든 홀수)와(3의 배수인 짝수)를 더해 나간다. 
		  그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 
		  그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
		  프로그램 내부에 while문을 무한 루프로 구성하여 작성.*/
		  System.out.println("문제12=============");
		  num =1;
		  sum=0;
		  
		  while(true) {
			  
			  if(num%2==1 || (num % 3==0 && num %2==0)){
					  sum += num;
			  }
			  
			  if(sum>1000) {
				  System.out.println(num+"을 더하면");  
				  System.out.println("최초로 합이 1000이 넘어가는 합은 :" +sum);
			  
				  break;
				 
			  }
			  num++;
	  
			  
	} 
		/*  문제 13.

		  구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
		  단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력*/
		  System.out.println("문제13=============");
		  
		  for(i=2;i<10; i*=2) {
			  System.out.println(i+"단");
			  for(int j=1; j<i+1; j++) {
				  System.out.println(i+"X"+j+"="+i*j);
			  }
		  }
		  
		/*  문제 14.

		  다음 식을 만족하는 조합을 찾는 프로그램 작성. 
		  A B
	   +  B A
		  ------
		  9 9*/
		  
		  System.out.println("문제14=============");
		  
		  System.out.println(" A B");
		  System.out.println("+B A");
		  System.out.println("------");
		  System.out.println(" 9 9");
		  System.out.println("위의 조건이 성립하는 조합은 아래와 같습니다.");
	
		  for(n=0; n<10; n++) {  //a+b=9. a=9-b
			  int a, b;
			  a=n;
			  b=9-n;
			  System.out.println("A="+a+"일때, B="+b+"입니다.");
			
		  }
		  
		  
		  
		  

}
}