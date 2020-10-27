package thread;

public class AdderThreadMain {

	public static void main(String[] args) {
		
		Adderthread at1 = new Adderthread(1, 50);
		Adderthread at2 = new Adderthread(51, 100);
		
		//쓰레드 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //t1쓰레드가 종료될 때까지 다른 쓰레드는 멈춤 상태
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	/*	try {
		Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("1부터 100까지 합은"+(at1.getNum()+at2.getNum()));
		

	}

}
