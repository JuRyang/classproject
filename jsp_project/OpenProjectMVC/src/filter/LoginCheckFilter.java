package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public  class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
			             ServletResponse response, 
			             FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginCheckFilter 실행");
		
		//로그인이 여부확인하는 Filter
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		//boolean loiginCheck  = false;
		
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			chain.doFilter(request, response); //정상실행
		}else {
			                                  //보내줘야 하는 경로
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginForm.jsp");
			dispatcher.forward(request, response); //정상 실행 되지않고 경로 변경 
		}
	
		

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
