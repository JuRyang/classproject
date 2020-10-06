package fruit;

public class FruitSeller {


	//클래스에는 변수와 메서드들 정의
	//성격이 비숫한 변수 메서드를 정의한다. 
	
	//변수: 인스턴스 변수, 멤버 변수 
	//int apple_Price = 1000; //사과의 가격
	final int APPLE_PRICE = 1000; //사과의 가격, 변경이 되지 않도록 상수로 등록
	int numofApple = 20;    // 사과의 보유 개수
	int myMoney = 0;        // 수익금액
	
	//기능: 판매, 정산 출력
	//판매 메서드: 
	//      돈을 받고 -> 
	//              반환하는 사과의 개수, 
	//              수익금 증가, 
	//              보유한 사과의 개수가 감소->
	//          사과의 개수 반환
	int saleApple(int money) {
		
		int num = 0; //반환할 사과의 개수, 지역변수는 반드시 초기화 해주어야 한다. 
		
		//반환할 사과의 개수를 구한다.
		num = money/APPLE_PRICE; //받은 돈/ 사과의 가격
		//수익금 증가
		myMoney = myMoney + money;
		// 사과의 개수를 감수
		numofApple = numofApple - num;
		
		return num;
	}
	
	//정산 출력 : 보유한 사과의 개수 출력, 보유한 수익금액 출력 , 
	//받는 데이터가 없으므로 매개변수 정의하지 않는다.
	//반환하는 데이터가 없으므로 void타입으로 메서드 정의

	void showSaleResult() {  
		System.out.println("현재 보유한 사과의 개수 :"+numofApple);
		System.out.println("판매수익금액 :"+myMoney);
	}
	
	

	}

