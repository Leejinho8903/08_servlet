package com.greedy.section01.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 서블릿이 하는 역할은 크게 3가지이다.
		 * 1. 요청 받기 : HTTP method 요청에 따라 parameter로 전달 받은 데이터 꺼내오기
		 * 2. 비즈니스 로직 처리 : DB 접속과 CRUD에 대한 로직 처리
		 * 3. 응답 하기 : 문자열로 동적인 웹(HTML 태그) 페이지를 만들어서 스트림을 이용해서 내보내기
		 * */
		
		String name = request.getParameter("name");
		
		/* 응답 컨텐츠 타입 설정
		 * 기본 값은 text/plain으로 되어 있지만 html 태그를 사용하면 text/html도 응답으로 수락 가능하도록
		 * 헤더 설정이 되어 있기 때문에 text/html로 인식할 수 있다.
		 * 하지만 명시적으로 text/plain이라고 설정하면 태그가 아닌 문자열로 인식하게 된다. */
		// response.setContentType("text/plain");
		response.setContentType("text/html");
		
		
		/* 응답 시 별도 인코딩 지정이 없으면 ISO-8859-1 로 처리되므로 한글 값이 깨지게 된다. */
		
		System.out.println("default response encoding : " + response.getCharacterEncoding());
		
		response.setCharacterEncoding("UTF-8");
		
		/* 참고로 위의 두 가지 설정을 한 번에 처리할 수도 있다. */
		response.setContentType("text/html; charset=UTF-8");
		
		/* 사용자 브라우저에 응답하기 위해 HttpServletResponse가 가지는 getWriter() 메소드로
		 * PrintWriter 인스턴스를 반환한다.
		 * BufferedWriter와 형제격인 클래스이지만 더 많은 형태의 생성자를 제공하고 있어서 실제로는
		 * 범용성으로 인해 더 많이 사용 된다. */
		PrintWriter out = response.getWriter();
		
		/* 문자열을 이용해서 사용자에게 내보내기 할 페이지를 작성한다. */
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<!doctype html>\n").append("<html>\n")
								.append("<head>\n").append("</head>\n")
								.append("<body>\n").append("<h1>안녕~ " + name + "</h1>\n")
								.append("</body>\n").append("</html>");
		
		/* 스트림을 이용해 내보내기 */ 
		out.print(responseBuilder.toString());
		
		/* 버퍼에 잔류한 데이터를 강제로 내보낸다. */
		out.flush();
		
		/* 스트림을 닫아준다. */
		out.close();
		
		
		
		
		
		
		
	}

}







