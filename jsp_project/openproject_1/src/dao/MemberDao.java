package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import member.model.Member;
import member.model.Message;




public class MemberDao {
	
	//싱글톤패턴: 코딩스타일
	//외부에서 인스턴스를 생성하지 못한다.
	//인스턴스를 반환 해주는 메소드가 있어 인스턴스가 필요한 경우 메소드를 이용해서 얻는다.
	
	//인스턴스 생성 막는다: 생성자의 접근제어자 -> private
	private MemberDao() {}
	
	//객체 하나를 생성해서 사용한다.
	private static MemberDao dao = new MemberDao(); 
	
	//Dao객체의 참조변수를 반환해주는 메소드: 외부 클래스 누구나 접근해서 사용할 수 있어야 한다.
	public static MemberDao getInstance() {
		
		return dao;
	}
	
	//Member테이블의 Data를 CRUD
	//insert,select,update,delete
	
	//데이터 입력
	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sqlInsert = "INSERT INTO member(memberid, password, membername, memberphoto)VALUES(?,?,?,?)";
		
		/* try { */
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1,member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserPhoto());
			
			resultCnt = pstmt.executeUpdate(); //dml 
			
	/*	} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		return resultCnt;
		
	}

	//로그인을 위한 select
	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		
		Member member = null;
		
		String sqlSelect = "SELECT * FROM member where memberid=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, uid);
			pstmt.setString(2,pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*아래 코드와 중복되기 때문에 주석처리하고 간결하게 작성한다
				 * member = new Member(rs.getString("memberid"), rs.getString("password"),
				 * rs.getString("membername"), rs.getString("memberphoto"),
				 * rs.getTimestamp("regdate"));
				 */
				member=makeMember(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return member;
	}
	
	//전체리스트를 반환하는 select
	public List<Member> selectMember(Connection conn){
		
		List<Member> list = new ArrayList<Member>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				/*
				 * list.add(new Member( rs.getString("memberid"), rs.getString("password"),
				 * rs.getString("membername"), rs.getString("memberphoto"),
				 * rs.getTimestamp("regdate") ));
				 */
				
				list.add(makeMember(rs));
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	

	public List<Member> selectMember(Connection conn, int firstRow, int count) throws SQLException {
		List<Member> memberList = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from member order by memberid limit ?,?";
		
		try {
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  firstRow);
		pstmt.setInt(2,count);
		
		rs = pstmt.executeQuery();
		memberList = new ArrayList<Member>();
		
		while(rs.next()) {
			memberList.add(makeMember(rs));
		}
		
		
		
		}finally {
			rs.close();
		    pstmt.close();
		}
		return memberList;
	}

	
	private Member makeMember(ResultSet rs) throws SQLException {
		
		return new Member(rs.getString("memberid"),
	            rs.getString("password"),
	            rs.getString("membername"),
	            rs.getString("memberphoto"),
	            rs.getTimestamp("regdate"));
	}

	public int selectMemberTotalCount(Connection conn) throws SQLException {
		
		int resultCnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql="select count(*) from member";
		
		try {
		stmt = conn.createStatement();
		
		rs=stmt.executeQuery(sql);
		
		if(rs.next()) {
			resultCnt = rs.getInt(1);
	
		}
		}finally {
			rs.close();
			stmt.close();
		}
		
		return resultCnt;
	}
	
	/*
	 * //++방명록 추가 public int insertMessage(Connection conn, Message message) throws
	 * SQLException { int resultCnt =0; PreparedStatement pstmt = null;
	 * 
	 * String sql = "INSERT INTO member(memberid, password, message )VALUES(?,?,?)";
	 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, message.getUserId());
	 * pstmt.setString(2,message.getPassword()); pstmt.setString(3,
	 * message.getMessage());
	 * 
	 * return resultCnt;
	 * 
	 * }
	 */
	


	
}
