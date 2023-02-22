<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAction</title>
</head>
<body>
	<%-- <%@ include file="common.jsp" %> --%>
	<!-- JSP Action 태그의 경우 여닫는 태그를 반드시 작성해야 한다. -->
	<jsp:include page="common.jsp"/>  
	
	<jsp:forward page="testForward.jsp"/>

</body>
</html>