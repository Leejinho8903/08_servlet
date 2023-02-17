package com.greedy.section01.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* forward 된 서블릿에서도 요청 방식이 GET이면 doGet, POST면 doPost를 호출한다. */
		
		/* request에 이전 서블릿에서 전달하고자 하는 정보를 담았기 때문에 다시 꺼내온다. */
		String nickname = (String)request.getAttribute("nickname");
		System.out.println("forward 확인 : " + nickname);
		
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html?>\n").append("<html>\n").append("<head>\n")
				 .append("</head>\n").append("<body>\n").append("<h1 align='center'>\n")
				 .append(nickname).append("님 환영합니다.").append("</h1>")
				 .append("</body>\n").append("</html>");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		out.flush();
		out.close();
		
		/* 변수의 기본 scope는 page 이기 떄문에 다른 서블릿으로 데이터를 공유할 수 없다
		 * forward 방식은 request, response를 전달하며 위임하므로 request에 정보를 저장하여 다른 서블릿에서도
		 * 공유 할 수 있게 된다. 
		 * forward 방식은 위임 되는 서블릿의 존재를 client가 알 필요가 없기 때문에 url 자체가 변경되지 않는다.
		 * 단, 서버로 전송한 데이터가 남아있는 상태로 새로고침(재요청)을 하게 되면 요청을 계속 반복하게 되어
		 * DB에 insert 하는 행위가 반복 되는 문제가 생길 수도 있다. 
		 * 이러한 경우에는 또 다른 페이지 전환 방식인 redirect 방식을 사용해야 한다. */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
