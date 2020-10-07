package card;

public class Card {
	
	String kind; //카드의 종류 
	int number; //카드의 숫자
	
	Card(String Kind, int number){
		this.kind = Kind;
		this.number = number;
	}
	
	Card(){
		//다른 생성자를 호출
		this("spade", 1);
	}
	
	//클래스 변수 선언
	static int width = 100;  //카드의 폭 <-이런 변하지 않는 변수는 앞에 final(상수) 붙임
	static int height = 250; //카드의 높이
	
	//static 변수들은 클래스에 종속적이지 않다. 독립적!
	
	static void play() {  //인스턴스 메소드
	System.out.println("카드놀이 합니다.");
	}
	
	

}
