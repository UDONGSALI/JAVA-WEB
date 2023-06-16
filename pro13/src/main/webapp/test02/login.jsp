<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	boolean a = Boolean.parseBoolean(request.getParameter("a"));
	System.out.print("불러온 a " +  a);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>

	<%
		System.out.print(a);
	%>
	<%
		if(a == true){
	%>
	<h1>아이디를 입력하지 않았습니다. 어이디를 입력해 주세요.</h1>	
	<%
	}else{
		a = true;
		
	}
	%>

<form action="result.jsp" method="post">
	아이디 : <input type="text" name="user_ID"><br>	
	비밀번호 : <input type="password" name="user_PW"><br>
	<input type="submit" value="로그인">
	<input type="reset" value="다시 입력">
</form>


</body>
</html>