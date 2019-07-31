<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/comm/menu.jsp" %> 
	
	<h1>회원정보수정</h1>
	<form action="${pageContext.request.contextPath}/member/edit.do" method="post">
		아이디 : <input type="text" name="memId" value="${memberVo.memId}" readonly="readonly"/> 
		이름 : <input type="text" name="memName" value="${memberVo.memName}" /> 
		포인트 : <input type="text" name="memPoint" value="${memberVo.memPoint}" />
		<input type="submit" value="수정"/>
		<a href="${pageContext.request.contextPath}/member/del.do?memId=${memberVo.memId}"><input type="button" value="삭제" /></a>
		<a href="${pageContext.request.contextPath}/member/list.do"><input type="button" value="목록으로 이동" /></a>
	</form>
</body>
</html>