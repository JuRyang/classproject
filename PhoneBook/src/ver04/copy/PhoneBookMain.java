package ver04.copy;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookrManager manager = new PhoneBookrManager(100);
		
		while(true) {
			System.out.println("메뉴를 입력해주세요.==================");
			System.out.println(Menu.SAVE+". 저장");
			System.out.println(Menu.SEARCH+". 검색");
			System.out.println(Menu.DELECT+". 삭제");
			System.out.println(Menu.ALLINFO+". 모든 정보 출력");
			System.out.println(Menu.EXIT+". EXIT");
			
			System.out.println("\n>>");
			
			int select = Util.sc.nextInt();
			
			if(!(select>0 && select <6)) {
				System.out.println("메뉴의 선택이 옳바르지 않습니다.\n 다시 선택해주세요");
				continue;
		}

			switch (select) {
			case Menu.SAVE:
				manager.insertInfo();
				break;
			case Menu.SEARCH:

				manager.searchInfor();
				break;
			case Menu.DELECT:
				manager.deleteInfor();

				break;
			case Menu.ALLINFO:
				manager.showAllInfor();

				break;
			case Menu.EXIT:
				System.out.println("프로그램 종료");
				break;
			}

		}
		}

}
