package phone;

import java.util.Scanner;

import javax.naming.directory.SearchResult;

public class PhoneBookManager {

	private PhoneInfo[] phoneInfo; // 정보 저장을 위한 배열선언.
	int cnt = 0;

	Scanner sc = new Scanner(System.in);

	// 생성자
	PhoneBookManager(int num) {
		phoneInfo = new PhoneInfo[num];
	

	}

	void addPhoneInfo(PhoneInfo p) {
		phoneInfo[cnt++] = p;
	}

	// 저장 기능
	void addPhoneInfo(int choice) {
		System.out.println(" 전화번호 정보를 입력을 시작합니다.");

		// 이름 입력받기
		System.out.println("이름을 입력해주세요:");
		String name = sc.nextLine();

		// 전화번호 받기
		System.out.println("전화번호를 입력해주세요:");
		String pNum = sc.nextLine();

		// 주소받기
		System.out.println("주소를 입력해주세요:");
		String addr = sc.nextLine();

		// 이메일 받기
		System.out.println("이메일 입력해주세요:");
		String email = sc.nextLine();

		// 인스턴스를 생성해서 저장
		if (choice == 1) {
			System.out.println("전공을 입력하세요");
			String major = sc.nextLine();
			System.out.println("학년을 입력하세요");
			String year = sc.nextLine();
			addPhoneInfo(new PhoneUnivInfor(name, pNum, addr, email, major, year));
		} else if (choice == 2) {
			// 회사 데이터 받고 ->인스턴스 생성 -> 배열에 저장
			System.out.println("회사명을 입력하세요");
			String company = sc.nextLine();
			addPhoneInfo(new PhoneCompanyInfor(name, pNum, addr, email, company));
		} else if (choice == 3) {
			System.out.println("동호회명을  입력하세요");
			String club = sc.nextLine();
			addPhoneInfo(new PhoneClub(name, pNum, addr, email, club));
		} else {
			System.out.println("가족관계를 입력하세요");
			String relation = sc.nextLine();
		}

		System.out.println("입력이 완료되었습니다\n");

	}

	// 정보 검색
	// 검색된 index로 정보출력
	void searchMember() {

	if (cnt == 0) {
			System.out.println("저장된 데이터 없습니다.다시 메뉴로 이동합니다.");
			return; // 메서드의 종료
		}

		// 찾고자 하는 이름을 받는다.
		System.out.println("정보 검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력해주세요.:");
		String name = sc.nextLine();
		
		
	

		// 이름을 요소 index 검색
		//찾고자 하는 정보가 존재하지않다는걸 알려주기 위해 -1 
		int index=searchIndex(name);
		if(index<0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		}else {
			//정보 출력
			phoneInfo[index].showData();
		
		
		}
	
	}
	
	
	//배열에 있는 정보와 비교 값 반환하는 메서드
	int searchIndex(String name) {
		int result=-1;
		
		//검색
		for(int i =0; i<cnt; i++) {
			if(phoneInfo[i].getName().equals(name)) {
				result=i;
				break;
			}
			
		}
		
		return result;
	}
	


	// 정보삭제

	void deleteMember() {

		System.out.println("정보 삭제를 진행합니다.");
		System.out.println("삭제 하고자 하는 정보의 이름을 입력해주세요.");
		String name = sc.nextLine();

		// 이름을 요소 index 검색
		int index = -1; // 찾고자 하는 정보가 존재하지않다는걸 알려주기 위해 -1
		// 검색: index를 찾는다.
		for (int i = 0; i < cnt; i++) {
			if (phoneInfo[i].getName().equals(name)) {
				index = i;
				break;
			}
		}

		if (index < 0) {
			System.out.println("삭제하고자 하는 정보가 존재하지않습니다.");
		} else {
			
			// 삭제처리: 삭제해야하는 index부터 왼쪽으로 시프트 처리
			for (int i = index; i < cnt - 1; i++) {
				phoneInfo[i] = phoneInfo[i + 1];
			}

			cnt--;

			System.out.println("정보를 삭제했습니다.");
		}
	}

	// 전체정보출력
	public void displayAll() {

		if (cnt == 0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}

		System.out.println("전체 정보를 출력합니다. (" + cnt + ")");
		System.out.println("---------------------------");
		for (int i = 0; i < cnt; i++) {
			phoneInfo[i].showData();
			System.out.println("---------------------------");
		}

		

	}
	

}