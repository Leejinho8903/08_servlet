package com.greedy.section01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceivelnformationServlet
 */
@WebServlet("/forward")
public class ReceivelnformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		/* 요청 정보를 받고 비즈니스 로직까지 성공햇다는 가정하에 조회 된 닉네임을 넣어
		 * "OOO님 환영합니다." 라는 메세지를 보여주는 화면을 응답한다. 
		 * 화면 응답에 대한 로직은 다른 서블릿으로 분리한다. */
		
		String nickname = "그리디";
		
		/* PrintLoginSuccessServlet으로 처리를 위임하기 위해서는 RequestDispatcher 인스턴스 생성 후 
		 * forward 메소드를 이용해서 요청과 응답에 대한 객체를 전달한다.
		 * 이 때 다른 서블릿으로 넘길 데이터는 request의 setAttribute 메소드로 설정하고
		 * 받는 쪽에서는 getAttribute 메소드를 통해 꺼낸다. */
		
		request.setAttribute("nickname", nickname);
		
		RequestDispatcher rd = request.getRequestDispatcher("print");
		rd.forward(request, response);
	}

}
