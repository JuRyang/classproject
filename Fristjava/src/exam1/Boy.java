package exam1;

public class Boy {
	

//구슬치기를  소유하고  있는 어린아이(객체) 구슬의 개수 정보(변수)
//놀이를 통하여 구슬을 주고받음을 표현하는 메소드
//두번째 조건에서 두아이가 구슬치기를 하는 과정에서 구슬 잃고 얻음을 의하는 
	
	int numOfmarble;
	String name;
	
	// 어린이의 이름과 구슬의 개수를 설정하는 메서드
	void setBoy(String boyName, int num) {    //반환없음 void 사용
		name = boyName; //지역변수  String boyname 매개변수를 받음
		numOfmarble = num; //int num 매개변수를 받음
		
	}
	
	//게임의 결과가 실패 -> 구슬의 개수를 감소
	void lose(int num) {
		numOfmarble -= num;
	}
	
	//게임의 결과가 성공 -> 구슬의 개수를 증가
	void win(int num) {
		numOfmarble += num;
	}
		
	//게임 후 승리 메서드 : 게임을 한 대상(상대방boy), 구슬의 개수 (num)
	void playWin(Boy boy, int num) {
		//나의 승리 -> 나의 구슬의 개수는 증가
		win(num);
		// 상대방은 패배 -> 구슬을 감소
		boy.lose(num);
	}
	
	//구슬의 개수를 출력하는 메서드
	void showData() {
		System.out.println(name+"의 구슬의 개수:"+numOfmarble);
		
	}
	
	public static void main(String[] args) {
		//인스턴스 각각 생성
		
		Boy boy1 = new Boy();
		Boy boy2 = new Boy();
		

		
		
		//어린이 1 구슬 15개 
		//어린이2 구슬 9개
		boy1.setBoy("어린이1", 15);  //17->10
		boy2.setBoy("어린이2", 9);   //7-> 14
		
	
		System.out.println("\n게임 시작할 때 어린이들이 보유한 구슬의 정보");
		boy1.showData();
		boy2.showData();
		
		//인스턴스 생성 후 메서드 내에 시물레이션 하자.
		//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다” 
		boy1.playWin(boy2, 2);
		System.out.println("\n 1차 게임:어린이1승리");
		boy1.showData();
		boy2.showData();
		
		
		//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.” 
		boy2.playWin(boy1, 7);
		System.out.println("\n 2차게임 어린이2가 승리");
		
		boy1.showData();
		boy2.showData();
		
		
		//정보 출력
		System.out.println("\n 결과");
		boy1.showData();
		boy2.showData();
		
	}

	
	
	
}
