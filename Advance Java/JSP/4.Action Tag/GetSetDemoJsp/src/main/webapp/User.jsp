<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Record</title>
</head>
<body>

<jsp:useBean id="obj1" class="test.User" scope="session"/>
<jsp:setProperty name="obj1" property="*" />

Record: <br><br>

Name: <jsp:getProperty name="obj1" property="name" /><br>
Password: <jsp:getProperty name="obj1" property="password" /><br>
Email: <jsp:getProperty name="obj1" property="email" /><br><br>

<a href="second.jsp">Visit Second.jsp</a>
<a href="third.jsp">Visit Third.jsp</a>

</body>
</html>
