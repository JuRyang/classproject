package thread;

import javax.swing.JOptionPane;
public class ThreadTestMain2{
//  입력을 했으면 카운트가 멈췄으면 좋곘어
	//다른 쓰래드에서 참조가 가능한 클래스 변수.
	public static boolean check = false;
public static void main(String[] args) {

	//  입력을 했으면 카운트가 멈췄으면 좋곘어
	
	
	InputAgeThread iat = new InputAgeThread();
	CountDownTread cdt = new CountDownTread();
	
	iat.start();
	cdt.start();
	
	
	/*String age = JOptionPane.showInputDialog("나이 입력해주세요"); //여기서 멈쳐있음 (창은 띄어짐 다음 화면으로 안넘어감)
	
	int ageNumber =Integer.parseInt(age);
	//서버쪽에서 많이 쓰임 Integer.parseInt(age); 기억해두기
	
	System.out.println("저의 나이는 "+age+"살 입니다.");
	

	for(int i=10; i>0; i--) {
		System.out.println(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	

}
}

class InputAgeThread extends Thread{

	@Override
	public void run() {
		System.out.println("10초 안에 입력해");
		String age = JOptionPane.showInputDialog("나이 입력해주세요"); //여기서 멈쳐있음 (창은 띄어짐 다음 화면으로 안넘어감)
		System.out.println("저의 나이는 "+age+"살 입니다.");
		ThreadTestMain2.check = true;
	}
	
	
}


class CountDownTread extends Thread{
	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			if(ThreadTestMain2.check) {
				break;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.exit(0); //10초가 지나면 종료 
		
	}
}