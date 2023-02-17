package com.greedy.section01.querystring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* HttpServlet 클래스의 service 메소드가 요청 방식에 의해 GET 요청을 doGet() 
		 * POST 요청은 doPost() 메소드를 호출해준다. 호출 시 request, response 객체도 전달해준다. 
		 * 
		 * HttpServletRequest 객체의 getParameter() 메소드를 통해 전달 받은 값을 추출할 수 있다.
		 * 이 때 input 태그에 name 속성으로 지정한 값으로 넘어오므로 메소드의 인자로 해당 값을 문자열 형태로 전달한다. 
		 * form 태그 내의 모든 input 태그의 값을 HashMap 형태로 전달 받아 관리하고 있는데 그 중 원하는 값을 찾기
		 * 위해서는 key 역할을 하는 문자열이 필요하기 때문이다. 
		 * key 역할을 하는 문자열이 없을 경우 value 속성은 null로 리턴된다. */
		
		String name = request.getParameter("name");
		System.out.println("이름 : " + name);
		
		/* getParameter()는 리턴 타입이 문자열이므로 숫자 타입과 값이 필요하다면 parsing 처리 해야 한다. */
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("나이 : " + age);
		
		/* java.sql.Date 타입으로 날짜 데이터 parsing */
		java.sql.Date birthDay = java.sql.Date.valueOf(request.getParameter("birthday"));
		System.out.println("생일 : " + birthDay);
		
		/* radio로 전달 된 값은 여러 값 중 한 가지만 전달 되기 때문에 parameter로 전달 받은 값을 꺼내기만 하면 된다. */
		String gender = request.getParameter("gender");
		System.out.println("성별 : " + gender);
		
		/* select box를 이용한 방식도 크게 다르지 않다. */
		String national = request.getParameter("national");
		System.out.println("국적 : " + national);
		
		/* checkbox는 다중 입력 될 수 있기 때문에 선택 된 값이 문자열 배열로 전달 된다. 
		 * getParameterValues() 메소드를 이용한다.
		 * */
		
		String[] hobbies = request.getParameterValues("hobbies");
		for(String hobby : hobbies) {
			System.out.println("취미 : " + hobby);			
		}
		
		
	}
	

}
