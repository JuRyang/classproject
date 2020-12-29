package member.model;

import java.sql.Timestamp;

public class Message {

	private String userId;
	private String password;
	private String message;
	private Timestamp writedate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "List [userId=" + userId + ", password=" + password + ", message=" + message + ", writedate=" + writedate
				+ "]";
	}

	
}
