<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testEl2</title>
</head>
<body>
	
	<h1>request 객체에 저장 된 Member 객체 필드 값 출력하기</h1>
	<!-- 사용하는 객체의 필드명으로 접근하지만 내부적으로는 getter 메소드를 호출하는 것이기 때문에
	객체에 getter 메소드가 반드시 구현 되어 있어야 한다. -->
	이름 : ${ requestScope.member.name }
	나이 : ${ requestScope.member.age }
	전화번호 : ${ requestScope.member.phone }
	이메일 : ${ requestScope.member.email }
	
	<br>
	
	이름 : ${ member.name }
	나이 : ${ member.age }
	전화번호 : ${ member.phone }
	이메일 : ${ member.email }
	
	
</body>
</html>


