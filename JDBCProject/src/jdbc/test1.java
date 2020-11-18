package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
		
		Connection conn = null;
		
	
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
				
				//3. Statement 인스턴스 생성
			    Statement stmt = conn.createStatement();
			    
			    System.out.println("새로운 사원을 입력해주세요");
			    System.out.println("EMPNO:");
			    int newempno = sc.nextInt();
			    System.out.println("NAME:");
			    String newename = sc.nextLine();
			    System.out.println("JOB:");
			    String newjob = sc.nextLine();
			    System.out.println("MGR:");
			    String newmgr = sc.nextLine();
			    System.out.println("HIREDATE:");
			    String newhire = sc.nextLine();
			    System.out.println("SAL:");
			    int newsal = sc.nextInt();
			    System.out.println("COMM:");
			    int newcom = sc.nextInt();
			    
			   
		    
			    //입력 : insert
			    String sqlInsert = "insert into emp values ('"+newempno+"', '"+newename+"','"+newjob+"','"+newmgr+"','"+newhire+"','"+newsal+"','"+newcom+"')";
		
			    int resultCnt = stmt.executeUpdate(sqlInsert);
			    
			    if(resultCnt>0) {
			    	System.out.println("데이터가 정상적으로 입력되었습니다.");
			    }
			    
			    //4.SQL 실행: 부서리스트 출력
			    String sql = "select * from emp order by empno";
			    
			    ResultSet rs = stmt.executeQuery(sql);
				
			    //5. ResultSet을 이용해서 결과 출력
				while(rs.next()) {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					String hiredate = rs.getString("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					

					
				
				
				}
				
				
				
				
				
				
				
				
				
				
				//6.close
				rs.close();
				stmt.close();
				conn.close();
				
				
				
				
				
				

				
			} catch (ClassNotFoundException  e) {
				System.out.println("드라이버 로드 실패");
						
				
				} catch (SQLException e) {
					e.printStackTrace();
				
				
	}

}
}
