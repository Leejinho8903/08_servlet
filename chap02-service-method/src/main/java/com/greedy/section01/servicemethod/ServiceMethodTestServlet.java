package com.greedy.section01.servicemethod;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP 메소드 판단 
		String method = request.getMethod();
		System.out.println("http method : "  + method);
		
		if("GET".equals(method)) {
			doGet(request, response);
		} else if("POST".equals(method)) {
			doPost(request, response);
		}
	}
*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청을 처리할 메소드 호출 됨...");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청을 처리할 메소드 호출 됨...");
		
	}

}
