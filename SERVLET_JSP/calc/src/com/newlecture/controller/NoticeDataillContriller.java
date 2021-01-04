package com.newlecture.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/netice/detail")
public class NoticeDataillContriller extends HttpServlet {
	
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
     int id = Integer.parseInt(request.getParameter("id"));
     String jdbcUrl = "jdbc:mysql://localhost:3306/opn?serverTimezone=UTC";
	 String user = "aia";
	 String password = "aia";
     String sql = "SELECT * FROM NOTICE WHERE ID=?";
    
    try {
		Class.forName("oracle.jdbc.driver.OrcleDriver");
	
    Connection con;
	
		con = DriverManager.getConnection(jdbcUrl, user, password);
	
    PreparedStatement st = con.prepareStatement(sql);
    st.setInt(1, id);
    
    ResultSet rs = st.executeQuery(sql);
    rs.next();
    String title = rs.getString("TITLE");
    String writerId  = rs.getString("WRITER_ID"); 
    Date regdate = rs.getDate("REGDATE"); 
    String hit = rs.getString("HIT"); 
    String files = rs.getString("FILES") ;
    String content = rs.getString("CONTENT");
    
    request.setAttribute("title", title);
    request.setAttribute("writerId", writerId);
    request.setAttribute("regdate", regdate);
    request.setAttribute("hit", hit);
    request.setAttribute("files", files);
    request.setAttribute("content", content);
	
    
    rs.close();
    st.close();
    con.close();
 } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //redirect 아예 다른 페이지로 보내는 방법
    
    //foraward  작업을 이어받는 방법
    request
    .getRequestDispatcher("/notice/detail.jsp")
    .forward(request, response); //detail.jsp에서도 사용 
 }
}

