package geustbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;
import jdbc.jdbcUtil;

public class MessageDao {

	//싱글톤 패턴: Dao 인스턴스는 여러 개 생성될 필요가 없다.
	private MessageDao() {}
	
	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}
	
	//방명록에 데이터를 저장 메소드 //전달 받는건 컨넥션에서 받음(사용자의 요청을 처리하기 위한 기능을 구현 DBO를 통해서 데이터에 접근)
	public int insertMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0; //반환할 결과값
		PreparedStatement pstmt = null;
		try {
			
			String sql= "INSERT INTO guestbook_message (guest_name,password,message ) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();
			
		}finally {
			pstmt.close();
		}
		
		return resultCnt;
	}

	//전체 게시물의 개수를 구하는 메소드
	public int selectAllcount(Connection conn) throws SQLException {

		int totalCnt=0; //응답처리할 변수 
		
		//언제나 사용할 것
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from guestbook_message";
			rs = stmt.executeQuery(sql); //실행할때 sql 넣을 것
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} finally{
		 
			jdbcUtil.close(rs);
			jdbcUtil.close(stmt);
		}
		
		return totalCnt;
	}

	public List<Message> selectList(Connection conn, 
			                          int firstRow, int messageCountPerPage) throws SQLException {
		
		List<Message> list = new ArrayList<Message>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from opn.guestbook_message order by message_id desc limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,firstRow);
			pstmt.setInt(2,messageCountPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(makeMessage(rs));
			}
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		
		
		return list;
	}
	
	private Message makeMessage(ResultSet rs) throws SQLException {
		
		Message message = new Message();
		message.setId(rs.getInt(1));
		message.setGuestName(rs.getString(2));
		message.setPassword(rs.getString(3));
		message.setMessage(rs.getString(4));
		message.setWritedate(rs.getTimestamp(5));
		
		return message;
	}

	public Message selectMessage(Connection conn, int mid) throws SQLException {
		
		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from opn.guestbook_message where message_id=?"; //message_id:pk 유니크 결과 row
		
		try {
		pstmt = conn.prepareStatement(sql); //여기서 예외처리 안하고 던지고  try~ finally
		pstmt.setInt(1,mid);//첫번째 물음표
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			message = makeMessage(rs);
		}
		
		}finally {
			
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			
		}
		
		
		return message;
	}

	//삭제 여부를 위해 void 대신 int로 바꾼다
	public int deleteMessage(Connection conn, int mid) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql="DELETE FROM opn.guestbook_message WHERE message_id=?";
		
		try {

		  pstmt = conn.prepareStatement(sql);
		  pstmt.setInt(1, mid);
		
		  resultCnt = pstmt.executeUpdate();
		
		}finally{
			jdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	
	
	
	
	
	
	
	
	
}
