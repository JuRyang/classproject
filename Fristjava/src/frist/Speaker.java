package frist;

public class Speaker {
	
	private int volumeRate; //볼륨크기
	
	//현재 볼륨의 크기를 출력
	  void showCurrnetState() {  // 다른 클래스에서 이 메서드를 쓰려면 앞에 public 쓰자
		System.out.println("볼륨의 크기:"+volumeRate);
	}
	
	//set을 값을 저장하는것 get 값을 가져오는거 
	public void setVolume(int vol) {
		volumeRate = vol;
	}


	

}
