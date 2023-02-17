package com.greedy.section01.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
	
		/* null 값으로 출력 되는 것을 통해 이전 Servlet과 request 객체가 공유 되지 않음을 확인할 수 있다*/
		
		/* 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내 온다. */
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			/* 2. cookie 객체의 getName과 getValue를 이용해 담긴 값을 꺼내온다. */
			System.out.println("[cookie] " + cookie.getName() + " : " + cookie.getValue());
			
			if("firstName".equals(cookie.getName())) {
				firstName = cookie.getValue();
			} else if("lastName".equals(cookie.getName())) {
				lastName = cookie.getValue();
			}
			
		}
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html?>\n").append("<html>\n").append("<head>\n")
				 .append("</head>\n").append("<body>\n").append("<h1 align='center'>")
				 .append("Your firstName is ").append(firstName)
				 .append(" and lastName is ").append(lastName)
				 .append("</h1>").append("</body>\n").append("</html>");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		out.flush();
		out.close();
		
		/* 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장 된다.
		 * 다른 사용자가 함께 사용하는 컴퓨터인 경우 쿠키에 민감한 개인 정보를 담기에는 보안이 취약해지는 문제가 있다.
		 * 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다 세션을 이용하게 된다.
		 * 세션은 쿠키와 유사한 형태로 key=value 쌍으로 저장 되지만 서버에서 관리 되기 때문에 보안에 더 우수하다. 
		 * */
	}

}
