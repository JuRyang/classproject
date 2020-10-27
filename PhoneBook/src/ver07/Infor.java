package ver07;

import java.io.Serializable;

public interface Infor extends Serializable {
	//인터페이스 쓰는 이유는 규칙(반드시 구현하는)
	//구조 상 Infor Serializable 하는게  더 낫다. 
	//info에 상속하면 PhoneInfor 구현하여 접근성이 더 높아짐
	
	void showInfo();
	void showBasicInfor();
	
	

}
