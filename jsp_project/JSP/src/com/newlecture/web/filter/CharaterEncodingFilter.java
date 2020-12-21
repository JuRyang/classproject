package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public  class CharaterEncodingFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, 
			             ServletResponse response, 
			             FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		//System.out.println("before filter");//요청이 오면 실행됨
		chain.doFilter(request, response); //흐름을 넘기는 것 ??다음 실행을 관할 하는 구간,다음 실행을 정할 수 있음
         //System.out.println("after filter");
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
