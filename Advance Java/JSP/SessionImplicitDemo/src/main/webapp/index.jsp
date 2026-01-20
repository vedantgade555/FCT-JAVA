<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("uname");
	out.println("Welcome "+name);
	
	String data = "admin";
	
	session.setAttribute("user", data);
	
	
%><br>
<a href="welcome.jsp">welcome.jsp</a>
</body>
</html>