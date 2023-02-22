<!-- 1. 페이지 지시자 태그
	    페이지에 대한 설정을 하는 태그로 현재 페이지에 스크립틀릿 태그를 이용하여 작성하는 문법은 자바라는 의미이며,
	    response header에 응답을 위한 설정을 하는 것도 가능하다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_simpleJspState</title>
</head>
<body>

	<h1>simpleJspState</h1>
	<p>
		JSP는 표면상으로는 HTML 문서와 유사하지만 JSP 컨테이너가 최초 JSP를 요청할 시 JSP를 서블릿으로 변환 시킨 뒤,
		서블릿 컨테이너가 변환 된 서블릿을 이용해 인스턴스를 생성하고 호출한다. 
		JSP는 매 요청마다 기존 JSP 파일이 변환 되었는지 확인하여 변경이 없는 경우 기존 인스턴스를 사용하고,
		변경이 있는 경우 translate 과정을 거쳐 인스턴스를 다시 생성한다.
	</p>
	<p>
		JSP는 HTML 기반의 문서에 Java 문법을 사용할 수 있도록 지원한다. 
		JSP의 태그 엘리먼트를 이용하여 사용 목적 별로 자바 코드를 사용할 수 있도록 한다.
		directive, declare, scriptlet, expression, comment가 있다. 
	</p>
	
	<!-- 2. JSP 주석 태그 -->
	<%-- HTML 주석은 클라이언트에게 노출 되지만 JSP 주석은 클라이언트에게 노출 되지 않는다. --%>
	
	<!-- 3. 선언 태그
		    서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언해준다. -->
	<%!
		private String name;
		private int age;
	%>
	
	<!-- 4. 스크립틀릿 태그 -->
	<%
		/* 간단한 자바 코드를 작성할 수 있는 부분이다.
		   자바의 주석과 동일하게 사용할 수 있다. 
		   선언한 태그 내에서 작성한 내용을 초기화하고 출력할 수도 있고, 간단한 로직 처리도 가능하다.
		*/
		name = "홍길동";
		age = 20;
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		for(int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
	
	%>
	
	<!-- 5. expression 태그 
		 PrintWriter를 이용하여 브라우저에 값을 내보내기 하여 브라우저에 보여지게 한다. -->
	name : <%= name %> <br>
	age : <%= age %> 
	
</body>
</html>



