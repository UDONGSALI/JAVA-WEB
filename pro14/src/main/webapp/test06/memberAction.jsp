<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec02.ex01.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex01.MemberBean" />
<jsp:setProperty property="*" name="m" />
<%
MemberDAO memberDAO = new MemberDAO();
memberDAO.addMember(m);
List memberList = memberDAO.listMembers();
request.setAttribute("memberList", memberList);
%>
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="membersList.jsp" />
</body>
</html>