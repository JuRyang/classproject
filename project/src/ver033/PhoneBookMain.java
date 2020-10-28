package ver033;


import java.util.Scanner;


public class PhoneBookMain {

	public static void main(String[] args) {
		
		Manager manager = new Manager();
		System.out.println();
		System.out.println("현재 저장개수:"+manager.cnt);
		
     	Scanner sc = new Scanner(System.in);
     
while(true) {
			
			System.out.println("전화번호 관리프로그램================");
			System.out.println("메류를 입력하세요");
			System.out.println(" 1. 정보저장");
			System.out.println(" 2. 정보검색");
			System.out.println(" 3. 정보삭제");
			System.out.println(" 4. 정보전체보기");
			System.out.println(" 5. 프로그램 종료");
		    System.out.println("==============================");

		    char insertMenu=sc.nextLine().charAt(0);


		    switch(insertMenu) {
			case'1':
				manager.save();
				break;
			case'2':
				manager.serchMember();
				break;
			case'3':
				manager.delect();;
				break;
			case'4':
				manager.displayAll();
				break;
			case'5':
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}

}

}
}