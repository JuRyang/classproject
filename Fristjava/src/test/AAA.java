package test;

public class AAA {
	
	///public AAA(){} 자동으로 들어가는 것 
	
	int num;
	//외부에서도 사용하려면 static 앞에 public 있어야 함 
	public static int n = 100;
	
//	static AAA a = new AAA(); //인스턴스 참조변수
	
	AAA(){
		
	}
	
	// setter메서드
	// bbb클래스에서 num에 10을 저장해주고싶은데 private로 되어있음
	public void setNum(int num) {
		this.num=num;
	}
	
	//getter메서드
	public int getNum() {
		return num;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
