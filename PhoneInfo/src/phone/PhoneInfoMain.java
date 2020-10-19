package phone;

import java.util.Scanner;

public class PhoneInfoMain {


	public static void main(String[] args) {
		
	PhoneBookManager bookManager = new PhoneBookManager(10);
	
	Scanner sc =new Scanner(System.in);
	
	while(true) {
		System.out.println("*** 메뉴 선택 ***");
		System.out.println("1. 대학 친구 정보 저장");
		System.out.println("2. 회사 직원 정보 저장");
		System.out.println("3. 동호회 정보 저장");
		System.out.println("4. 가족 정보 저장");
		System.out.println("5. 전체 정보 출력");
		System.out.println("6. 정보 검색 하기 ");
		System.out.println("7. 정보 삭제 하기");
		
		System.out.println("8. EXIT");
		System.out.println("선택하세요>> ");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1: case 2: 
			bookManager.addPhoneInfo(choice);
			break;
		case 3:
			bookManager.addPhoneInfo(choice);
			break;
		case 4:
			bookManager.addPhoneInfo(choice);
		     break;
		case 5:
			bookManager.displayAll();
		case 6:
			bookManager.searchMember();
			break;
		case 7:
			bookManager.deleteMember();
			break;
		case 8:
		     System.out.println("프로그램을 종료합니다.");
		     return;
		}
	
	
		

	}

}
}