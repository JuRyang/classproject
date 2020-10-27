package thread;

import javax.swing.JOptionPane;
public class ThreadTestMain1{
public static void main(String[] args) {

	String age = JOptionPane.showInputDialog("나이 입력해주세요"); //여기서 멈쳐있음 (창은 띄어짐 다음 화면으로 안넘어감)
	
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
	}
	

}
}
