<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>TEST JSP</title>
</head>
<body>
	<h1>테스트 화면입니다.</h1>
	<!-- /hit/test/b.do?x=값 이런 식으로 전송 된다. -->
	<form action="/hit/test/b.do">
		<input type="text" name="x" />
		<input type="text" name="y" />
		<input type="submit" />
	</form>
</body>
</html>