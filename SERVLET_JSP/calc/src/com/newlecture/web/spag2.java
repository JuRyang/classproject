package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag2")
public class spag2 extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")){
			num = Integer.parseInt(num_);
		}
		
		String result;
		
		 if(num % 2 !=0){ 
	        result="홀수";
	     } else {
	       result="짝수";
	       
	       request.setAttribute("result", result);
	       
	       String[] names= {"a","b"};
	       request.setAttribute("names",names);
	       
	       Map<String, Object> notice = new HashMap<String, Object>();
	       notice.put("id",1);
	       notice.put("title","답답하당");
	       request.setAttribute("notice",notice);
	       
	       
	       //redirect 새로요청
	       //forward   일을 이어가는 것 
	       RequestDispatcher dispatcher = request.getRequestDispatcher("spag2.jsp");
	       dispatcher.forward(request, response); //짝수인지 홀수 인지 넘겨주는 저장소는 request
	     } 
	}

	
}
