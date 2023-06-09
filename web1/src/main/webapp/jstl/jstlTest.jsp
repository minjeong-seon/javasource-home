<%@page import="java.util.List"%>
<%@page import="user.domain.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(5<10){
		out.print("<h3>자바코드 : 5는 10보다 작다</h3>");
	}
%>
<!-- ↑ 자바코드로 작성 시  ↓ EL로 작성 시 -->
<!-- 단, jstl if에는 else 개념 없음 -->

<c:if test="${5 < 10 }">
	<h3>jstl if: 5는 10보다 작다</h3>
</c:if>

<c:if test="${6 + 3 == 9 }">
	<h3>6 + 3 = 9 </h3>
</c:if>


<!-- jstl로 if~else 사용하려면 choose ~ when ~ otherwise -->
<c:choose>
	<c:when test="${5+10==50 }">
		<h3>5+10=50이다.</h3>
	</c:when>
	<c:otherwise>
		<h3>5+10=50이 아니다.</h3>
	</c:otherwise>
</c:choose>

<%-- var: 변수명(마음대로), items : setAttribute() 에서 사용했던 이름 --%>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
	</tr>
	<c:forEach var="dto" items="${loginDTO}">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.pwd}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>










