package com.newlecture.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String[] num_=request.getParameterValues("num"); //여러가지 값을 받게될 경우에는getParameterValues
		
		int result =0;
		
		for(int i=0; i<num_.length; i++ ) {
			int num = Integer.parseInt(num_[i]); //연산은 반복적이지만 선언은 반복되지않음
		   result+=num;
		}
		
		
		
		response.getWriter().printf("result is %d\n", result);
	}

}
