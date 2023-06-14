<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 출력창</title>
</head>
<body>
	<h1>시험점수 <%=score %>점</h1>
	<%
	if (score < 0 || score > 100){
	%>	
	<h1>점수를 올바르게 입력 하세요!</h1>
	<%
	} else if(score >= 90){
	%>
	<h1>A학점 입니다.</h1>
	<%
	} else if(score >= 80 && score < 90 ){
	%>
	<h1>B학점 입니다.</h1>
	<%
	} else if(score >= 70 && score < 80 ){
	%>
	<h1>C학점 입니다.</h1>
	<%
	} else if(score >= 60 && score < 70 ){
	%>
	<h1>D학점 입니다.</h1>
	<%
	} else {
	%>
	<h1>F학점 입니다.</h1>
	<%
	}
	%>
</body>
</html>