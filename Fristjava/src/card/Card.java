package card;

public class Card {
	
	String kind; //카드의 종류  인스턴스 변수
	int number; //카드의 숫자  인스턴스 변수 
	
	Card(String Kind, int number){ // 인스턴스 변수의 초기화 또는 인스턴스 생성시 수행할 작업에 사용 
		this.kind = Kind;      
		this.number = number;   //주로 인스턴스 변수의 초기화 코드를 적는다. 
	}
	
	
	Card(){
		//다른 생성자를 호출
		this("spade", 1);  //인스턴스 생성시 수행될 코드 
	}
	
	//클래스 변수 선언
	static int width = 100;  //카드의 폭((static)클래스 변수) <-이런 변하지 않는 변수는 앞에 final(상수) 붙임
	static int height = 250; //카드의 높이 ((static)클래스 변수)
	
	//static 변수들은 클래스에 종속적이지 않다. 독립적!
	
	static void play() {  //클래스 메소드
	System.out.println("카드놀이 합니다.");
	}
	
	

}
