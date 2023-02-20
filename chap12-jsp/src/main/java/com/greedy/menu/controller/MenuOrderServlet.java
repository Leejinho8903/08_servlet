package com.greedy.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 1. 요청 받은 값 확인 및 검증 */
		request.setCharacterEncoding("UTF-8");
		
		String menuName = request.getParameter("menuName");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		/* 2. 비즈니스 로직 처리
		 * 비즈니스 로직은 대부분 DB에 CRUD 연산을 이용해 이루어지게 되는데 여기서는 간단한 처리만 해보자. */
		int orderPrice = 0;
		
		switch(menuName) {
		case "햄버거" : orderPrice = 6000 * amount; break;
		case "짜장면" : orderPrice = 7000 * amount; break;
		case "짬뽕" : orderPrice = 8000 * amount; break;
		case "순대국" : orderPrice = 9000 * amount; break;
		}
		
		/* 3. 응답 페이지를 생성 후 응답한다. 
		 * 직접 페이지를 생성한 뒤 스트림으로 내보내기를 할 수도 있지만
		 * 페이지 작성이 간결하고 응답을 보여주는 역할에 대해서 구분하여 응답 페이지만 전용으로 처리하는 JSP로
		 * request에 값을 담은 다음 forward 해서 화면에 출력해본다.
		 * */
		
		request.setAttribute("menuName", menuName);
		request.setAttribute("amount", amount);
		request.setAttribute("orderPrice", orderPrice);
		
		/* JSP로 forward */
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
	}

}
