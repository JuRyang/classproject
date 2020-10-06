package frist;

public class ExamOper1 { // oprator은 내가 풀이한거 비교해보기

	public static void main(String[] args) {
		
		System.out.println("문제1----------------");
		//문제 1
		int num1=10;
		int num2=20;
		int num3=30;
		System.out.println(num1+","+num2+","+num3);
		
      //<---------------- 이렇게 대입
		num1=num2=num3;
		System.out.println(num1+","+num2+","+num3);
		
		num1=num2=num3=50;
		System.out.println(num1+","+num2+","+num3);
		
		//문제 2
		System.out.println("문제2----------------");
		// {}:블록  ():연산 우선순위
        int num= (((25*5)+(36-4))-72)/5;
	    
	    System.out.println(num);
	    
	    //문제 3
	    System.out.println("문제3----------------");
	    
	    int oper1 = 3+6;
	    //int oper2 = 3+6+9;  //oper2 = oper1 + 9
	    //int oper3 = 3+6+9+12; // oper3 = oper2 + 12
	    
	    int oper2 = oper1 + 9;
	    int oper3 = oper2 + 12;
	    
	    System.out.println(oper1+","+oper2+","+oper3);
	    
	    
	    //문제 4
	    System.out.println("문제4----------------");
	    
	    int a = (((25+5)+(36/4))-72)*5;
	    int b = (((25*5)+(36-4))-71)/4;
	    int c = (128/4)*2;
	    
	    //a>b>c
	    boolean check = a>b && b>c; //논리연산
	    
	    System.out.println(check);
	    

	}

}
