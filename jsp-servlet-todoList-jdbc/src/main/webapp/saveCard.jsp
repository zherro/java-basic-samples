<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h2>Welcome, this is a to do list!</h2>
	</header>
	
	<%= request.getParameter("title") %>
	<%= request.getParameter("description") %>
	<%= request.getParameter("date") %>
	
</body>
</html>