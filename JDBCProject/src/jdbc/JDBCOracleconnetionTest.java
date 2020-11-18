package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.net.aso.e;

public class JDBCOracleconnetionTest {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
	//	try {
		//1.드라이버 로드
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Oracle Driver Load !!!");
				
				//2.DB 연결  localhost == 127.0.0.1
				String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
				String user = "scott";
				String password = "tiger";
				
				conn = DriverManager.getConnection(jdbcUrl,user,password);
				System.out.println("데이터 접속");
				
				
				conn.close();
				
			} catch (ClassNotFoundException  e) {
				System.out.println("드라이버 로드 실패");
			
			
			//..........
						
			
			conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			
				

	
		

	}

}
