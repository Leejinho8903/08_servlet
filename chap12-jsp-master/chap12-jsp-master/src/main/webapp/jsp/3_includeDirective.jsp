<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_includeDirective</title>
</head>
<body>

	<h1>include directive</h1>
	<div>
		<%-- include 지시자 태그를 이용하여 file 속성에 jsp 경로를 지정해주면 해당 jsp에 작성한 내용을
		그대로 포함시켜 현재 jsp 파일을 동작 시킨다. --%>
		<%@ include file="today.jsp" %>
	</div>
	
	<%
		// today.jsp 파일에서 사용한 변수와 동일한 변수를 사용하면 컴파일 에러가 발생한다.
		// String output = "";
	%>
</body>
</html>









