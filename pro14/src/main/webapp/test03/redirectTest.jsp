<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리다이렉트 페이지</title>
</head>
<body>
	<c:redirect url="/test01/member1.jsp">
	<c:param name="id" value="${'hong'}"/>
	<c:param name="pwd" value="${1234}"/>
	<c:param name="name" value="${'홍길동'}"/>
	<c:param name="email" value="${'hong@naver.com'}"/>
</c:redirect>
</body>
</html>
</html>