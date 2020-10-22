package ver06;


import java.util.Scanner;

import ver03.Util;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		//PhoneBookrManager manager = new PhoneBookrManager(100);
		PhoneBookrManager manager = PhoneBookrManager.getInstance();
		
		
		int select=0;
		
		
		while(true) {
			try {
			
				 
			System.out.println("메뉴를 입력해주세요.==================");
			System.out.println(Menu.INSERT+" 저장");
			System.out.println(Menu.SEARCH+" 검색");
			System.out.println(Menu.DELECTE+" 삭제");
			System.out.println(Menu.DISPLAY_ALL+" 모든 정보 출력");
			System.out.println(Menu.EXIT+" EXIT");
			
			System.out.println("\n>>");
			
			 select = Util.sc.nextInt();
			 Util.sc.nextLine();
			
		}catch(NumberFormatException e) {
			if(!(select>0 && select <6)) 
				System.out.println("메뉴의 선택이 올바르지 않습니다.\n 다시 선택해주세요");
			

			
				switch (select) {
			case Menu.INSERT:
				manager.insertInfo();
				break;
			case Menu.SEARCH:

				manager.searchInfor();
				break;
			case Menu.DELECTE:
				manager.deleteInfor();

				break;
			case Menu.DISPLAY_ALL:
				manager.showAllInfor();

				break;
			case Menu.EXIT:
				System.out.println("프로그램 종료");
				
				continue;
				
				}
			
				break;
			}
			
			
			try {
				System.out.println("정수를 입력해주세요"+select);
		
			} catch (NumberFormatException e) {
				System.out.println("숫자가 아닙니다.");
				System.out.println(e.getMessage());
			}
			
			
			

		
		}

	}

}
