<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	out.println("MyBatis 사용하기 : Hello world");
%>

<br>

<c:forEach var="dto" items="${ employees }">
	${dto.ename1}/ ${ dto.dno1 }/ ${ dto.dname1 } <br/>
</c:forEach>
</body>
</html>