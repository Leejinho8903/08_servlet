package com.greedy.section02.formdata;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* GET 방식의 요청은 request의 header를 통해 데이터를 전달하고 body는 아무런 데이터를 담지 않기 때문에
		 * 따로 읽지 않는다. (처리 속도 빠름 - 주로 조회 동작 시 사용 된다) 
		 * POST 방식의 요청은 request의 body를 통해 데이터를 전달하고 url에 데이터가 노출 되지 않으며 데이터 길이에
		 * 제한이 없다. (주로 데이터 저장, 수정 등의 동작 시 사용 된다.)
		 * */
		
		/* GET 방식의 데이터는 HTML charset에 기술 된 인코딩 방식으로 브라우저가 한글을 이해한 뒤 URLEncoder를
		 * 이용하여 반환하고 url 요청으로 전송한다. 따라서 헤더의 내용은 알맞게 해석되므로 별도의 charset 설정이 불필요하다. 
		 * 
		 * POST 방식의 요청은 body에 담아서 전송하는데 해더와는 별개로 URLEncoder를 이용하지 않고 데이터를 전송한다. 
		 * charset을 별도로 설정하지 않았을 경우 null이 반환되는데 기본 값은 ISO-8859-1 방식으로 되어 있어
		 * 한글 값이 깨지는 현상이 발생한다.*/
		
		System.out.println(request.getCharacterEncoding());
		
		/* 파라미터 값을 꺼내기 전에 디코딩할 인코딩 방식을 지정해주면 해당 방식으로 body의 값을 해석한다. */
		request.setCharacterEncoding("UTF-8");
		
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
		
		/* getParameter, getParameterValues 외의 파라미터 값을 확인할 수 있는 메소드 테스트 */
		
		/* 모든 데이터의 key를 이용하여 전송 된 값을 일괄 처리하는 방법 */
		Map<String, String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			String[] value = requestMap.get(key);
			
			System.out.println("key : " + key);
			for(String val : value) {
				System.out.println("value : " + val);
			}
		}
		
		/* 파라미터로 전달 된 키 목록만 반환 받을 수 있다. */
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
