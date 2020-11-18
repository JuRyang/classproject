package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Connection conn = null;
		
		try {
			//1.드라이브 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Load !!!");
			
			//2.DB연결 
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("데이터 접속");
			
			// 3.Statement 인스턴스 생성: SQL명령 저장 후 접속된 DBMS 서버에 전달
			Statement stmt = conn.createStatement();
		

		    System.out.printf("EMPNO:");
		    int empno = sc.nextInt();
		    sc.nextLine();
		    System.out.println("ENAME:");
		    String ename = sc.nextLine();
		    System.out.println("JOB:");
		    String job = sc.nextLine();
		    System.out.println("MGR:");
		    String mgr = sc.nextLine();
		    System.out.println("HIREDATE:");
		    String hiredate = sc.nextLine();
		    System.out.println("SAL:");
		    int sal = sc.nextInt();
		    System.out.println("COMM:");
		    int comm = sc.nextInt();
			
			 //PreparedStatement 인스턴스 생성: sql 먼저 등록하고 사용한다.
			String sqlInsert = "insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM ) values(?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1,empno);
			pstmt.setString(2,ename);
			pstmt.setString(3,job);
			pstmt.setString(4,mgr);
			pstmt.setString(5,hiredate);
			pstmt.setInt(6,sal);
			pstmt.setInt(7,comm);
			
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt>0) {
				System.out.println("데이터가 정상적으로 입력");
			}else {
				System.out.println("데이터가 입력되지않았음");
			}
			
			   System.out.println("모든 사원 정보 출력.");
			   String searchEname = sc.nextLine();
			   
			   //정보 리스트
			   String sqlSelect = "select * from emp ";
			   pstmt = conn.prepareStatement(sqlSelect);
			   
			   ResultSet rs = pstmt.executeQuery();
			   
			   if(!rs.next()) {
				   System.out.println("검색의 결과가 없습니다.");
			   } else {
				  do{
					   System.out.print(rs.getInt(1)+"\t");
					   System.out.print(rs.getString(2)+"\t");
					   System.out.print(rs.getString(3)+"\n");
					   System.out.print(rs.getString(4)+"\n");
					   System.out.print(rs.getString(5)+"\n");
					   System.out.print(rs.getInt(6)+"\t");
					   System.out.print(rs.getInt(7)+"\t");
				   }while (rs.next());
			   }
			   
			   
			rs.close();
			pstmt.close();
			conn.close();
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패 ");
		
		} catch (SQLException e) {
			e.printStackTrace();
		
			
			
		
	}
}
}
