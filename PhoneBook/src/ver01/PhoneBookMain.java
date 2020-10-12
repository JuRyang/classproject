package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfor pi1 = new PhoneInfor("손흥민","010-0000-0000","1990.12.10");
		PhoneInfor pi2 = new PhoneInfor("박지성","010-1111-1123");
		pi1.showInfor();
		pi2.showInfor();

	}

}
