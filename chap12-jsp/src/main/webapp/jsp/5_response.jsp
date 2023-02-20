<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5_response</title>
</head>
<body>

<% 
	// request에 setAttribute로 담은 값을 getAttribute로 꺼낼 수 있다.
	String menuName = (String)request.getAttribute("menuName");
	int amount = (Integer)request.getAttribute("amount");
	int orderPrice = (Integer)request.getAttribute("orderPrice");
%>
<h1>주문하신 음식 : <%= menuName %></h1>
<h3>주문하신 수량 : <%= amount %></h3>
<h3>결제하실 최종 금액 : <%= orderPrice %></h3>

</body>
</html>