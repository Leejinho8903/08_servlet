<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testJstlCore</title>
</head>
<body>
	<h1>JSTL Core Library Tag</h1>
	
	<h3>c:set 태그 - 변수 선언</h3>
	<!-- scope 속성을 생략하면 기본적으로는 pageScope에 저장 된다. -->
	<c:set var="num1" value="100" scope="session"/>
	<c:set var="num2" value="200" scope="session"/>
	
	<!-- c:set으로 선언한 변수는 스크립팅 요소에서 쓰는 것이 불가능하다. -->
	<%-- <% int sum = num1 + num2; %> --%>
	
	<c:set var="sum" value="${ num1 + num2 }"/>
	${ num1 } + ${ num2 } = ${ sum } <br>
	
	<!-- 스크립팅 요소에서 선언 된 변수는 el이나 스크립팅 요소로 사용 가능하다. -->
	<% int num3 = 10, num4 = 20; %>
	<!-- 에러는 나지 않지만 값을 가져오지 못한다. -->
	${ num3 } + ${ num4 } = ${ num3 + num4 } <br>
	<!-- el을 활용하기 위해서는 스크립팅 요소를 value로 지정한 c:set 태그가 필요하다. -->
	<c:set var="sum2" value="<%= num3 + num4 %>"/>
	num3 + num4 = ${ sum2 } <br>
	
	<h2>c:set 태그 - 배열 또는 컬렉션으로 사용할 문자열 선언</h2>
	<c:set var="colors">
		red, yellow, green, orange, blue, megenta
	</c:set>
	
	<!-- 자바스크립트에서도 EL을 사용할 수 있다. -->
	<script>
		window.onload = function() {
			const colors = '${colors}'.split(", ");
			console.log(colors);
		};
	</script>
	
	<h2>c:remove 변수 삭제</h2>
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	
	<!-- scope 미지정시 모든 scope의 동일 이름 변수를 제거한다. -->
	<c:remove var="num1" scope="session"/>
	<c:remove var="num2"/>
	
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	
	<h2>c:out - 값 출력용</h2>
	<!-- escapeXml을 false로 지정하면 출력 값의 태그를 인식하고, true로 지정하면 문자열로 인식한다. -->
	<c:out value="<h2>데이터 출력</h2>" escapeXml="false"/> <br>
	<c:out value="<h2>데이터 출력</h2>" escapeXml="true"/> <br>
	<!-- 기본 값은 true이다. -->
	<c:out value="<h2>데이터 출력</h2>" /> <br>
	<!-- EL로 가져오는 값이 없는 경우 대체할 값에 대한 default 설정 가능 -->
	<c:out value="${ param.name }" default="아무개님"/>
	
	<h2>c:if - 조건문</h2>
	
	<c:set var="value1" value="9" scope="page"/>
	<c:set var="value2" value="3" scope="page"/>
	
	<!-- test 속성에 조건식을 기술하며, 조건식은 반드시 EL 형식으로 기술해야 한다. -->
	<c:if test="${ value1 >= value2 }">
		<h3>value1이 더 큽니다.</h3>
	</c:if>
	<c:if test="${ value1 < value2 }">
		<h3>value2가 더 큽니다.</h3>
	</c:if>
	
	<h2>c:choose, c:when, c:otherwise - 조건문</h2>
	
	<c:set var="no" value="${ param.no }"/>
	
	<c:choose>
		<c:when test="${ no == 1 }">
			<h3>안녕하세요.</h3>
		</c:when>
		<c:when test="${ no eq 2 }">
			<h3>반갑습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>환영합니다.</h3>
		</c:otherwise>
	</c:choose>
	
	<h2>c:forEach - for문</h2>
	<c:forEach begin="1" end="10">
		<h3>반복 실행</h3>
	</c:forEach>
	<c:forEach var="size" begin="1" end="7" step="2">
		<font size="${ size }">글자 크기 ${ size }</font>
	</c:forEach>
	
	<h2>c:forEach - 배열 또는 컬렉션 연속 처리에 for-each문처럼 사용</h2>
	<!-- varStatus를 통해 상태를 관리할 수 있다.
	current : 현재 요소, index : 제로 기반 인덱스, count : 1 기반 인덱스 -->
	<c:forEach var="color" items="${ colors }" varStatus="st">
		<font color="${ color }">
			${ st.count } : 글자색 ${ color } <br>
			${ st.index }, ${ st.current } <br>
		</font>
	</c:forEach>
	
	<h2>c:forTokens - 문자열을 토큰으로 분리 처리 할 때 사용</h2>
	<ul>
		<c:forTokens items="yellow blue pink red green" delims=" " var="color">
			<li>${ color }</li>
		</c:forTokens>
	</ul>
	<ul>
		<c:forTokens items="yellow-blue*pink/red green" delims="/*- " var="color">
			<li>${ color }</li>
		</c:forTokens>
	</ul>
	
	<h2>c:url - 링크 설정 정보 별도 지정 시 사용</h2>
	<c:url var="fmtlink" value="testJstlFmt.jsp">
		<c:param name="num" value="77"/>
	</c:url>
	
	<a href='${ fmtlink }'>fmtlink 연결</a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>