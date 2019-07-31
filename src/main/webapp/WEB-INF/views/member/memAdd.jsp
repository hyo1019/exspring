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
	
	<h1>회원가입</h1>
	<!-- 회원 가입 시 프로필 사진 파일 업로드 -->
	  <!-- 업로드를 하면 c:/temp/profile 폴더에 저장, "아이디.확장자" 로 저장 -->
	  <!-- 회원테이블의 mem_img 컬럼에 파일명을 저장 -->
	<!-- 회원 상세정보 페이지에서 프로필 사진이 출력되도록 -->
	  <!-- 사진이 없는 회원은 디폴트 이미지를 출력 https://www.flaticon.com/ 사이트 접속 profile검색 후 골라서 png 로 받으면 됨 -->
	  
	
	<form action="${pageContext.request.contextPath}/member/add.do" method="post">
		아이디 : <input type="text" name="memId" /> 
		비밀번호 : <input type="password" name="memPass" /> 
		이름 : <input type="text" name="memName" /> 
		포인트 : <input type="text" name="memPoint" />
		<input type="submit" value="전송"/> 
	</form>
	<hr />
	<a href="${pageContext.request.contextPath}/member/list.do?" >회원목록</a>
</body>
</html>