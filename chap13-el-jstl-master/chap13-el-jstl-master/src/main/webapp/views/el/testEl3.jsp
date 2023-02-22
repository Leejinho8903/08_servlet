<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testEl3</title>
</head>
<body>
	
	<h1>requestScope와 sessionScope 테스트</h1>
	
	<h2>requestScope 값 출력하기</h2>
	이름 : ${ requestScope.member.name }
	나이 : ${ requestScope.member.age }
	전화번호 : ${ requestScope.member.phone }
	이메일 : ${ requestScope.member.email }
	
	<h2>sessionScope 값 출력하기</h2>
	이름 : ${ sessionScope.member.name }
	나이 : ${ sessionScope.member.age }
	전화번호 : ${ sessionScope.member.phone }
	이메일 : ${ sessionScope.member.email }	
	
	<h2>스코프 우선 순위 테스트</h2>
	<!-- 
		스코프를 생략했을 경우 좁은 범위부터 탐색한다.
		pageScope => requestScope => sessionScope => applicationScope
	 -->
	이름 : ${ member.name }
	나이 : ${ member.age }
	전화번호 : ${ member.phone }
	이메일 : ${ member.email }	
</body>
</html>









