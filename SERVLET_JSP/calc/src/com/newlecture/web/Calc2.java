package com.newlecture.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request
			, HttpServletResponse response) 
					throws ServletException, IOException {
		// Application 저장소 선언
		ServletContext application = request.getServletContext();
		
		// Session 선언
		HttpSession session = request.getSession();
		
		// Cookie 선언
		Cookie[] cookies = request.getCookies();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String value_ = request.getParameter("value");
		String op = request.getParameter("operator");
		
		int value = 0;
				
		if(!value_.equals("")) value = Integer.parseInt(value_);
		
		// 계산
		if(op.equals("=")) {

			int x = 0;
			
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = value;

			String operator = "";
			
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;					
			} else {
				result = x - y;
			}
			
			response.getWriter().printf("결과 값 : %d\n", result);
			
		} else { // 값 저장	
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("op", op);
			
			// path 설정
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			
			// maxAge 설정 - 24시간 유지(만료날짜)
			valueCookie.setMaxAge(24 * 60 * 60);
			opCookie.setMaxAge(24 * 60 * 60);
			
			response.addCookie(valueCookie); //클라이언트로 넘겨주는거
			response.addCookie(opCookie);
			
			response.sendRedirect("calc2.html");
		}
	}
}