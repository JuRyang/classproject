package member.service;

public class WriteMessageService {
	
	//싱글톤패턴
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}

	//Message 객체를 받고
	//Connection 객체 생성
	//MessageDao객체 생성
	//insertMessage
	public int writeMessage(Message message) {
		
		int resultCnt =0;
		
		Connection conn= null;
		MessageDao dao = null;
	}
	
}
