<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String name = "이순신";

	public String getName() {
		return name;
	}%>
<%
String age = request.getParameter("age");
String tel = request.getParameter("tel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		안녕하세요
		<%=name%>님!!
	</h1>
	<h1>
		나이는
		<%= age%>살입니다!!
	</h1>
	<h1>
		나이+10은
		<%= Integer.parseInt(age)+10%>살입니다!!
	</h1>
	<h1>
		전화번호는
		<%=tel%>입니다!!
	</h1>
	<h1>
		키는
		<%=180%>cm 입니다!!
	</h1>
</body>
</html>