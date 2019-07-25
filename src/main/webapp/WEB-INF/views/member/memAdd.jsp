<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="${pageContext.request.contextPath}/member/add.do" method="post">
		아이디 : <input type="text" name="memId" /> 
		비밀번호 : <input type="text" name="memPass" /> 
		이름 : <input type="text" name="memName" /> 
		포인트 : <input type="text" name="memPoint" />
		<input type="submit" value="전송"/> 
	</form>
</body>
</html>