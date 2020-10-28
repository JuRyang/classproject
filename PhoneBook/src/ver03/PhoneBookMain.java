package ver03;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		//PhoneBookManager 인스턴스 생성: 배열과 메서드 사용
		PhoneBookManager manager = new PhoneBookManager();
		System.out.println("현재 저장된 정보의 개수:"+manager.cnt);
		System.out.println("저장이 가능한 정보의 총 개수는:"+manager.phoneBook.length);
		
		//SCanner  SC =new SCanner(System.in);
		
		while(true) {
			
			System.out.println("전화번호 관리프로그램================");
			System.out.println("메류를 입력하세요");
			System.out.println(" 1. 정보저장");
			System.out.println(" 2. 정보검색");
			System.out.println(" 3. 정보삭제");
			System.out.println(" 4. 정보전체보기");
			System.out.println(" 5. 프로그램 종료");
			System.out.println("==============================");
			
			char insertMenu =Util.SC.nextLine().charAt(0);  //이렇게 해야 오류가 잘 안남
			                   //유틸클래스에 스캐너 
			switch(insertMenu) {
			case'1':
				manager.insertMember();
				break;
			case'2':
				manager.searchMember();
				break;
			case'3':
				manager.deleteMember();
				break;
			case'4':
				manager.displayAll();
				break;
			case'5':
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
			
	/*		//정보 저장 기능 메서드 호출
			manager.insertMember();
			
			System.out.println("현재 저장된 정보의 개수:"+manager.cnt);
			//manager.phoneBook[0].showInfor(); //phoneBook[0]는 PhoneInfor 참조변수
			
			// 정보 검색 매서드 호출
			manager.searchMember();*/
			
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
