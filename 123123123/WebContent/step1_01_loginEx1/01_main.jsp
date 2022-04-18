<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:if test="${id ne null }">
			${id }님 환영합니다.
			<p>입사지원정보 수정</p>
			<p>로그아웃</p>
			<p>회원탈퇴</p>
		</c:if>
		
		<c:if test="${id eq null }">
			<p><a href="join">회원가입</a></p>
			<p><a href="login">로그인></a></p>
		</c:if>
	</div>
	
	<div align="center">
		<img src="img/applyonline.png" alt="입사지원하기">
	</div>
</body>
</html>