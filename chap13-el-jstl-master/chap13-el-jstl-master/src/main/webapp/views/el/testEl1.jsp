<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testEl1</title>
</head>
<body>
	<h1>전달 된 request 객체에서 저장 된 정보 출력하기</h1>
<%-- 	<%
		String name = (String) request.getAttribute("name");
		int age = (Integer) request.getAttribute("age");
		String phone = (String) request.getAttribute("phone");
	%>
	
	name : <%= name %>
	age : <%= age %>
	phone : <%= phone %> --%>
	
	<h3>EL 표현식으로 출력하기</h3>
	name : ${ requestScope.name }
	age : ${ requestScope.age }
	phone : ${ requestScope.phone }
	
	<h3>스코프 범위 생략하여 출력하기</h3>
	name : ${ name }
	age : ${ age }
	phone : ${ phone }
	
	<h3>items 이름으로 저장 된 리스트 정보 출력하기</h3>
	
	0 : ${ requestScope.items[0] }
	1 : ${ requestScope.items[1] }
	2 : ${ requestScope.items[2] }
	
	0 : ${ items[0] }
	1 : ${ items[1] }
	2 : ${ items[2] }
		
</body>
</html>








