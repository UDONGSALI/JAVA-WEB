<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function() {
		$("#checkJson").click(function() {
			/* 짭 제이슨 */
			var member = {
				id : "park",
				name : "박지성",
				pwd : "1234",
				email : "park@test.com"
			};
			$.ajax({
				type : "post",
				url : "${contextPath}/test/info",
				contentType : "application/json"
				/* 짭 제이슨이라서 변환을 해야 함 */,
				data : JSON.stringify(member),
				success : function(data, textStatus) {
				},
				error : function(data, textStatus) {
					alert("에러가 발생했습니다.");
				},
				complete : function(data, textStatus) {
				}
			}); //end ajax	
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="회원 정보 보내기" />
	<br>
	<br>
	<div id="output"></div>
</body>
</html>