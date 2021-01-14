package member.model;

import java.util.List;

public class MessageListView {
	
	private int messageTotalCount; //게시물의 전체개수:페이지 개수
	private int currentPageNumber; //현재페이지 번호 List<Message>
	private List<Message> messageList; //페이지 번호에 맞는 게시물의 리스트
	private int pageTotalCount; //페이지 개수
	private int messageCountPerPage; //한 페이지에 출력할 메시지 개수
	private int firstRow; //DB에서 테이블의 시작행
	
	
	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList, int pageTotalCount,
			int messageCountPerPage, int firstRow) {
		
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.pageTotalCount = pageTotalCount;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
	}
	
	private void calculatePageTotalCount() {
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount/messageCountPerPage;
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}


	public int getMessageTotalCount() {
		return messageTotalCount;
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public List<Message> getMessageList() {
		return messageList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}


	public int getFirstRow() {
		return firstRow;
	}
	
	
	

}
