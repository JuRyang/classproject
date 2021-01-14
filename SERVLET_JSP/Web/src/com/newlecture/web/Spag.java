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

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) 
					throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")){
			num = Integer.parseInt(num_);
		}
		
		String result;
		if(num % 2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		// request 저장소를 통해 전달
		request.setAttribute("result", result);
		
		/*
		 * String[] names = {"newlec","dragon"}; request.setAttribute("names", names);
		 * 
		 * Map<String,Object> notice = new HashMap<String,Object>(); notice.put("id",1);
		 * notice.put("title","el은 좋음"); request.setAttribute("notice", notice);
		 */
		
		// 배열 전달
				String[] names = {"newlec", "dragon"};
				request.setAttribute("names", names);
				
				// Map 전달
				Map<String, Object> notice = new HashMap<>();
				notice.put("id", 1);
				notice.put("title", "EL GOOD");
				request.setAttribute("notice", notice);
		
		// Forward - 동일한 디렉토리 내 있기에 경로 지정 안함
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("spag.jsp");
		dispatcher.forward(request, response);
	}
}