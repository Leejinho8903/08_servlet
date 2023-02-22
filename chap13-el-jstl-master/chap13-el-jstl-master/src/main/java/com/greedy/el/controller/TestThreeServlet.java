package com.greedy.el.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.el.model.dto.MemberDTO;


@WebServlet("/test3")
public class TestThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO requestMember = new MemberDTO("유관순", 16, "010-9876-5432", "yoo123@greedy.com");
		MemberDTO sessionMember = new MemberDTO("홍길동", 20, "010-1234-5678", "hong123@greedy.com");
		
		request.setAttribute("member", requestMember);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", sessionMember);
		
		request.getRequestDispatcher("views/el/testEl3.jsp").forward(request, response);
		
	}

}






