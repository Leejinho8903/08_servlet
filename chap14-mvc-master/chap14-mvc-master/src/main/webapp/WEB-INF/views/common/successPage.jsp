<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = '${ successCode }';
			
			let successMessage = '';
			let movePath = '';
			
			switch(successCode) {
			case 'insertEmp' :
				successMessage = '신규 직원 등록이 완료 되었습니다.';
				movePath = '${ pageContext.servletContext.contextPath }';
				break;
			case 'updateEmp' : 
				successMessage = '직원 퇴사 처리가 완료 되었습니다.';
				movePath = '${pageContext.servletContext.contextPath}';
				break;
			case 'deleteEmp' : 
				successMessage = '직원 정보 삭제가 완료 되었습니다.';
				movePath = '${pageContext.servletContext.contextPath}';
				break;
			}
			
			alert(successMessage);
			location.href = movePath;
			
		})();
	
	</script>
</body>
</html>