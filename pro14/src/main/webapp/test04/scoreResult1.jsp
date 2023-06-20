<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정수 입력 페이지</title>
</head>
<body>
	<c:set var="score" value="${param.score}" />
	<h1>
		시험점수
		<c:out value="${score}" />
	</h1>
	<br>
	<c:choose>
		<c:when test="${score >= 0 && score <= 100 && not empty score}">
			<c:choose>
				<c:when test="${score >= 90 && score <= 100}">
					<h1>A 학점입니다.</h1>
				</c:when>
				<c:when test="${score >= 80 && score < 90}">
					<h1>B 학점입니다.</h1>
				</c:when>
				<c:when test="${score >= 70 && score < 80}">
					<h1>C 학점입니다.</h1>
				</c:when>
				<c:when test="${score >= 60 && score < 70}">
					<h1>D 학점입니다.</h1>
				</c:when>
				<c:otherwise>
					<h1>F 학점입니다.</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h1>다시 입력해 주세요</h1>
			<a href="scoreTest.jsp">점수 창으로 이동</a>
		</c:otherwise>
	</c:choose>


</body>
</html>