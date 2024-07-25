<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
<h1>loginForm.jsp</h1>

<c:url value="j_spring_security_check" var="loginUrl"/>
<form action="${loginUrl}" method="post">
	<c:if test="${ param.error != null }">
	<p>
		Login Error! <br/>
		${ error_message }
	</p>
	</c:if>
	ID : <input type="text" name="j_username" value="${ username }"> <br/>
	PW : <input type="text" name="j_password"> <br/>
	<input type="submit" value="LOGIN"> <br/>
</form>
</body>
</html>