<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   isELIgnored="false" 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="result.jsp">
 	아이디 : <input type="text" size="20"/><br>
 	아이디 : <input type="password" size="20"/><br>
 	<input type="submit" value="로그인"/><input type="reset" value="다시입력"/>
 </form>
<br><br><br>
<%-- <a href="hrrp://localhost:8090/pro14/test01/memberForm.jsp" >회원가입하기</a> --%> 
<%--   <a href="<%=request.getContextPath() %>/test01/memberForm.jsp">회원가입하기</a>     
     --%>

<a href="${pageContext.request.contextPath}/test01/memberForm.jsp">회원가입하기</a> 

</body>
</html>