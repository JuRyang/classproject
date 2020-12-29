package guestbook.excetipm;

public class MessageNotFoundException extends Exception {

	public MessageNotFoundException() {
		super("게시물이 존재하지 않습니다.");
	}
}