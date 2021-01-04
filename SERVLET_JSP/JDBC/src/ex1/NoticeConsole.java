package ex1;

public class NoticeConsole {
	
	private NoticeConsole service;
	
	//생성자
	public NoticeConsole() {
		service = new NoticeConsole();
	}

	public void printNoticeList() {
		System.out.println("──────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d게시글\n",12);
		System.out.println("──────────────────────────────────────");
		System.out.printf("%d.%s/%s/%s",
				             12,"안녕하세요","sb","2020-10-05");
		System.out.println("──────────────────────────────────────");
		System.out.printf("         %d/%d pages\n",1,  2);
	
	
	
	
	}

	public int inputNoticeMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
