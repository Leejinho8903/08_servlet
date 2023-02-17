package com.greedy.section01.othercite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/othercite")
public class OtherCiteRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 후 naver 사이트로 redirect");
		
		/* 브라우저의 개발자 도구 network 탭에서 확인하면 302 status code와 함께 location에 기재 된
		 * naver 사이트로 이동하는 것을 볼 수 있다. 
		 * 사용자 url 재작성이라고도 불리는 redirect 방식은 302번 응답코드인 경우
		 * 요청에 대한 처리를 잘 햇으며 사용자의 url을 강제적으로 redirect 경로로 이동시키라는 의미이다. */
		response.sendRedirect("https://www.naver.com");
		
		
		
		
		
	}

}
