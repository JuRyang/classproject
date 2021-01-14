package USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	private Connection conn; // connection db에 접근
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//mysql에 접속
	public UserDAO(){
		
		try {
		String jdbcUrl = "jdbc:mysql://localhost:3306/opn?serverTimezone=UTC";
		String user = "aia";
		String password = "aia";
		Class.forName("플젝:com.mysql,jdbc.Driver");
		conn=DriverManager.getConnection(jdbcUrl,user,password);
		
		} catch (Exception e) {

		e.printStackTrace(); // 오류가 무엇인지 출력

	}

	}
	
	//로그인을 시도하는 함수 
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID=?";
		
		//ptmt:prepared statement정해진 sql문장을 db에 삽입하는 형식으로 인스턴스 가져옴
		try {
			pstmt = conn.prepareStatement(SQL);
		
		//pstmt을 이용해 하나의 문장을 미리 준비해서 해당하는 내용을 유저아디,매개변수로 이용
		pstmt.setString(1,userID);
		//rs result set에 결과보관
		rs=pstmt.executeQuery();
		//결과가 존재한다면 실행
		if(rs.next()) {
			//패스워드가 일치한다면
			if(rs.getNString(1).contentEquals(userPassword)) {
				return 1;  //로그인 성공
			}else 
				return 0;  //비밀번호 불일치 
			}
			return -1; //아이디가 없음 오류
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -2; //데이터 오류
	}

	
}


