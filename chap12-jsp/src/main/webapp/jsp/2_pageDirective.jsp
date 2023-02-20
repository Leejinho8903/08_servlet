<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.ArrayList" errorPage="errorPage.jsp"%>
   <%--
   		page 지시자 태그에서 사용 가능한 속성은 많지만, 현재 알고 있어야 하는 속성은 많지 않다.
   		- import : java.lang 패키지 외의 클래스를 현 jsp 파일에서 사용할 때 import 속성에 정의하면 
   				   import 선언부를 작성하는 것과 같다.
   		- errorPage : 현재 페이지에서 Exception이 발생하게 되면 속성 값에 설정한 JSP 경로로 exception을 던진다.
   		- isErrorPage : 현재 페이지가 Exception을 처리할 페이지인 경우 true로 지정한다. 기본 값은 false이다.
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2_pageDirective</title>
</head>
<body>
<%
	Date date = new Date();
	System.out.println(date);
	
	ArrayList<String> list = new ArrayList<>();
%>

<% 
	// exception을 발생 시키는 코드 작성
	String str = "hello";
	char ch = str.charAt(5);
%>
</body>
</html>