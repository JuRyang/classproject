package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
Connection conn = null;
		
		//2.DB 연결  localhost == 127.0.0.1 //thin 오라클이만 씀
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		String user = "bit";  //계정
		String password = "bit";
		
		conn = DriverManager.getConnection(jdbcUrl,user,password);
		return conn;
	}

}
