<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Expression Tag -->
<%= "Welcome to Hood" %>
<!-- Scriplet Tag -->
<br>

<%= "Hello "+request.getParameter("uname") %>
<% 
String name = request.getParameter("uname");
out.print("Welcome "+name);
%>
<br>
<!-- Decleration Tag -->
<%! int age=21; %>
<%= "Age of "+request.getParameter("uname")+" is "+age %>

<br>
<%! int cube(int n){
	return n*n*n;
} %>

<br>
<%= "Cube of 5 is "+cube(5) %>
</body>
</html>