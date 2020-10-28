package ver033;

import java.util.Scanner;



public class Manager {
	
	//PhoneInfo[] phoneBook = new PhoneInfo[100];

	//정보 저장을 위한 배열 선언
	PhoneInfo[] phoneBook;
	int cnt; //저장 개수
	

	Scanner sc =new Scanner (System.in);
	
	//초기화
	public Manager() {
		//phoneBook = new PhoneInfor[100]; //배열의 저장공간을 100개 생성
        this(100);	
	}
	//생성자의 오버로딩
	Manager(int size) {
		phoneBook= new PhoneInfo[size];
	}
	void save() {
		
		System.out.println("정보를 입력해주세요");
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해주세요");
		String pNum = sc.nextLine();
		
		System.out.println("생년월일을 입력해주세요");
		String birthday=sc.nextLine();
		
		//배열에 저장하기위한 인스턴스의 참조변수 선언
		PhoneInfo infor = null;
		
		if(birthday !=null && birthday.length()>0) {
			infor = new PhoneInfo(name,pNum,birthday);
		}else {
			infor = new PhoneInfo(name,pNum);		
		}
		phoneBook[cnt++] = infor; //phonBook[0](참조변수) = 0x111(주소);
		cnt++; //추가된 정보의 개수를 +1
		
		
	}
	
	void serchMember() {
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다.");
			return;
		}
		
		//찾고자 하는 이름을 받는다.
		System.out.println("정보검색");
		System.out.println("찾고자 하는 이름 입력");
		String name = sc.nextLine();
		
		int index=serachIndex(name);
		
		if(index<0) {
			System.out.println("일치한 정보 없음");
		}else {
			phoneBook[index].showInfo();
		}
		
		
	}
	
	//문자열 비교
	int serachIndex(String name) {
		int result =-1;
		
		for(int i=0; i<cnt; i++) {
			if(phoneBook[i].name.equals(name)) {
				result =i;
				break;
			}
		}
		return result;
	}
	 //정보삭제
	 //삭제하고자 하는 이름을 사용자로부터 받는다->
	 //배열에서 이름으로 검색해서  index를 찾는다.
	 //배열에서 찾은 index의 참조값을 삭제: 인스턴스는 참조하는 참조변수가 없으면 삭제된다.
	 //참보값에  null을 입력하거나, 다른 주소값을 입력 -> 이전에 있던 참조값은 없어진다.
     //삭제 대상의 index부터 왼쪽으로 값을 시프트 처리 
     //cnt-1
	
	void delect() {
		System.out.println("정보삭제");
		System.out.println("삭제 할 이름 입력");
		String name= sc.nextLine();
		
		int index =-1;
		
		for(int i =0; i<cnt; i++) {
			if(phoneBook[i].name.equals(name)) {
				index=i;
				break;
			}
}
		if(index<0) {
			System.out.println("일치한 정보 없음");
		}else {
			for(int i=index; i<cnt--; i++) {
				phoneBook[i]=phoneBook[i+1];
			}
		}cnt--;
		System.out.println("정보삭제");
	}
	
// 전체정보출력
void displayAll() {
	 
	 if(cnt==0) {
		 System.out.println("등록된 정보가 없습니다.");
		 return;
	 }
	 

	 System.out.println("전체 정보를 출력합니다. ("+cnt+")");
	 System.out.println("---------------------------");
	 for(int i=0; i<cnt; i++) {
		 phoneBook[i].showInfo();
		 System.out.println("---------------------------");
	 }

}
}

