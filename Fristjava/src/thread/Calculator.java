package thread;

public class Calculator {
	
	int opPlusCnt=0;
	int opMinCnt=0;
	
	public int add(int n1, int n2) {
		synchronized (this) { //참조변수 this를 가지고 오면 opCnt++ 실행 참조변수를 키로 사용
			opPlusCnt++;
		}
		return n1+n2;
	}

	public int min(int n1, int n2) { //동기화가 생기기 때문synchronized
		synchronized (obj) {  //앞쪽에서 다른 스레드가 사용하고 있다? this가 사용 중이라 대기 중 
		opMinCnt++;
		}
		return n1-n2;
	}

	//새로운 동기화 키
	Object obj = new Object();
	

}
