package com.greedy.section01.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		/* 1. 쿠키를 생성한다. */
		Cookie firstNameCookie = new Cookie("firstName", firstName);
		Cookie lastNameCookie = new Cookie("lastName", lastName);
		
		/* 2. 쿠기의 만료 시간을 설정한다. 
		 * 	  초 단위로 설정하며 하루를 만료시간으로 두고 싶다면 60 * 60 * 24 */
		firstNameCookie.setMaxAge(60 * 60 * 24);
		lastNameCookie.setMaxAge(60 * 60 * 24);
		
		/* 3. 응답 헤더에 쿠키를 담는다. */
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		
		/* redirect는 url을 재작성하여 url을 이용해 요청하는 방식이기 떄문에 GET 방식의 요청이다. */
		response.sendRedirect("redirect");
 		
		
	}

}
