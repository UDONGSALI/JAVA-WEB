<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberDAO"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m" property="*" />

<%
MemberDAO memberDAO = new MemberDAO();
memberDAO.addMember(m);
List membersList = memberDAO.listMembers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align ="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>		
	<%
		if(membersList.size() ==0){
	%>
		<tr>
			<td colspan="5">
				<p align="center"><b><span style="font-size: 9pt">
				등록된 회원이 없습니다.
				</span> </b></p>
			</td>
		</tr>
	<%
		}else{
			for( int i =0; i < membersList.size(); i ++){
				m = (MemberBean) membersList.get(i);
				System.out.println(i + "번째 아이디" +m.getId());
	%>
		<tr align="center">
			<td>
					<jsp:getProperty property="id" name="m"/>
			</td>
			<td>
					<jsp:getProperty property="pwd" name="m"/>
			</td>
			<td>
					<jsp:getProperty property="name" name="m"/>
			</td>
			<td>
					<jsp:getProperty property="email" name="m"/>
			</td>
		</tr>
		<%
			}
		}		
		%>
	</table>

</body>
</html>