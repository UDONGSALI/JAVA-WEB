<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" import="java.util.*, test.*" %>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드창</title>

</head>
<body>
	<form action="${contextPath }/loading.do" method="post" enctype="multipart/form-data">
		 파일 1 : <input type="file" name="file1"><br>
		 파일 2 : <input type="file" name="file2"><br>
		 파라미터1 : <input type="text" name="faram1"><br>
	     파라미터2 : <input type="text" name="faram2"><br>
	     파라미터3 : <input type="text" name="faram3"><br>
	     <input type="submit" value="업로드">
	</form>
</body>
</html>
